package org.kuzne.labs.lab8;

import org.kuzne.labs.lab5.IMatrix;

public class NonExecutable1 implements IMatrix {
    @Override
    public double getElem(int i, int j) {
        return 0;
    }

    @Override
    public void changeElem(int i, int j, double value) {

    }

    @Override
    public double calculateDeterminant() {
        return 0;
    }
}
