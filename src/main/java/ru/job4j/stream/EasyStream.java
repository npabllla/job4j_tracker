package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private List<Integer> source;

    public static EasyStream of(List<Integer> source) {
        return new Builder().of(source)
                .build();
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        return new Builder().of(this.source)
                .map(fun)
                .build();
    }

    public EasyStream filter(Predicate<Integer> fun) {
        return new Builder().of(this.source)
                .filter(fun)
                .build();
    }

    public List<Integer> collect() {
        return this.source;
    }

    static class Builder{
        private List<Integer> source;

        Builder of(List<Integer> source) {
            this.source = source;
            return this;
        }

        Builder map(Function<Integer, Integer> fun) {
            List<Integer> rsl = new ArrayList<>();
            for (Integer arr:source){
                rsl.add(fun.apply(arr));
            }
            source = rsl;
            return this;
        }

        Builder filter(Predicate<Integer> pred){
            List<Integer> rsl = new ArrayList<>();
            for(Integer arr:source){
                if(pred.test(arr)) {
                    rsl.add(arr);
                }
            }
            source = rsl;
            return this;
        }

        EasyStream build(){
            EasyStream easyStream = new EasyStream();
            easyStream.source = source;
            return easyStream;
        }
    }
}