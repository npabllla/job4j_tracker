package ru.job4j.stream;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import java.util.List;

import static org.junit.Assert.*;

public class MatrixToListTest {
    @Test
    public void when(){
        Integer[][] input = new Integer[][]{
                {1,2,3},
                {3,5,7},
                {7,9,11}
        };
        List<Integer> rsl =  MatrixToList.matrixToList(input);
        List<Integer> expected = List.of(1, 2, 3, 3, 5, 7, 7, 9, 11);
        assertThat(expected, is(rsl));
    }
}