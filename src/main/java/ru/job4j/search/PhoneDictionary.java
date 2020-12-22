package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        Predicate<Person> combine = new Predicate<>() {
            @Override
            public boolean test(Person person) {
                return person.getName().contains(key) || person.getAddress().contains(key) ||
                      person.getPhone().contains(key) || person.getSurname().contains(key);
            }
        };
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}