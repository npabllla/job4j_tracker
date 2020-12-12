package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenCompactorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompactorBySameNameAndDifferentPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("A", 1),
                new Job("A", 0)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorAscByName() {
        Comparator<Job> cmpAscByName = new JobAscByName();
        int res = cmpAscByName.compare(
                new Job("A", 0),
                new Job ("B", 0)
        );
        assertThat(res, lessThan(0));
    }

    @Test
    public void whenComparatorAscByPriority(){
        Comparator<Job> cmpAscByPriority = new JobAscByPriority();
        int res = cmpAscByPriority.compare(
                new Job("Name1",0),
                new Job("Name1",10)
        );
        assertThat(res, lessThan(0));
    }

    @Test
    public void whenComparatorDescByName(){
        Comparator<Job> cmpDescByName = new JobDescByName();
        int res = cmpDescByName.compare(
                new Job("B",0),
                new Job("A",0)
        );
        assertThat(res, lessThan(0));
    }

    @Test
    public void whenComparatorDescByPriority(){
        Comparator<Job> cmpDescByPriority = new JobDescByPriority();
        int res = cmpDescByPriority.compare(
                new Job("Name1", 10),
                new Job("Name1", 0)
        );
        assertThat(res, lessThan(0));
    }
}