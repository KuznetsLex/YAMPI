package org.kuzne.labs.lab5;

public class DiagMatrix extends Matrix {
    public DiagMatrix(int N) {
        super(N);
    }

    public DiagMatrix(double[] diagElems) {
        super(diagElems.length);
        for (int i = 0; i < diagElems.length; i++) {
            super.changeElem(i, i, diagElems[i]);
        }
    }

    @Override
    public void changeElem(int i, int j, double value) {
        if (i == j) {
            super.changeElem(i, j, value);
        } else {
            throw new IllegalArgumentException("Попытка записать ненулевое значение вне диагонали");
        }
    }

    @Override
    public double calculateDeterminant() {
        double det = 1;
        for (int i = 0; i < super.getN(); i++) {
            det *= super.getElem(i, i);
        }
        return det;
    }
}
