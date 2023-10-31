package org.kuzne.labs.lab3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeightProductsPackedTest {
    private static WeightProductsPacked orangesPacked;
    @BeforeAll
    static void setUp() {
        ProductPackage web = new ProductPackage("Web", 0.02);
        orangesPacked = new WeightProductsPacked("Oranges", "Oranges in web", 3.0, web);
    }

    @Test
    void getNetWeight_packedOrangeWithWeight3_3() {
        assertEquals(3.0, orangesPacked.getNetWeight());
    }

    @Test
    void getGrossWeight_packedOrangeWithWeight3AndPackageWithWeight0dot02_3dot02() {
        assertEquals(3.02, orangesPacked.getGrossWeight());
    }
}