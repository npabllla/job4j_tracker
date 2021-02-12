package ru.job4j.tracker;

import java.util.ArrayList;

public class ShowAction implements UserAction {
    private final Output out;

    public ShowAction(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "=== All items ===";
    }

    @Override
    public boolean execute(Input input, Store sqlTracker) {
        ArrayList<Item> items = (ArrayList<Item>) sqlTracker.findAll();
        for (Item arr:items){
            System.out.println(arr);
        }
        return true;
    }
}
