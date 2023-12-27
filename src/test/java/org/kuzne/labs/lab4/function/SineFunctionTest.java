package org.kuzne.labs.lab4.function;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SineFunctionTest {

    @Test
    void calculate1() {
        SineFunction sin = new SineFunction(2,2,-100,100);
        assertEquals(-1.51,sin.calculate(2));
    }

    @Test
    void calculate2() {
        SineFunction sin = new SineFunction(7,9,-200,200);
        assertEquals(1.78,sin.calculate(8));
    }

    @Test
    void calculate3() {
        SineFunction sin = new SineFunction(1,1,-300,300);
        assertEquals(0.84,sin.calculate(1));
    }

    @Test
    void calculate4() {
        SineFunction sin = new SineFunction(50,1,-200,-101);
        assertThrows(IllegalArgumentException.class, ()-> sin.calculate(0));
    }
}