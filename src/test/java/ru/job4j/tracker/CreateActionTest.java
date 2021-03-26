package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CreateActionTest {

    @Test
    public void execute() {
        Output out = new StubOutput();
        SqlTracker tracker = new SqlTracker();
        tracker.init();
        CreateAction rep = new CreateAction(out);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn("Some name");

        rep.execute(input, tracker);

        assertThat(tracker.findAll().get(4).getName(), is("Some name"));
    }
}