package ru.job4j.tracker;

import org.junit.Test;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SqlTrackerTest {
    private Connection init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void createItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item1 = new Item(1, "desc");
            tracker.add(item1);
            assertThat(tracker.findByName("desc").get(0), is(item1));
        }
    }

    @Test
    public void findByNameTest() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item1 = new Item(1, "desc");
            Item item2 = new Item(2, "temp");
            Item item3 = new Item(3, "desc");
            tracker.add(item1);
            tracker.add(item2);
            tracker.add(item3);
            List<Item> expected = new ArrayList<>(List.of(item1, item3));
            assertThat(tracker.findByName("desc"), is(expected));
        }
    }

    @Test
    public void findAllTest() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item1 = new Item(1, "desc");
            Item item2 = new Item(2, "temp");
            Item item3 = new Item(3, "desc");
            tracker.add(item1);
            tracker.add(item2);
            tracker.add(item3);
            List<Item> expected = new ArrayList<>(List.of(item1, item2,item3));
            assertThat(tracker.findAll(), is(expected));
        }
    }

    @Test
    public void findByIdTest() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item1 = new Item(1, "desc");
            Item item2 = new Item(2, "temp");
            Item item3 = new Item(3, "desc");
            tracker.add(item1);
            tracker.add(item2);
            tracker.add(item3);
            assertThat(tracker.findById(Integer.toString(item1.getId())), is(item1));
        }
    }

    @Test
    public void whenReplace() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item1 = new Item(1, "desc");
            Item item2 = new Item(2, "name");
            tracker.add(item1);
            tracker.add(item2);
            tracker.replace(Integer.toString(item1.getId()), item2);
            assertThat(tracker.findById(Integer.toString(item1.getId())).getName(), is(item2.getName()));
        }
    }

    @Test
    public void whenDelete() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item1 = new Item(1, "desc");
            tracker.add(item1);
            tracker.delete(Integer.toString(item1.getId()));
            assertThat(tracker.findById(Integer.toString(item1.getId())), is(nullValue()));
        }
    }
}