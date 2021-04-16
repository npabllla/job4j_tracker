package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class HbmTrackerTest {
    @Test
    public void whenFindAllReturnValue() {
        HbmTracker hbmTracker = new HbmTracker();
        Item item = new Item();
        Item item1 = new Item();
        item.setName("name1");
        item1.setName("name2");
        List<Item> expected = List.of(item, item1);
        hbmTracker.add(item);
        hbmTracker.add(item1);
        assertThat(hbmTracker.findAll(), is(expected));
    }

    @Test
    public void whenFindByNameReturnValue() {
        HbmTracker hbmTracker = new HbmTracker();
        Item item = new Item();
        item.setName("name1");
        List<Item> expected = List.of(item);
        hbmTracker.add(item);
        assertThat(hbmTracker.findByName("name1"), is(expected));
    }

    @Test
    public void whenFindByIdReturnValue() {
        HbmTracker hbmTracker = new HbmTracker();
        Item item = new Item();
        item.setName("name1");
        hbmTracker.add(item);
        assertThat(hbmTracker.findById("1"), is(item));
    }

    @Test
    public void whenFindByIdReturnNull() {
        HbmTracker hbmTracker = new HbmTracker();
        assertNull(hbmTracker.findById("1"));
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        HbmTracker hbmTracker = new HbmTracker();
        Item item = new Item();
        item.setName("test1");
        hbmTracker.add(item);
        Item result = hbmTracker.findById(Integer.toString(item.getId()));
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplace() {
        HbmTracker hbmTracker = new HbmTracker();
        Item bug = new Item();
        bug.setName("Bug");
        hbmTracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        hbmTracker.replace(Integer.toString(id), bugWithDesc);
        assertThat(hbmTracker.findById(Integer.toString(id)).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        HbmTracker hbmTracker = new HbmTracker();
        Item bug = new Item();
        bug.setName("Bug");
        hbmTracker.add(bug);
        int id = bug.getId();
        hbmTracker.delete(Integer.toString(id));
        assertThat(hbmTracker.findById(Integer.toString(id)), is(nullValue()));
    }
}