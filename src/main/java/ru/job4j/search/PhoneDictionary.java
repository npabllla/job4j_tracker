package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for(Person arr:persons) {
            if (arr.getName().contains(key) || arr.getAddress().contains(key) ||
                    arr.getPhone().contains(key) || arr.getSurname().contains(key)){
                result.add(arr);
            }
        }
        return result;
    }
}