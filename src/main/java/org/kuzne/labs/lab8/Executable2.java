package org.kuzne.labs.lab8;

import org.kuzne.labs.lab5.IMatrix;

public class Executable2 implements Executable, IMatrix {
    @Override
    public void execute() { }

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
