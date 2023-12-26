package org.kuzne.labs.lab4.comparator;

import org.junit.jupiter.api.Test;
import org.kuzne.labs.lab3.*;

import static org.junit.jupiter.api.Assertions.*;

class ComparatorDemoTest {
    @Test
    void calculate4() {
        ProductPackage web = new ProductPackage("Web", 0.02);
        WeightProduct oranges = new WeightProduct("Oranges", "Oranges in web");
        WeightProduct bananas = new WeightProduct("Bananas", "Yellow and long in web");
        WeightProductsPacked orangesPacked = new WeightProductsPacked(oranges, 3.0, web);
        WeightProductsPacked bananasPacked = new WeightProductsPacked(bananas, 5.0, web);
        ProductPackage smallBox = new ProductPackage("SmallBox", 0.3);
        MixedProductsPacked fruits = new MixedProductsPacked("Fruits", smallBox, orangesPacked, bananasPacked);
        ProductComparator comparator = new ProductComparator();
        ComparatorDemo.sortGoods(fruits.getProducts(),comparator);


        MixedProductsPacked fruitsSorted = new MixedProductsPacked("Fruits", smallBox, bananasPacked, orangesPacked);
        assertEquals(fruitsSorted.getProducts()[0],fruits.getProducts()[0]);
        assertEquals(fruitsSorted.getProducts()[1],fruits.getProducts()[1]);
    }

    @Test
    void calculate5() {
        ProductPackage web = new ProductPackage("Web", 0.02);
        WeightProduct oranges = new WeightProduct("Oranges", "Oranges in web");
        WeightProduct bananas = new WeightProduct("Bananas", "Yellow and long in web");
        WeightProductsPacked orangesPacked = new WeightProductsPacked(oranges, 3.0, web);
        WeightProductsPacked bananasPacked = new WeightProductsPacked(bananas, 5.0, web);
        ProductPackage smallBox = new ProductPackage("SmallBox", 0.3);
        MixedProductsPacked fruits = new MixedProductsPacked("Fruits", smallBox, orangesPacked, bananasPacked);
        ProductComparator comparator = new ProductComparator();
        ComparatorDemo.sortGoods(fruits.getProducts(),comparator);


        MixedProductsPacked fruitsSorted = new MixedProductsPacked("Fruits", smallBox, orangesPacked, bananasPacked);
        assertNotEquals(fruitsSorted.getProducts()[0],fruits.getProducts()[0]);
        assertNotEquals(fruitsSorted.getProducts()[1],fruits.getProducts()[1]);
    }
}