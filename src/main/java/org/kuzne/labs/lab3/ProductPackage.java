package org.kuzne.labs.lab3;

import java.util.Objects;

public class ProductPackage {
    private String name;
    private double weight;

    public ProductPackage(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductPackage that = (ProductPackage) o;
        return Double.compare(weight, that.weight) == 0 && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight);
    }

    @Override
    public String toString() {
        return "ProductPackage{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}

