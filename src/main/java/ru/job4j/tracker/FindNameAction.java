package ru.job4j.tracker;

import java.util.ArrayList;

public class FindNameAction implements UserAction{
    private final Output out;

    public FindNameAction(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "=== Find item by name ===";
    }

    @Override
    public boolean execute(Input input, Store sqlTracker) {
        String askName = input.askStr("Enter name: ");
        ArrayList<Item> items = (ArrayList<Item>) sqlTracker.findByName(askName);
        if(items.size() > 0) {
            for(Item arr:items){
                out.println(arr);
            }
        } else {
            out.println("Items not found - name is incorrect");
        }
        return true;
    }
}
