package ru.job4j.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SchoolTest {
    private List<Student> students = new ArrayList<>();

    @Before
    public void setUp() {
        students.add(new Student(-10, "SurnameLess"));
        students.add(new Student(10, "Surname1"));
        students.add(new Student(20, "Surname2"));
        students.add(new Student(30, "Surname3"));
        students.add(new Student(40, "Surname4"));
        students.add(new Student(50, "Surname5"));
        students.add(new Student(60, "Surname6"));
        students.add(new Student(70, "Surname7"));
        students.add(new Student(80, "Surname8"));
        students.add(new Student(90, "Surname9"));
        students.add(new Student(110, "SurnameMore"));
    }

    @Test
    public void whenCollectClassA() {
        School sc = new School();
        Map<String, Integer> rsl = sc.collect(students, pr -> pr.getScore() >= 70
                                        && pr.getScore() <=100);
        Map<String, Integer> expected = new HashMap<>();
        expected.put("Surname7", 70);
        expected.put( "Surname8", 80);
        expected.put("Surname9", 90);
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollectClassB() {
        School sc = new School();
        Map<String, Integer> rsl = sc.collect(students, pr -> pr.getScore() >= 50
                                        && pr.getScore() < 70);
        Map<String, Integer> expected = new HashMap<>();
        expected.put("Surname5", 50);
        expected.put("Surname6", 60);
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollectClassC() {
        School sc = new School();
        Map<String, Integer> rsl = sc.collect(students, pr -> pr.getScore() < 50
                                        && pr.getScore() >= 0);
        Map<String, Integer> expected = new HashMap<>();
        expected.put("Surname1", 10);
        expected.put("Surname2", 20);
        expected.put("Surname3", 30);
        expected.put("Surname4", 40);
        assertThat(rsl, is(expected));
    }
}