package org.kuzne.labs.lab3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthEightStringFilterTest {
    private static LengthEightStringFilter filterLengthEightString;

    @BeforeAll
    static void setUp() {
        filterLengthEightString = new LengthEightStringFilter();
    }

    @Test
    void apply_12345678_true() {
        assertTrue(filterLengthEightString.apply("12345678"));
    }

    @Test
    void apply_1234567_false() {
        assertFalse(filterLengthEightString.apply("1234567"));
    }
}