package ru.job4j.tracker;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.*;

public class ItemTest {
    @Test
    public void sortAscending(){
        List<Item> items = new ArrayList<>();
        List<Item> expected = new ArrayList<>();
        items.add(new Item(4, "item4"));
        items.add(new Item(2, "item2"));
        items.add(new Item(1, "item1"));
        items.add(new Item(3, "item3"));
        Collections.sort(items);
        expected.add(new Item(1, "item1"));
        expected.add(new Item(2, "item2"));
        expected.add(new Item(3, "item3"));
        expected.add(new Item(4, "item4"));
        assertEquals(expected, items);
    }

    @Test
    public void sortDescending(){
        List<Item> items = new ArrayList<>();
        List<Item> expected = new ArrayList<>();
        items.add(new Item(4, "item4"));
        items.add(new Item(2, "item2"));
        items.add(new Item(1, "item1"));
        items.add(new Item(3, "item3"));
        Collections.sort(items, Collections.reverseOrder());
        expected.add(new Item(4, "item4"));
        expected.add(new Item(3, "item3"));
        expected.add(new Item(2, "item2"));
        expected.add(new Item(1, "item1"));
        assertEquals(expected, items);
    }
}