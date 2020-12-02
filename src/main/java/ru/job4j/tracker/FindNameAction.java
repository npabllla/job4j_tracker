package ru.job4j.tracker;

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
    public boolean execute(Input input, Tracker tracker) {
        String askName = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(askName);
        if(items.length > 0) {
            for(Item arr:items){
                out.println(arr);
            }
        } else {
            out.println("Items not found - name is incorrect");
        }
        return true;
    }
}
