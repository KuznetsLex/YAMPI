package org.kuzne.labs.lab3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MixedProductsPackedTest {
    private static MixedProductsPacked fruits;

    @BeforeAll
    static void setUp() {
        ProductPackage web = new ProductPackage("Web", 0.02);
        WeightProductsPacked orangesPacked = new WeightProductsPacked("Oranges", "Oranges in web", 3.0, web);
        WeightProductsPacked bananasPacked = new WeightProductsPacked("Bananas", "Yellow and long in web", 5.0, web);
        //TODO: ЕСЛИ smallBox будет весить 0.2, то все сломается изза непредставимости числа
        ProductPackage smallBox = new ProductPackage("SmallBox", 0.3);
        fruits = new MixedProductsPacked("Fruits", smallBox, orangesPacked, bananasPacked);
    }

    @Test
    void getNetWeight_mixedProductsPackedWithWeightsOf5dot002And3dot002_8dot04() {
        assertEquals(8.04, fruits.getNetWeight());
    }

    @Test
    void getGrossWeight_mixedProductsPackedWithWeightsOf5dot002And3dot002AndPackageWithWeightOf0dot2_8dot24() {
        assertEquals(8.34, fruits.getGrossWeight());
    }
}