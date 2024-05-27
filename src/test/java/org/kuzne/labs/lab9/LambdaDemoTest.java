package org.kuzne.labs.lab9;

import org.kuzne.labs.lab9.entities.Human;
import org.junit.jupiter.api.Test;
import org.kuzne.labs.lab9.entities.Student;

import static org.kuzne.labs.lab9.LambdaDemo.*;
import static org.kuzne.labs.lab9.LambdaRunner.*;
import static org.junit.jupiter.api.Assertions.*;

public class LambdaDemoTest {

    @Test
    public void lengthTest() {
        assertEquals(0, function(LENGTH, ""));
        assertEquals(8, function(LENGTH, "12 34 56"));
        assertEquals(9, function(LENGTH, "123456789"));
    }

    @Test
    public void firstCharTest() {
        assertNull(function(FIRST_CHAR, ""));

        assertEquals('1', function(FIRST_CHAR, "123456"));
        assertEquals('a', function(FIRST_CHAR, "abc"));
        assertEquals(' ', function(FIRST_CHAR, " abc"));
    }

    @Test
    public void noSpacesTest() {
        assertTrue(predicate(NO_SPACES, ""));
        assertTrue(predicate(NO_SPACES, "oeroghier"));
        assertFalse(predicate(NO_SPACES, "1 2 3 4 5"));
        assertFalse(predicate(NO_SPACES, " "));
    }

    @Test
    public void wordsCountTest() {
        assertEquals(0, function(WORDS_COUNT, ""));
        assertEquals(1, function(WORDS_COUNT, "123"));
        assertEquals(1, function(WORDS_COUNT, "1 2 3"));
        assertEquals(3, function(WORDS_COUNT, "1,2,3"));
        assertEquals(3, function(WORDS_COUNT, "1, 2, 3"));
    }

    @Test
    public void humanAgeTest() {
        final Student human = new Student(
                "Кузнецов",
                "Алексей",
                "Борисович",
                Human.Gender.MALE, 19, "OmSU", "FCTK", "Math"
        );
        assertEquals(19, function(HUMAN_AGE, human));
    }

    @Test
    public void sameSurnamesTest() {
        final Human human1 = new Human("Кузнецов", "Алексей", "Борисович", Human.Gender.FEMALE, 19);
        final Student human2 = new Student("Кузнецов", "Алексей", "Борисович", Human.Gender.FEMALE, 19, "OmSU", "FCTK", "Math");
        final Human human3 = new Human("Деришева", "Екатерина", "Максимовна", Human.Gender.MALE, 20);

        assertTrue(biPredicate(SAME_SURNAMES, human1, human2));
        assertFalse(biPredicate(SAME_SURNAMES, human2, human3));
    }

    @Test
    public void fullNameTest() {
        final Human human = new Human("Кузнецов", "Алексей", "Борисович", Human.Gender.MALE, 19);
        assertEquals("Кузнецов Алексей Борисович", function(HUMAN_FULLNAME, human));
    }

    @Test
    public void humanIncrementedAgeTest() {
        final Human input = new Human("Кузнецов", "Алексей", "Борисович", Human.Gender.MALE, 19);
        final Human output = new Human("Кузнецов", "Алексей", "Борисович", Human.Gender.MALE, 20);
        assertEquals(output, function(HUMAN_INCREMENTED_AGE, input));
    }

    @Test
    public void allYoungerThanTest() {
        final Human human1 = new Human("Кузнецов", "Алексей", "Борисович", Human.Gender.MALE, 19);
        final Human human2 = new Human("Деришева", "Екатерина", "Максимовна", Human.Gender.FEMALE, 24);
        final Human human3 = new Human("Кузнецов", "Вайбослав", "Алексеевич", Human.Gender.FEMALE, 1);

        assertTrue(quadPredicate(ARE_ALL_YOUNGER_THAN, human1, human2, human3, 25));
        assertFalse(quadPredicate(ARE_ALL_YOUNGER_THAN, human1, human2, human3, 20));
        assertFalse(quadPredicate(ARE_ALL_YOUNGER_THAN, human1, human2, human3, 0));
    }
}
