package ru.job4j.tracker;

public class StartUI {
    private final Output out;

    StartUI(Output out){
        this.out = out;
    }

    public void init(Input input, Store memTracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.length) {
                out.println("Wrong input, you can select: 0 .. " + (actions.length - 1));
                continue;
            }
            UserAction action = actions[select];
            run = action.execute(input, memTracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input validate = new ValidateInput(output, new ConsoleInput());
        try (Store tracker = new SqlTracker()) {
            tracker.init();
            UserAction[] actions = {
                    new CreateAction(output)
            };
            new StartUI(output).init(validate, tracker, actions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        Output output = new ConsoleOutput();
//        Input input = new ValidateInput(output, new ConsoleInput());
//        MemTracker memTracker = new MemTracker();
//        ArrayList<UserAction> actions = new ArrayList<>();
//        actions.add(new CreateAction(output));
//        actions.add(new DeleteAction(output));
//        actions.add(new EditAction(output));
//        actions.add(new FindIdAction(output));
//        actions.add(new FindNameAction(output));
//        actions.add(new ShowAction(output));
//        actions.add(new ExitAction());
//        new StartUI(output).init(input, memTracker, actions);
//    }
}
