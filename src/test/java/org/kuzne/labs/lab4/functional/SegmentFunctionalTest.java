package org.kuzne.labs.lab4.functional;

import org.junit.jupiter.api.Test;
import org.kuzne.labs.lab4.function.ExponentialFunction;
import org.kuzne.labs.lab4.function.LinearFunction;
import org.kuzne.labs.lab4.function.RatioFunction;
import org.kuzne.labs.lab4.function.SineFunction;

import static org.junit.jupiter.api.Assertions.*;

class SegmentFunctionalTest {

    @Test
    void calculate1() {
        SineFunction sin = new SineFunction(2,2,-100,100);
        SegmentFunctional<SineFunction> sinSeg = new SegmentFunctional<>();
        assertEquals(0.0, sinSeg.calculate(sin));
    }

    @Test
    void calculate2() {
        RatioFunction ratio = new RatioFunction(7,9,6,5,-200,200);
        SegmentFunctional<RatioFunction> ratioSeg = new SegmentFunctional<>();
        assertEquals(4.13,ratioSeg.calculate(ratio));
    }

    @Test
    void calculate3() {
        LinearFunction lin = new LinearFunction(1,1,-300,300);
        SegmentFunctional<LinearFunction> linSeg = new SegmentFunctional<>();
        assertEquals(3.0,linSeg.calculate(lin));
    }
}