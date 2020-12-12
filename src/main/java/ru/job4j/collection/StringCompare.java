package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        for (int i = 0; i < Math.min(left.length(), right.length()); i++) {
            int temp = Character.compare(left.charAt(i), right.charAt(i));
            if (temp != 0){
                return temp;
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}