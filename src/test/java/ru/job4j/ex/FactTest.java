package ru.job4j.ex;

import org.junit.Test;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenException(){
        Fact fact = new Fact();
        fact.calc(-4);
    }
}