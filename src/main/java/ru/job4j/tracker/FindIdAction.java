package ru.job4j.tracker;

public class FindIdAction implements UserAction{
    private final Output out;

    public FindIdAction(Output out){
        this.out = out;
    }
    @Override
    public String name() {
        return "=== Find item by id ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int askId = input.askInt("Enter id of item: ");
        Item item = tracker.findById(askId);
        if(item != null) {
            out.println(item);
        } else {
            out.println("Item not found - id is incorrect");
        }
        return true;
    }
}
