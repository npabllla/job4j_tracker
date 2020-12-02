package ru.job4j.tracker;

public class FindIdAction implements UserAction{
    @Override
    public String name() {
        return "=== Find item by id ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int askId = input.askInt("Enter id of item: ");
        Item item = tracker.findById(askId);
        if(item != null) {
            System.out.println(item);
        } else {
            System.out.println("Item not found - id is incorrect");
        }
        return true;
    }
}
