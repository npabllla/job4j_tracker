package ru.job4j.tracker;

import java.sql.SQLException;

public class CreateAction implements UserAction {
    private final Output out;

    public CreateAction(Output out){
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Create new item ===";
    }

    @Override
    public boolean execute(Input input, Store sqlTracker) {
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        try {
            sqlTracker.add(item);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }
}
