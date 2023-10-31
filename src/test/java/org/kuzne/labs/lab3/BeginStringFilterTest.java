package org.kuzne.labs.lab3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeginStringFilterTest {
    private static String string;
    private static BeginStringFilter filter1;
    private static BeginStringFilter filter2;
    @BeforeAll
    static void setUp() {
        string = "Мама мыла раму";
        filter1 = new BeginStringFilter("Мама");
        filter2 = new BeginStringFilter("мыла");
    }

    @Test
    void apply_mom_true() {
        assertTrue(filter1.apply(string));
    }

    @Test
    void apply_washed_false() {
        assertFalse(filter2.apply(string));
    }
}