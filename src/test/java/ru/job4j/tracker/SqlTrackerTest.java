package ru.job4j.tracker;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SqlTrackerTest {
    public Connection init() {
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
            tracker.add(new Item(1, "desc"));
            assertThat(tracker.findByName("desc"), is(1));
        }
    }

    @Test
    public void whenReplace() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item1 = new Item(1, "desc");
            Item item2 = new Item(2, "name");
            tracker.add(item1);
            tracker.add(item2);
            tracker.replace(item1.getId(), item2);
            assertThat(tracker.findById(item1.getId()).getName(), is(item2.getName()));
        }
    }

    @Test
    public void whenDelete() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item1 = new Item(1, "desc");
            tracker.add(item1);
            tracker.delete(item1.getId());
            assertThat(tracker.findById(item1.getId()), is(nullValue()));
        }
    }
}