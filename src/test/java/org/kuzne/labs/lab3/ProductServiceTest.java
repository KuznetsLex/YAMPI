package org.kuzne.labs.lab3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {
    private static ProductBatch batch1;
    private static ProductBatch batch2;
    private static LengthEightStringFilter filterLengthEightString;

    @BeforeAll
    static void setUp() {
        ProductPackage web = new ProductPackage("Web", 0.02);
        WeightProduct oranges = new WeightProduct("Oranges", "Oranges in web");
        WeightProduct bananas = new WeightProduct("Bananas8", "Yellow and long in web");
        WeightProductsPacked orangesPacked = new WeightProductsPacked(bananas, 3.0, web);
        WeightProductsPacked bananasPacked = new WeightProductsPacked(oranges, 5.0, web);
        ProductPackage wrapper = new ProductPackage("Wrapper", 0.005);
        PieceProduct barOfPicnic = new PieceProduct("Picnic88", "Snack with waffles and nuts",0.12);
        PieceProductsPacked picnic = new PieceProductsPacked(barOfPicnic, 1, wrapper);
        ProductPackage smallBox = new ProductPackage("SmallBox", 0.2);
        MixedProductsPacked fruits = new MixedProductsPacked("Fruits", smallBox, orangesPacked, bananasPacked);
        batch1 = new ProductBatch("Fruits and snacks", fruits, picnic);
        batch2 = new ProductBatch("Fruits", fruits);
        filterLengthEightString = new LengthEightStringFilter();
    }

    @Test
    void countByFilter_batchWithOneSurfaceNameOfLength8_1() {
        assertEquals(1, ProductService.countByFilter(batch1, filterLengthEightString));
    }

    @Test
    void countByFilterDeep_batchWithOneSurfaceAndOneDeepNameOfLength8_2() {
        assertEquals(2, ProductService.countByFilterDeep(batch1, filterLengthEightString));
    }

    @Test
    void checkAllWeighted_batchWithAllWeighted_true() {
        assertTrue(ProductService.checkAllWeighted(batch2));
    }

    @Test
    void checkAllWeighted_batchWithNotAllWeighted_true() {
        assertFalse(ProductService.checkAllWeighted(batch1));
    }
}