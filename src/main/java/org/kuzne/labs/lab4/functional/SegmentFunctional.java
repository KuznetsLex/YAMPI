package org.kuzne.labs.lab4.functional;

import org.kuzne.labs.lab4.function.Function;

public class SegmentFunctional<T extends Function> implements Functional<T> {
    @Override
    public double calculate(T func) {
        return func.calculate(func.getBoundStart())
                + func.calculate(func.getBoundEnd())
                + func.calculate((func.getBoundStart() + func.getBoundEnd()) / 2);
    }
}
