package org.Lab2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringProcessorTest {

    @Test
    void copy_InputStringIsEmpty_EmptyString() {
        assertEquals("", StringProcessor.copy("",3));
    }

    @Test
    void copy_HelloMultipliedByThree_HelloHelloHello() {
        assertEquals("HelloHelloHello", StringProcessor.copy("Hello",3));
    }

    @Test
    void copy_StringMultipliedByNegativeNumber_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> StringProcessor.copy("String",-1));
    }
    @Test
    void copy_StringMultipliedByZero_EmptyString() {
        assertEquals("",StringProcessor.copy("String",0));
    }

    @Test
    void insertionsCount_secondStringIsEmpty_IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> StringProcessor.insertionsCount("String",""));
    }

    @Test
    void insertionsCount_firstStringIsStringSecondStringIsString1_0() {
        assertEquals(0, StringProcessor.insertionsCount("String", "String1"));
    }

    @Test
    void insertionsCount_firstStringIsString1SecondStringIsString_1() {
        assertEquals(1, StringProcessor.insertionsCount("String1", "String"));
    }

    @Test
    void insertionsCount_firstStringIsStringString1SecondStringIsString_2() {
        assertEquals(2, StringProcessor.insertionsCount("StringString1", "String"));
    }
    @Test
    void numbersToText_123_OneTwoThree() {
        assertEquals("один два три", StringProcessor.numbersToText("1 2 3"));
    }

    @Test
    void numbersToText_minus101234_minus10OneTwoThree4() {
        assertEquals("-один 0 один два три 4", StringProcessor.numbersToText("-1 0 1 2 3 4"));
    }
    @Test
    void numbersToText_1Sheep2Sheeps3Sheeps4Sheeps_OneSheepTwoSheepsThreeSheeps4Sheeps() {
        assertEquals("один Sheep, два Sheeps, три Sheeps, 4 Sheeps", StringProcessor.numbersToText("1 Sheep, 2 Sheeps, 3 Sheeps, 4 Sheeps"));
    }
    @Test
    void deleteEverySecond_12345_135() {
        StringBuilder input = new StringBuilder("12345");
        assertEquals("135", StringProcessor.deleteEverySecond(input).toString());
    }
    @Test
    void deleteEverySecond_123456_135() {
        StringBuilder input = new StringBuilder("123456");
        assertEquals("135", StringProcessor.deleteEverySecond(input).toString());
    }
}