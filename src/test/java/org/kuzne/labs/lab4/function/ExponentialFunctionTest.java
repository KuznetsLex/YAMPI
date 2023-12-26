package org.kuzne.labs.lab4.function;

import org.junit.jupiter.api.Test;
import org.kuzne.labs.lab4.functional.DefiniteIntegralFunctional;

import static org.junit.jupiter.api.Assertions.*;

class ExponentialFunctionTest {

    @Test
    void calculate1() {
        ExponentialFunction exp = new ExponentialFunction(2,2,-100,100);
        assertEquals(16.78,exp.calculate(2));
    }

    @Test
    void calculate2() {
        ExponentialFunction exp = new ExponentialFunction(7,9,-200,200);
        assertEquals(20875.71,exp.calculate(8));
    }

    @Test
    void calculate3() {
        ExponentialFunction exp = new ExponentialFunction(1,1,-300,300);
        assertEquals(3.72,exp.calculate(1));
    }

    @Test
    void calculate4() {
        ExponentialFunction exp = new ExponentialFunction(50,1,-200,-101);
        assertThrows(IllegalArgumentException.class, ()-> exp.calculate(0));
    }
}