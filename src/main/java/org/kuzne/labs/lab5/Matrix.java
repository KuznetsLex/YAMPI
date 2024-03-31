package org.kuzne.labs.lab5;

import java.util.Arrays;
import java.util.Objects;

public class Matrix implements IMatrix {
    private int N;
    private double[] arr;

    public Matrix(int N) {
        this.N = N;
        this.arr = new double[N*N];
    }

    public int getN() {
        return N;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        return N == matrix.N && Arrays.equals(arr, matrix.arr);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(N);
        result = 31 * result + Arrays.hashCode(arr);
        return result;
    }

    @Override
    public double getElem(int i, int j) {
        return arr[N * i + j];
    }

    @Override
    public void changeElem(int i, int j, double value) {
        arr[N * i + j] = value;
    }

    @Override
    public double calculateDeterminant() {
        double[] arrCopy = Arrays.copyOf(arr, N*N);
        double det = 1.0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                double ratio = arrCopy[j * N + i] / arrCopy[i * N + i];
                for (int k = 0; k < N; k++) {
                    arrCopy[j * N + k] -= ratio * arrCopy[i * N + k];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            det *= arrCopy[i*N + i];
        }
        return det;
    }
}
