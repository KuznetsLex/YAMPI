package org.kuzne.labs.lab4.functional;

import org.kuzne.labs.lab4.function.Function;

public interface Functional<T extends Function> {
    double calculate(T function);
}
