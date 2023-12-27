package org.kuzne.labs.lab3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceProductsPackedTest {
    private static PieceProductsPacked picnic;
    @BeforeAll
    static void setUp() {
        ProductPackage wrapper = new ProductPackage("Wrapper", 0.005);
        PieceProduct barOfPicnic = new PieceProduct("Picnic", "Snack with waffles and nuts",0.12);
        picnic = new PieceProductsPacked(barOfPicnic, 2, wrapper);
    }

    @Test
    void getNetWeight_picnicWithWeight0dot12_0dot12() {
        assertEquals(0.24, picnic.getNetWeight());
    }

    @Test
    void getGrossWeight_picnicWithWeight0dot12AndWrapperWithWeight0dot005_0dot125() {
        assertEquals(0.245, picnic.getGrossWeight());
    }
}