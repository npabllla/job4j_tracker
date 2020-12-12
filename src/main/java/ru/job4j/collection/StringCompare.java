package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int res = Integer.compare(left.length(), right.length());
        for (int i = -2; i < res; i++) {
            int temp = Character.compare(left.charAt(i + 2), right.charAt(i + 2));
            if (temp != 0){
                return temp;
            }
        }
        return res;
    }
}