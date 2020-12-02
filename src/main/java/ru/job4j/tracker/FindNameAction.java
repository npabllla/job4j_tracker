package ru.job4j.tracker;

public class FindNameAction implements UserAction{
    @Override
    public String name() {
        return "=== Find item by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String askName = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(askName);
        if(items.length > 0) {
            for(Item arr:items){
                System.out.println(arr);
            }
        } else {
            System.out.println("Items not found - name is incorrect");
        }
        return true;
    }
}
