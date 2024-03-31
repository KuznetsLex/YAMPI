package org.kuzne.labs.lab5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    void getElem_1() {
        int N = 3;
        Matrix matrix = new Matrix(N);
        double[] inputArr = new double[]{1,2,3,4,5,6,7,8,9};
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                matrix.changeElem(i, j, inputArr[i*N+j]);
            }
        }
        assertEquals(1, matrix.getElem(0,0));
    }

    @Test
    void getElem_2() {
        int N = 3;
        Matrix matrix = new Matrix(N);
        double[] inputArr = new double[]{1,2,3,4,5,6,7,8,9};
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                matrix.changeElem(i, j, inputArr[i*N+j]);
            }
        }
        assertEquals(3, matrix.getElem(0,2));
    }

    @Test
    void getElem_3() {
        int N = 3;
        Matrix matrix = new Matrix(N);
        double[] inputArr = new double[]{1,2,3,4,5,6,7,8,9};
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                matrix.changeElem(i, j, inputArr[i*N+j]);
            }
        }
        assertEquals(9, matrix.getElem(2,2));
    }

    @Test
    void changeElem_1() {
        int N = 3;
        Matrix matrix = new Matrix(N);
        double[] inputArr = new double[]{1,2,3,4,5,6,7,8,9};
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                matrix.changeElem(i, j, inputArr[i*N+j]);
            }
        }
        matrix.changeElem(0,2,10);
        assertEquals(10, matrix.getElem(0,2));
    }

    @Test
    void changeElem_2() {
        int N = 3;
        Matrix matrix = new Matrix(N);
        double[] inputArr = new double[]{1,2,3,4,5,6,7,8,9};
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                matrix.changeElem(i, j, inputArr[i*N+j]);
            }
        }
        matrix.changeElem(2,2,999);
        assertEquals(999, matrix.getElem(2,2));
    }

    @Test
    void changeElem_3() {
        int N = 3;
        Matrix matrix = new Matrix(N);
        double[] inputArr = new double[]{1,2,3,4,5,6,7,8,9};
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                matrix.changeElem(i, j, inputArr[i*N+j]);
            }
        }
        matrix.changeElem(0,0,0);
        assertEquals(0, matrix.getElem(0,0));
    }

    @Test
    void calculateDeterminant_1() {
        int N = 3;
        Matrix matrix = new Matrix(N);
        double[] inputArr = new double[]{-4,-1,2,10,4,-1,8,3,1};
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                matrix.changeElem(i, j, inputArr[i*N+j]);
            }
        }
        assertEquals(-14, matrix.calculateDeterminant());
    }

    @Test
    void calculateDeterminant_2() {
        int N = 2;
        Matrix matrix = new Matrix(N);
        double[] inputArr = new double[]{11,-3, -15,-2};
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                matrix.changeElem(i, j, inputArr[i*N+j]);
            }
        }
        assertEquals(-67, matrix.calculateDeterminant());
    }

    @Test
    void calculateDeterminant_3() {
        int N = 1;
        Matrix matrix = new Matrix(N);
        double[] inputArr = new double[]{1};
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                matrix.changeElem(i, j, inputArr[i*N+j]);
            }
        }
        assertEquals(1, matrix.calculateDeterminant());
    }
}