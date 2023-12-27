package org.kuzne.labs.lab4.comparator;

import org.kuzne.labs.lab3.Packable;
import org.kuzne.labs.lab3.Product;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorDemo {
    public static void sortGoods(Packable[] products, Comparator<Packable> comparator) {
        Arrays.sort(products, comparator);
    }
}
