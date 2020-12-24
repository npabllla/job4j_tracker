package ru.job4j.stream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProfileTest {
    private List<Profile> clients = new ArrayList<>();

    @Before
    public void setUp() {
        clients.add(new Profile(new Address("SomeCity#1","SomeStreet#1", 13, 2)));
        clients.add(new Profile(new Address("SomeCity#3","SomeStreet#14", 75, 3)));
        clients.add(new Profile(new Address("SomeCity#2","SomeStreet#13", 156, 5)));
        clients.add(new Profile(new Address("SomeCity#8","SomeStreet#11", 1, 7)));
        clients.add(new Profile(new Address("SomeCity#1","SomeStreet#12", 3, 11)));
        clients.add(new Profile(new Address("SomeCity#1","SomeStreet#5", 133, 13)));
        clients.add(new Profile(new Address("SomeCity#5","SomeStreet#6", 95, 17)));
        clients.add(new Profile(new Address("SomeCity#6","SomeStreet#7", 4, 19)));
        clients.add(new Profile(new Address("SomeCity#7","SomeStreet#8", 62, 23)));
        clients.add(new Profile(new Address("SomeCity#3","SomeStreet#6", 3, 29)));

    }

    @Test
    public void whenCollect(){
        Profiles pr = new Profiles();
        List<Address> list = pr.collect(clients);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("SomeCity#1","SomeStreet#1", 13, 2));
        expected.add(new Address("SomeCity#2","SomeStreet#14", 75, 3));
        expected.add(new Address("SomeCity#3","SomeStreet#13", 156, 5));
        expected.add(new Address("SomeCity#5","SomeStreet#11", 1, 7));
        expected.add(new Address("SomeCity#6","SomeStreet#6", 95, 17));
        expected.add(new Address("SomeCity#7","SomeStreet#7", 4, 19));
        expected.add(new Address("SomeCity#8","SomeStreet#8", 62, 23));
        assertThat(expected, is(list));
    }

}