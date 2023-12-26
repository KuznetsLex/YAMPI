package org.kuzne.labs.lab4.comparator;

import org.kuzne.labs.lab3.Packable;
import org.kuzne.labs.lab3.Product;

import java.util.Comparator;

public class ProductComparator implements Comparator<Packable> {
    @Override
    public int compare(Packable p1, Packable p2) {
        Product p1Product = (Product)p1;
        Product p2Product = (Product)p2;
        final int nameComparison = p1Product.getName().compareTo(p2Product.getName());
        return nameComparison == 0 ? p1Product.getDescription().compareTo(p2Product.getDescription()) : nameComparison;
    }
}
