package ru.job4j.tracker;

import org.junit.Ignore;
import org.junit.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.nullValue;
@Ignore
public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Store sqlTracker = new SqlTracker();
        UserAction[] actions = new UserAction[]{
                (new CreateAction(out)),
                (new ExitAction())
        };
        new StartUI(out).init(in, sqlTracker, actions);
        assertThat(sqlTracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenEditItem() throws SQLException {
        Output out = new StubOutput();
        Store sqlTracker = new SqlTracker();
        Item item = new Item("Some name #1");
        sqlTracker.add(item);
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "Other name #2", "1"}
        );
        UserAction[] actions = new UserAction[]{
                new EditAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, sqlTracker, actions);
        assertThat(sqlTracker.findById(Integer.toString(item.getId())).getName(), is("Other name #2"));
    }

    @Test
    public void whenDeleteItem() throws SQLException {
        Output out = new StubOutput();
        Store sqlTracker = new SqlTracker();
        Item item = new Item("Item for delete");
        sqlTracker.add(item);
        Input in = new StubInput(
                new String[] {"0",String.valueOf(item.getId()),"1"}
        );
        UserAction[] actions = new UserAction[]{
                new DeleteAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, sqlTracker, actions);
        assertThat(sqlTracker.findById(Integer.toString(item.getId())), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Store sqlTracker = new SqlTracker();
        UserAction[] actions = new UserAction[]{
                new ExitAction()
        };
        new StartUI(out).init(in, sqlTracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. === Exit ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenShowAll() throws SQLException {
        Output out = new StubOutput();
        Store sqlTracker = new SqlTracker();
        Item item = new Item("Firs");
        Item item1 = new Item("Second");
        sqlTracker.add(item);
        sqlTracker.add(item1);
        Input in = new StubInput(new String[]{
                "0","1"
        });
        UserAction[] actions = new UserAction[]{
                new ShowAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, sqlTracker, actions);
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
    public void whenFindByIdAction() throws SQLException {
        Output out = new StubOutput();
        Store sqlTracker = new SqlTracker();
        Item item = new Item("First");
        sqlTracker.add(item);
        Input in = new StubInput(new String[]{
                "0",String.valueOf(item.getId()),"1"
        });
        UserAction[] actions = new UserAction[]{
                new FindIdAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, sqlTracker, actions);
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
    public void whenFindByNameAction() throws SQLException {
        Output out = new StubOutput();
        Store sqlTracker = new SqlTracker();
        Item item = new Item("First");
        Item item1 = new Item("First");
        sqlTracker.add(item);
        sqlTracker.add(item1);
        Input in = new StubInput(new String[]{
                "0",item.getName(),"1"
        });
        UserAction[] actions = new UserAction[]{
                new FindNameAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, sqlTracker, actions);
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
        Store sqlTracker = new SqlTracker();
        UserAction[] actions = new UserAction[]{
                new ExitAction()
        };
        new StartUI(out).init(in, sqlTracker, actions);
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