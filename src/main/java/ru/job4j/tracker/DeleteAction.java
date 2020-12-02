package ru.job4j.tracker;

public class DeleteAction implements UserAction{
    private final Output out;

    DeleteAction(Output out){
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Delete item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id of item: ");
        if(tracker.delete(id)){
            out.println("Deleting completed successful");
        } else {
            out.println("Deleting wasn't complete - item wasn't found");
        }
        return true;
    }
}
