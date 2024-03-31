package org.kuzne.labs.lab5;

public interface IMatrix {
    double getElem(int i, int j);
    void changeElem(int i, int j, double value);
    double calculateDeterminant();
}
