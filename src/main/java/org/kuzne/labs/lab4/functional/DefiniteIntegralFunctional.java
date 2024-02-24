package org.kuzne.labs.lab4.functional;

import org.kuzne.labs.lab4.function.Function;

public class DefiniteIntegralFunctional<T extends Function> implements Functional<T> {
    private final double boundStart;
    private final double boundEnd;
    private final double partititions;

    public DefiniteIntegralFunctional(double boundStart, double boundEnd, double partititions) {
        if (boundStart > boundEnd) {
            throw new IllegalArgumentException("Start boundary should be smaller than end boundary");
        }
        this.boundStart = boundStart;
        this.boundEnd = boundEnd;
        this.partititions = partititions;
    }

    @Override
    public double calculate(T func) {
        if (boundStart < func.getBoundStart()) {
            throw new IllegalArgumentException("Start integration boundary is outside of the function definition range");
        }
        if (boundEnd > func.getBoundEnd()) {
            throw new IllegalArgumentException("End integration boundary is out of the function definition range");
        }


        double result = 0, h = (boundEnd - boundStart) / partititions;

        for(int i = 0; i < partititions; i++) {
            result += func.calculate(boundStart+h/2+i*h);
        }

        result *= h;
        return Math.round(result*100.0)/100.0;

    }
}
