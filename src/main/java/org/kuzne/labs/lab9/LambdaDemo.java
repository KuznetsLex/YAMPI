package org.kuzne.labs.lab9;

import org.kuzne.labs.lab9.entities.Human;
import org.kuzne.labs.lab9.entities.QuadPredicate;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaDemo {

    public static final Function<String, Integer> LENGTH = String::length;

    public static final Function<String, Character> FIRST_CHAR =
            str ->
                    str.isEmpty() ? null : str.charAt(0);

    public static final Predicate<String> NO_SPACES =
            str ->
                    !str.contains(" ");

    // 1.4
    public static final Function<String, Integer> WORDS_COUNT =
            str ->
                    str.isEmpty() ? 0 : str.split(",").length;

    // 1.5
    public static final Function<Human, Integer> HUMAN_AGE = Human::getAge;

    // 1.6
    public static final BiPredicate<Human, Human> SAME_SURNAMES =
            (h1, h2) ->
                    (h1.getLastName().equals(h2.getLastName()));

    // 1.7
    public static final Function<Human, String> HUMAN_FULLNAME =
            h ->
                    String.format("%s %s %s", h.getLastName(), h.getFirstName(), h.getPatronymic());

    // 1.8
    public static final Function<Human, Human> HUMAN_INCREMENTED_AGE =
            h ->
                    new Human(h.getLastName(), h.getFirstName(), h.getPatronymic(), h.getGender(), h.getAge() + 1);

    // 1.9
    public static final QuadPredicate<Human, Human, Human, Integer> ARE_ALL_YOUNGER_THAN =
            (h1, h2, h3, maxAge)
                    -> h1.getAge() < maxAge && h2.getAge() < maxAge && h3.getAge() < maxAge;
}
