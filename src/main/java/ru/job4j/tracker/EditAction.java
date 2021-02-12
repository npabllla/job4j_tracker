package ru.job4j.tracker;

public class EditAction implements UserAction{
    private final Output out;

    public EditAction(Output out){
        this.out = out;
    }
    @Override
    public String name() {
        return "=== Edit item ===";
    }

    @Override
    public boolean execute(Input input, Store sqlTracker) {
        String id = input.askStr("Enter id: ");
        String name = input.askStr("Enter new name: ");
        Item item = new Item(Integer.parseInt(id), name);
        sqlTracker.replace(id, item);
        if(sqlTracker.replace(id, item)){
            out.println("Replace completed successful");
        } else {
            out.println("Replace wasn't complete - item wasn't found");
        }
        return true;
    }
}
