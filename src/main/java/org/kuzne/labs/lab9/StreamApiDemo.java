package org.kuzne.labs.lab9;

import org.kuzne.labs.lab9.entities.Human;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamApiDemo extends LambdaDemo {

    public static final Function<List<Object>, List<Object>> FILTER_NON_NULL = list ->
            list.stream().filter(Objects::nonNull).collect(Collectors.toList());

    public static final Function<Set<Integer>, Long> COUNT_POSITIVE = set ->
            set.stream().filter(n -> n > 0).count();

    public static final Function<List<Object>, List<Object>> LAST_THREE = list ->
            list.stream().skip(Math.max(0, list.size() - 3)).collect(Collectors.toList());

    public static final Function<List<Integer>, Integer> FIRST_EVEN = list ->
            list.stream().filter(n -> n % 2 == 0).findFirst().orElse(null);

    public static final Function<Integer[], List<Integer>> SQUARE_UP = numbers ->
            Arrays.stream(numbers).map(n -> n * n).distinct().collect(Collectors.toList());

    public static final Function<List<String>, List<String>> SORT_ASCENDING = list ->
            list.stream().filter(s -> !s.isEmpty()).sorted(Comparator.naturalOrder()).collect(Collectors.toList());

    public static final Function<Set<String>, List<String>> SORT_DESCENDING = set ->
            set.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

    public static final Function<Set<Integer>, Integer> SQUARES_SUM = set ->
            set.stream().mapToInt(n -> n * n).sum();

    public static final Function<Collection<Human>, Integer> MAX_AGE = humans ->
            humans.stream().mapToInt(Human::getAge).max().orElse(0);

    public static final Function<Collection<Human>, List<Human>> SORT_BY_GENDER_THEN_AGE = humans ->
            humans.stream()
                    .sorted(Comparator.comparing(Human::getAge))
                    .sorted(Comparator.comparing(Human::getGender))
                    .collect(Collectors.toList());

}
