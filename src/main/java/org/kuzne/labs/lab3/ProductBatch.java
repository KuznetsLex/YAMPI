package org.kuzne.labs.lab3;

import java.util.Arrays;
import java.util.Objects;

public class ProductBatch {
    //TODO: toString
    private final String description;
    private final Packable[] products;

    public ProductBatch(String description, Packable ... products) throws IllegalArgumentException {
        this.description = description;
        this.products = products;
    }

    public String getDescription() {
        return description;
    }

    public Packable[] getProducts() {
        return products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductBatch that = (ProductBatch) o;
        return Objects.equals(description, that.description) && Arrays.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(description);
        result = 31 * result + Arrays.hashCode(products);
        return result;
    }

    @Override
    public String toString() {
        return "ProductBatch{" +
                "description='" + description + '\'' +
                ", products=" + Arrays.toString(products) +
                '}';
    }

    public double getWeight() {
        double Weight = 0;
        for (Packable product : products) {
            Weight += product.getGrossWeight();
        }
        return Weight;
    }


}
