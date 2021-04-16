package ru.job4j.tracker;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Ignore
public class FindIdActionTest {
    @Test
    public void execute() {
        Output out = new StubOutput();
        SqlTracker tracker = new SqlTracker();
        tracker.init();
        tracker.add(new Item(1, "Some name"));
        FindIdAction rep = new FindIdAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);

        rep.execute(input, tracker);

        assertThat(out.toString(), is("Item{" + "id=" + 1 + ", name='" + "Some name" + '\'' + '}'));
    }

}