package org.kuzne.labs.lab8;

import org.kuzne.labs.lab3.ProductPackage;
import org.kuzne.labs.lab3.WeightProduct;
import org.kuzne.labs.lab3.WeightProductsPacked;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> expectedList = new HashSet<>();
        ProductPackage web = new ProductPackage("Web", 0.02);
        WeightProduct oranges = new WeightProduct("Oranges", "Oranges in web");
        System.out.println(ReflectionDemo.getSuperClasses(new WeightProductsPacked(oranges, 3.0, web)));
    }
}
