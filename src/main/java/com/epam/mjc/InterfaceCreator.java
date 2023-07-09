package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return  list -> {
            for (String value : list) {
                if (!Character.isUpperCase(value.charAt(0))) {
                    return false;
                }
            }
            return true;
        };

    }


    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return list -> {
            List<Integer> evenValues = new ArrayList<>();
            for (Integer value : list) {
                if (value % 2 == 0) {
                    evenValues.add(value);
                }
            }
            list.addAll(evenValues);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> result = new ArrayList<>();
            for (String value : values) {
                boolean startsWithUpper = Character.isUpperCase(value.charAt(0));
                boolean endsWithDot = value.endsWith(".");
                boolean hasEnoughLength = value.split(" ").length > 3;
                if (startsWithUpper && endsWithDot && hasEnoughLength) {
                    result.add(value);
                }
            }
            return result;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return list -> {
            Map<String, Integer> map = new HashMap<>();
            for (String value : list) {
                map.put(value, value.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }
}
