package org.kuzne.labs.lab4.functional;

import org.kuzne.labs.lab4.function.Function;

public class DefiniteIntegralFunctional<T extends Function> implements Functional<T> {
    private final double boundStart;
    private final double boundEnd;

    public DefiniteIntegralFunctional(double boundStart, double boundEnd) {
        if (boundStart > boundEnd) {
            throw new IllegalArgumentException("Start boundary should be smaller than end boundary");
        }
        this.boundStart = boundStart;
        this.boundEnd = boundEnd;
    }

    @Override
    public double calculate(T func) {
        if (boundStart < func.getBoundStart()) {
            throw new IllegalArgumentException("Start integration boundary is outside of the function definition range");
        }
        if (boundEnd > func.getBoundEnd()) {
            throw new IllegalArgumentException("End integration boundary is out of the function definition range");
        }
        return Math.round((func.calculate((boundStart+boundEnd)/2)) * (boundEnd-boundStart)*100.)/100.;
    }
}
