package org.kuzne.labs.lab9;

import org.kuzne.labs.lab9.entities.QuadPredicate;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaRunner {

    public static <A, B> B function(Function<A, B> function, A arg) {
        return function.apply(arg);
    }

    public static <T> boolean predicate(Predicate<T> predicate, T arg) {
        return predicate.test(arg);
    }

    public static <A, B> boolean biPredicate(BiPredicate<A, B> predicate, A arg1, B arg2) {
        return predicate.test(arg1, arg2);
    }

    public static <A, B, C, D> boolean quadPredicate(
            QuadPredicate<A, B, C, D> predicate,
            A arg1, B arg2, C arg3, D arg4
    ) {
        return predicate.test(arg1, arg2, arg3, arg4);
    }

}
