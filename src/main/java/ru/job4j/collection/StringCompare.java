package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        if(left.length() > right.length()){
            for (int i = right.length(); i < left.length(); i++) {
                right += "0";
            }
        } else if (left.length() < right.length()) {
            for (int i = left.length(); i < right.length(); i++) {
                left += "0";
            }
        }
        for (int i = 0; i < left.length(); i++) {
            if(left.charAt(i) != right.charAt(i)){
                if(left.charAt(i) > right.charAt(i)){
                    return 1;
                } else {
                    return -1;
                }
            }
        }
        return 0;
    }
}