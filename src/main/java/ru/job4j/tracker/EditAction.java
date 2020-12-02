package ru.job4j.tracker;

public class EditAction implements UserAction{
    @Override
    public String name() {
        return "=== Edit item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter new name: ");
        Item item = new Item(id, name);
        tracker.replace(id, item);
        if(tracker.replace(id, item)){
            System.out.println("Replace completed successful");
        } else {
            System.out.println("Replace wasn't complete - item wasn't found");
        }
        return true;
    }
}
