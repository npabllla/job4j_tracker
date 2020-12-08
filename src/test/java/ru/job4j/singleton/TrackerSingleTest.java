package ru.job4j.singleton;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertSame;

public class TrackerSingleTest {

    @Test
    public void single(){
        TrackerSingle tracker = new TrackerSingle.INSTANCE;
        TrackerSingle tracker2 = new TrackerSingle.INSTANCE;
        assertSame(tracker, tracker2);
    }

    @Test
    public void single1(){
        TrackerSingle1 tracker = new TrackerSingle1.getInstance();
        TrackerSingle1 tracker2 = new TrackerSingle1.getInstance();
        assertSame(tracker, tracker2);
    }

    @Test
    public void single2(){
        TrackerSingle2 tracker = TrackerSingle2.getInstance();
        TrackerSingle2 tracker2 = TrackerSingle2.getInstance();
        assertSame(tracker, tracker2);
    }

    @Test
    public void single3(){
        TrackerSingle3 tracker = new TrackerSingle3.getInstance();
        TrackerSingle3 tracker2 = new TrackerSingle3.getInstance();
        assertSame(tracker, tracker2);
    }
}