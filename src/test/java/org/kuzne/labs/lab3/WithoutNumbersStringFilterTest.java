package org.kuzne.labs.lab3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WithoutNumbersStringFilterTest {
    private static WithoutNumbersStringFilter filterWithoutNumbersString;

    @BeforeAll
    static void setUp() {
        filterWithoutNumbersString = new WithoutNumbersStringFilter();
    }

    @Test
    void apply_12345678_true() {
        assertTrue(filterWithoutNumbersString.apply("one"));
    }

    @Test
    void apply_1234567_false() {
        assertFalse(filterWithoutNumbersString.apply("1"));
    }
}