package ru.job4j.collection;

import java.util.*;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        Map<Character, Integer> map = new HashMap<>();
        if(left.length() < right.length()) {
            return false;
        }
        if(left.equals(right)) {
            return false;
        }
        for (char key : left.toCharArray()) {
            int count = 1;
            if (map.containsKey(key)) {
                count = map.get(key);
                count++;
            }
            map.put(key,count);
        }
        for(Character arr : right.toCharArray()) {
            if (!map.containsKey(arr)) {
                return false;
            } else if (map.containsKey(arr) && map.get(arr) == 1) {
                map.remove(arr);
            } else if (map.containsKey(arr) && map.get(arr) > 1) {
                map.put(arr, map.get(arr)-1);
            }
        }
        return map.size() == 0;
    }
}