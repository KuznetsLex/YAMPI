package org.kuzne.labs.lab4.function;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinearFunctionTest {

    @Test
    void calculate1() {
        LinearFunction lin = new LinearFunction(2,2,-100,100);
        assertEquals(6.0, lin.calculate(2));
    }

    @Test
    void calculate2() {
        LinearFunction lin = new LinearFunction(7,9,-200,200);
        assertEquals(65.0, lin.calculate(8));
    }

    @Test
    void calculate3() {
        LinearFunction lin = new LinearFunction(1,1,-300,300);
        assertEquals(2, lin.calculate(1));
    }
    @Test
    void calculate4() {
        LinearFunction lin = new LinearFunction(50,1,-200,-101);
        assertThrows(IllegalArgumentException.class, ()-> lin.calculate(0));
    }
}