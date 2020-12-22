package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {

    public static List<Attachment> filterSize(List<Attachment> list) {
        int point = 0;
        Predicate<Integer> pred = new Predicate<>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 100;
            }
        };
        return filter(list, point, pred);
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        int point = 1;
        Predicate<String> pred = new Predicate<>() {
            @Override
            public boolean test(String s) {
                return s.contains("Bug");
            }
        };
        return filter(list, point,pred);
    }

    public static List<Attachment> filter(List<Attachment> list, int point, Predicate pred) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (point == 0 && pred.test(att.getSize())){
                rsl.add(att);
            } else if (point == 1 && pred.test(att.getName())){
                rsl.add(att);
            }
        }
        return rsl;
    }

}
