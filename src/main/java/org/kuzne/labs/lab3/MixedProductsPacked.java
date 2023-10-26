package org.kuzne.labs.lab3;

import java.util.Arrays;
import java.util.Objects;

public class MixedProductsPacked implements Packable{
    // TODO: toString
    private final String name;
    private final ProductPackage productPackage;
    private final Packable[] products;

    public MixedProductsPacked(String name, ProductPackage productPackage, Packable ... products) throws IllegalArgumentException {
        this.name = name;
        this.productPackage = productPackage;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public ProductPackage getProductPackage() {
        return productPackage;
    }

    public Packable[] getProducts() {
        return products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MixedProductsPacked that = (MixedProductsPacked) o;
        return Objects.equals(name, that.name) && Objects.equals(productPackage, that.productPackage) && Arrays.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, productPackage);
        result = 31 * result + Arrays.hashCode(products);
        return result;
    }

    @Override
    public String toString() {
        return "MixedProductsPacked{" +
                "name='" + name + '\'' +
                ", productPackage=" + productPackage +
                ", products=" + Arrays.toString(products) +
                '}';
    }

    @Override
    public double getNetWeight() {
        double netWeight = 0;
        for (Packable product : products) {
            netWeight += product.getGrossWeight();
        }
        return netWeight;
    }

    @Override
    public double getGrossWeight() {
        return getNetWeight() + productPackage.getWeight();
    }
}
