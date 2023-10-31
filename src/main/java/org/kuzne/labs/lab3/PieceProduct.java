package org.kuzne.labs.lab3;

import java.util.Objects;

public class PieceProduct extends Product {
    private final double singlePieceWeight;
    public PieceProduct(String name, String description, double singlePieceWeight) {
        super(name, description);
        this.singlePieceWeight = singlePieceWeight;
    }

    public double getSinglePieceWeight() {
        return singlePieceWeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PieceProduct that = (PieceProduct) o;
        return Double.compare(singlePieceWeight, that.singlePieceWeight) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), singlePieceWeight);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + super.getName() + '\'' +
                ", description='" + super.getDescription() + '\'' +
                ", singlePieceWeight=" + singlePieceWeight +
                '}';
    }
}
