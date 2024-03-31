package org.kuzne.labs.lab5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiagMatrixTest {

    @Test
    void changeElem_1() {
        double[] diagElems = new double[]{1,2,3};
        Matrix diagMatrix = new DiagMatrix(diagElems);
        diagMatrix.changeElem(1,1,100);
        assertEquals(100, diagMatrix.getElem(1,1));
    }

    @Test
    void changeElem_2() {
        double[] diagElems = new double[]{1,2,3};
        Matrix diagMatrix = new DiagMatrix(diagElems);
        assertThrows(IllegalArgumentException.class, ()-> diagMatrix.changeElem(0,1,100));
    }

    @Test
    void changeElem_3() {
        double[] diagElems = new double[]{1,2,3};
        Matrix diagMatrix = new DiagMatrix(diagElems);
        assertThrows(IllegalArgumentException.class, ()-> diagMatrix.changeElem(2,1,100));
    }

    @Test
    void calculateDeterminant_1() {
        double[] diagElems = new double[]{1,2,3};
        Matrix diagMatrix = new DiagMatrix(diagElems);
        assertEquals(6, diagMatrix.calculateDeterminant());
    }

    @Test
    void calculateDeterminant_2() {
        double[] diagElems = new double[]{1,0,3};
        Matrix diagMatrix = new DiagMatrix(diagElems);
        assertEquals(0, diagMatrix.calculateDeterminant());
    }

    @Test
    void calculateDeterminant_3() {
        double[] diagElems = new double[]{0};
        Matrix diagMatrix = new DiagMatrix(diagElems);
        assertEquals(0, diagMatrix.calculateDeterminant());
    }
}