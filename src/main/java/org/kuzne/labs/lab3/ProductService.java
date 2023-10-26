package org.kuzne.labs.lab3;

public class ProductService {
    public static int countByFilter(ProductBatch batch, Filter filter) {
        int countByFilter = 0;
        Packable[] productsArray = batch.getProducts();
        for (Packable product : productsArray) {
            if (product instanceof Product productNamed) {
                if (filter.apply(productNamed.getName())) { countByFilter++; }
            } else if (product instanceof MixedProductsPacked setNamed) {
                if (filter.apply(setNamed.getName())) { countByFilter++; }
            }
        }
        return countByFilter;
    }

    public static int countByFilterDeep(ProductBatch batch, Filter filter) {
        int countByFilter = 0;
        Packable[] productsOfBatchArray = batch.getProducts();
        for (Packable productOfBatch : productsOfBatchArray) {
            if (productOfBatch instanceof Product productNamed) {
                if (filter.apply(productNamed.getName())) { countByFilter++; }
            } else if (productOfBatch instanceof MixedProductsPacked set) {
                if (setContains(set, filter)) { countByFilter++; }
            }
        }
        return countByFilter;
    }

    public static boolean setContains(MixedProductsPacked set, Filter filter) {
        Packable[] productsOfSetArray = set.getProducts();
        for (Packable productOfSet : productsOfSetArray) {
            if (productOfSet instanceof Product productNamed) {
                if (filter.apply(productNamed.getName())) { return true; }
            } else if (productOfSet instanceof MixedProductsPacked subSet) {
                if (setContains(subSet, filter)) { return true; }
            }
        }
        return false;
    }

    public static boolean checkAllWeighted(ProductBatch batch) {
        Packable[] productsArray = batch.getProducts();
        return checkAllWeighted(productsArray);
    }

    public static boolean checkAllWeighted(Packable[] products) {
        for (Packable product : products) {
            if (!(product instanceof WeightProduct)) {
                if (product instanceof MixedProductsPacked set) {
                    Packable[] productsArray = set.getProducts();
                    if (!checkAllWeighted(productsArray)) { return false; }
                } else return false;
            }
        }
        return true;
    }
}

