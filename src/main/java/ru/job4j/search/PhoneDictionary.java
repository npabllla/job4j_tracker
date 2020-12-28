package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        Predicate<Person> name = (Person) -> Person.getName().contains(key);
        Predicate<Person> surname = (Person) -> Person.getSurname().contains(key);
        Predicate<Person> address = (Person) -> Person.getAddress().contains(key);
        Predicate<Person> phone = (Person) -> Person.getPhone().contains(key);
        Predicate<Person> combine = name.or(surname).or(address).or(phone);
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}