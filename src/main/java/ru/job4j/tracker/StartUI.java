package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item(1, "Point");
        Item item1 = new Item(2, "Triangle");
        Item item2 = new Item(3, "Point");
        Item item3 = new Item(4, "Square");
        Item item4 = new Item(5, "Point");
        Tracker tracker = new Tracker();
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        System.out.println("Id: " + tracker.findById(4).getId() +"; Name: " + tracker.findById(4).getName());
        System.out.println(item.toString());

    }
}
