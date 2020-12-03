package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.nullValue;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenEditItem(){
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item("Some name #1");
        tracker.add(item);
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "Other name #2", "1"}
        );
        UserAction[] actions = {
                new EditAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is("Other name #2"));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item("Item for delete");
        tracker.add(item);
        Input in = new StubInput(
                new String[] {"0",String.valueOf(item.getId()),"1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. === Exit ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenShowAll(){
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item("Firs");
        Item item1 = new Item("Second");
        tracker.add(item);
        tracker.add(item1);
        Input in = new StubInput(new String[]{
                "0","1"
        });
        UserAction[] actions = {
                new ShowAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. === All items ===" + System.lineSeparator() +
                        "1. === Exit ===" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. === All items ===" + System.lineSeparator() +
                        "1. === Exit ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByIdAction(){
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item("First");
        tracker.add(item);
        Input in = new StubInput(new String[]{
                "0",String.valueOf(item.getId()),"1"
        });
        UserAction[] actions = {
                new FindIdAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. === Find item by id ===" + System.lineSeparator() +
                        "1. === Exit ===" + System.lineSeparator() +
                        "Item{id=" + item.getId() + ", " + "name='" + item.getName() + "'}" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. === Find item by id ===" + System.lineSeparator() +
                        "1. === Exit ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByNameAction(){
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item("First");
        Item item1 = new Item("First");
        tracker.add(item);
        tracker.add(item1);
        Input in = new StubInput(new String[]{
                "0",item.getName(),"1"
        });
        UserAction[] actions = {
                new FindNameAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. === Find item by name ===" + System.lineSeparator() +
                        "1. === Exit ===" + System.lineSeparator() +
                        "Item{id=" + item.getId() + ", " + "name='" + item.getName() + "'}" + System.lineSeparator() +
                        "Item{id=" + item1.getId() + ", " + "name='" + item1.getName() + "'}" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. === Find item by name ===" + System.lineSeparator() +
                        "1. === Exit ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. === Exit ===%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. === Exit ===%n"
                )
        ));
    }
}