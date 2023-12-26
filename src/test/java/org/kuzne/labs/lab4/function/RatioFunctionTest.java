package org.kuzne.labs.lab4.function;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RatioFunctionTest {

    @Test
    void calculate1() {
        RatioFunction ratio = new RatioFunction(2,2,2,2,-100,100);
        assertEquals(1.0,ratio.calculate(2));
    }

    @Test
    void calculate2() {
        RatioFunction ratio = new RatioFunction(7,9,6,5,-200,200);
        assertEquals(1.23,ratio.calculate(8));
    }

    @Test
    void calculate3() {
        RatioFunction ratio = new RatioFunction(1,1,1,1,-300,300);
        assertEquals(1.0,ratio.calculate(1));
    }

    @Test
    void calculate4() {
        RatioFunction ratio = new RatioFunction(50,1,-200,-101,-200,-101);
        assertThrows(IllegalArgumentException.class, ()-> ratio.calculate(0));
    }
}