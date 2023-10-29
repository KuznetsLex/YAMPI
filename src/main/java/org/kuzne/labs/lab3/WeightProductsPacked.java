package org.kuzne.labs.lab3;

import java.util.Objects;

public class WeightProductsPacked extends WeightProduct implements Packable{
    private final double productAmount;
    private final ProductPackage productPackage;

    public WeightProductsPacked(String name, String description, double productAmount, ProductPackage productPackage) {
        super(name, description);
        this.productAmount = productAmount;
        this.productPackage = productPackage;
    }

    public double getProductAmount() {
        return productAmount;
    }

    public ProductPackage getProductPackage() {
        return productPackage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        WeightProductsPacked that = (WeightProductsPacked) o;
        return Double.compare(productAmount, that.productAmount) == 0 && Objects.equals(productPackage, that.productPackage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), productAmount, productPackage);
    }

    @Override
    public String toString() {
        return '\n' + "WeightProductPacked{" +
                "name='" + super.getName() + '\'' +
                ", description='" + super.getDescription() + '\'' +
                ", productAmount=" + productAmount +
                ", productPackageName='" + productPackage.getName() + '\'' +
                ", productPackageWeight=" + productPackage.getWeight() +
                '}';
    }

    // Следует ли в следующих классах использовать геттеры?
    public double getNetWeight() {
        return getProductAmount();
    }

    public double getGrossWeight() {
        return getNetWeight() + productPackage.getWeight();
    }
}
