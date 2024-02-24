package org.kuzne.labs.lab4.functional;

import org.junit.jupiter.api.Test;
import org.kuzne.labs.lab4.function.ExponentialFunction;
import org.kuzne.labs.lab4.function.LinearFunction;
import org.kuzne.labs.lab4.function.RatioFunction;

import static org.junit.jupiter.api.Assertions.*;

class DefiniteIntegralFunctionalTest {

    @Test
    void calculate1() {
        DefiniteIntegralFunctional<ExponentialFunction> expIntegral = new DefiniteIntegralFunctional<>(-5,5,1000);
        ExponentialFunction exp = new ExponentialFunction(2,2,-5,5);
        assertEquals(316.81, expIntegral.calculate(exp));
    }

    @Test
    void calculate2() {
        DefiniteIntegralFunctional<RatioFunction> ratioIntegral = new DefiniteIntegralFunctional<>(10,50,1000);
        RatioFunction ratio = new RatioFunction(7,9,6,5,10,50);
        assertEquals(47.49,ratioIntegral.calculate(ratio));
    }

    @Test
    void calculate3() {
        DefiniteIntegralFunctional<LinearFunction> linearIntegral = new DefiniteIntegralFunctional<>(0,100,1000);
        LinearFunction lin = new LinearFunction(1,1,0,100);
        assertEquals(5100.0,linearIntegral.calculate(lin));
    }

    @Test
    void calculate4() {
        DefiniteIntegralFunctional<LinearFunction> linearIntegral = new DefiniteIntegralFunctional<>(-100,100,1000);
        LinearFunction func2 = new LinearFunction(50,1,-200,-101);
        assertThrows(IllegalArgumentException.class, ()-> linearIntegral.calculate(func2));
    }


}