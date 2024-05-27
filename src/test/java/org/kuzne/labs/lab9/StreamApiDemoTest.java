package org.kuzne.labs.lab9;

import org.kuzne.labs.lab9.entities.Human;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.kuzne.labs.lab9.LambdaRunner.function;
import static org.kuzne.labs.lab9.StreamApiDemo.*;
import static org.junit.jupiter.api.Assertions.*;

public class StreamApiDemoTest {

    @Test
    public void filterNonNullTest() {
        final List<Object> input = Arrays.stream(new Object[] {null, 0, null, new ArrayList<>()}).toList();
        final List<Object> output = List.of(0, new ArrayList<>());
        assertIterableEquals(output, function(FILTER_NON_NULL, input));
    }

    @Test
    public void countPositiveTest() {
        assertEquals(0, function(COUNT_POSITIVE, Collections.emptySet()));
        assertEquals(3, function(COUNT_POSITIVE, Set.of(-3, -2, -1, 0, 1, 2, 3)));
        assertEquals(0, function(COUNT_POSITIVE, Set.of(-3, -2, -1)));
    }

    @Test
    public void lastThreeTest() {
        assertEquals(Collections.emptyList(), function(LAST_THREE, Collections.emptyList()));
        assertEquals(List.of("B", "C"), function(LAST_THREE, List.of("B", "C")));
        assertEquals(List.of("A", "B", "C"), function(LAST_THREE, List.of("A", "B", "C")));
        assertEquals(List.of("A", "B", "D"), function(LAST_THREE, List.of("E", "F", "G", "H", "I", "A", "B", "D")));
    }

    @Test
    public void firstEvenTest() {
        assertNull(function(FIRST_EVEN, Collections.emptyList()));
        assertNull(function(FIRST_EVEN, List.of(1, 3, 5)));
        assertEquals(0, function(FIRST_EVEN, List.of(-1, 0, 2, 4, 8)));
    }

    @Test
    public void squareUpTest() {
        final Integer[] input = {-1, 1, 2, -3, 3, 4, -5, 5};
        final List<Integer> output = List.of(1, 4, 9, 16, 25);
        assertEquals(output, function(SQUARE_UP, input));
    }

    @Test
    public void sortAscendingTest() {
        final List<String> input = List.of(
                "Алексей",
                "Екатерина",
                "Дмитрий",
                "Мария",
                "Владимир",
                "Анна",
                "",
                "Вероника"
        );

        final List<String> output = List.of(
                "Алексей",
                "Анна",
                "Вероника",
                "Владимир",
                "Дмитрий",
                "Екатерина",
                "Мария"
        );
        assertEquals(output, function(SORT_ASCENDING, input));
    }

    @Test
    public void sortDescendingTest() {
        final Set<String> input = Set.of(
                "Алексей",
                "Екатерина",
                "Дмитрий",
                "Мария",
                "Владимир",
                "Анна",
                "Вероника"
        );

        final List<String> output = List.of(
                "Мария",
                "Екатерина",
                "Дмитрий",
                "Владимир",
                "Вероника",
                "Анна",
                "Алексей"
        );

        assertEquals(output, function(SORT_DESCENDING, input));
    }

    @Test
    public void squaresSumTest() {
        assertEquals(0, function(SQUARES_SUM, Set.of(0)));
        assertEquals(55, function(SQUARES_SUM, Set.of(-1, 2, -3, 4, -5)));
    }

    @Test
    public void maxAgeTest() {
        final List<Human> humans = List.of(
                new Human("Деришева", "Екатерина", "Максимовна", Human.Gender.FEMALE, 20),
                new Human("Кузнецов", "Алексей", "Борисович", Human.Gender.MALE, 19),
                new Human("Федорова", "Екатерина", "Дмитриевна", Human.Gender.FEMALE, 45),
                new Human("Михайлов", "Дмитрий", "Андреевич", Human.Gender.MALE, 28),
                new Human("Николаева", "Анна", "Сергеевна", Human.Gender.FEMALE, 24),
                new Human("Алексеев", "Алексей", "Владимирович",  Human.Gender.MALE, 45),
                new Human("Смирнов", "Алексей", "Александрович", Human.Gender.MALE, 33)
        );

        assertEquals(45, function(MAX_AGE, humans));
    }

    @Test
    public void sortByGenderThenAge() {
        final List<Human> input = List.of(
                new Human("Деришева", "Екатерина", "Максимовна", Human.Gender.FEMALE, 28),
                new Human("Кузнецов", "Алексей", "Борисович", Human.Gender.MALE, 19),
                new Human("Федорова", "Екатерина", "Дмитриевна", Human.Gender.FEMALE, 45),
                new Human("Михайлов", "Дмитрий", "Андреевич", Human.Gender.MALE, 28),
                new Human("Николаева", "Анна", "Сергеевна", Human.Gender.FEMALE, 24),
                new Human("Алексеев", "Алексей", "Владимирович",  Human.Gender.MALE, 45),
                new Human("Смирнов", "Алексей", "Александрович", Human.Gender.MALE, 33)
        );

        final List<Human> output = List.of(
                new Human("Кузнецов", "Алексей", "Борисович", Human.Gender.MALE, 19),
                new Human("Михайлов", "Дмитрий", "Андреевич", Human.Gender.MALE, 28),
                new Human("Смирнов", "Алексей", "Александрович", Human.Gender.MALE, 33),
                new Human("Алексеев", "Алексей", "Владимирович",  Human.Gender.MALE, 45),
                new Human("Николаева", "Анна", "Сергеевна", Human.Gender.FEMALE, 24),
                new Human("Деришева", "Екатерина", "Максимовна", Human.Gender.FEMALE, 28),
                new Human("Федорова", "Екатерина", "Дмитриевна", Human.Gender.FEMALE, 45)
        );

        assertIterableEquals(output, function(SORT_BY_GENDER_THEN_AGE, input));
    }
}
