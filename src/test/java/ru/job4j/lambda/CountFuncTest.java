package ru.job4j.lambda;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CountFuncTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = CountFunc.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
       assertThat(result, is(expected));
    }

    @Test
    public void whenSquareFunction() {
        List<Double> result = CountFunc.diapason(5, 8, x -> Math.pow(x, 2) + 1);
        List<Double> expected = Arrays.asList(26D, 37D, 50D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponential() {
        List<Double> result = CountFunc.diapason(5, 8, x -> Math.pow(2, x) + 1);
        List<Double> expected = Arrays.asList(33D, 65D, 129D);
        assertThat(result, is(expected));
    }
}