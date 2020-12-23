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
        Predicate<Person> name = new Predicate<>() {
            @Override
            public boolean test(Person person) {
                return person.getName().contains(key);
            }
        };
        Predicate<Person> surname = new Predicate<>() {
            @Override
            public boolean test(Person person) {
                return person.getSurname().contains(key);
            }
        };
        Predicate<Person> address = new Predicate<>() {
            @Override
            public boolean test(Person person) {
                return person.getAddress().contains(key);
            }
        };
        Predicate<Person> phone = new Predicate<>() {
            @Override
            public boolean test(Person person) {
                return person.getPhone().contains(key);
            }
        };
        Predicate<Person> combine = new Predicate<>() {
            @Override
            public boolean test(Person person) {
                return name.or(surname.or(address.or(phone))).test(person);
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