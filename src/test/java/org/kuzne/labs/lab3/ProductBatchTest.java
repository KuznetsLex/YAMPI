package org.kuzne.labs.lab3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductBatchTest {
    private static ProductBatch batch;
    @BeforeAll
    static void setUp() {
        ProductPackage web = new ProductPackage("Web", 0.02);
        WeightProduct oranges = new WeightProduct("Oranges", "Oranges in web");
        WeightProduct bananas = new WeightProduct("Bananas", "Yellow and long in web");
        WeightProductsPacked orangesPacked = new WeightProductsPacked(oranges, 3.0, web);
        WeightProductsPacked bananasPacked = new WeightProductsPacked(bananas, 5.0, web);
        ProductPackage smallBox = new ProductPackage("SmallBox", 0.3);
        MixedProductsPacked fruits = new MixedProductsPacked("Fruits", smallBox, orangesPacked, bananasPacked);
        ProductPackage wrapper = new ProductPackage("Wrapper", 0.005);
        PieceProduct barOfPicnic = new PieceProduct("Picnic", "Snack with waffles and nuts",0.12);
        PieceProductsPacked picnic = new PieceProductsPacked(barOfPicnic, 1, wrapper);
        batch = new ProductBatch("Fruits and snacks", fruits, picnic);
    }

    @Test
    void getWeight_batchWithPicnicOfWeight0dot125AndFruitsOfSumWeight8dot04_8dot165() {
        assertEquals(8.465, batch.getWeight());
    }
}