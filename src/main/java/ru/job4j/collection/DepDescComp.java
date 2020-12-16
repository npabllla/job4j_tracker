package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] o1s = o1.split("/");
        String[] o2s = o2.split("/");
        int rsl = o1s[0].compareTo(o2s[0]);
        if (rsl != 0) {
            return rsl;
        } else {
            return o1.compareTo(o2);
        }
    }
}