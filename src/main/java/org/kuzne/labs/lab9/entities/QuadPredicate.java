package org.kuzne.labs.lab9.entities;

@FunctionalInterface
public interface QuadPredicate<A, B, C, D> {
    boolean test(A t, B u, C w, D v);
}
