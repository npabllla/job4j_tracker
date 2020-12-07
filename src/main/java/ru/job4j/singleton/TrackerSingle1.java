package ru.job4j.singleton;

import ru.job4j.tracker.Item;

public class TrackerSingle1 {
    private static TrackerSingle1 instance;

    private TrackerSingle1() {
    }

    public static TrackerSingle1 getInstance() {
        if (instance == null) {
            instance = new TrackerSingle1();
        }
        return instance;
    }

    public Item add(Item model) {
        return model;
    }
}