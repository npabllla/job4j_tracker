package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindNameActionTest {

    @Test
    public void execute() {
        Output out = new StubOutput();
        SqlTracker tracker = new SqlTracker();
        tracker.init();
        tracker.add(new Item(1, "Some name"));
        FindNameAction rep = new FindNameAction(out);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn("Some name");

        rep.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Item{" + "id=" + 1 + ", name='" + "Some name" + '\'' + '}'));
    }
}