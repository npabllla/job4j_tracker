package ru.job4j.collection;

import java.util.*;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        char[] chLeft = left.toCharArray();
        char[] chRight = right.toCharArray();
        if(Arrays.equals(chLeft,chRight)){
            return false;
        }
        Arrays.sort(chLeft);
        Arrays.sort(chRight);

        return Arrays.equals(chLeft,chRight);
    }
}