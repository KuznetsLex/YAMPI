package org.kuzne.labs.lab3;

public class PieceProductsPacked extends PieceProduct implements Packable{
    private final int productQuantity;
    private final ProductPackage productPackage;

    public PieceProductsPacked(PieceProduct product, int productQuantity, ProductPackage productPackage) {
        super(product.getName(), product.getDescription(), product.getSinglePieceWeight());
        this.productQuantity = productQuantity;
        this.productPackage = new ProductPackage(productPackage.getName(), productPackage.getWeight());
    }

    public double getProductQuantity() {
        return productQuantity;
    }

    public ProductPackage getProductPackage() {
        return productPackage;
    }

    @Override
    public String toString() {
        return  '\n' + "WeightProductPacked{" +
                "name='" + super.getName() + '\'' +
                ", description='" + super.getDescription() + '\'' +
                ", pieceWeight=" + super.getSinglePieceWeight() +
                ", productQuantity=" + productQuantity +
                ", productPackageName='" + productPackage.getName() + '\'' +
                ", productPackageWeight=" + productPackage.getWeight() +
                '}';
    }

    // Следует ли в следующих классах использовать геттеры?
    public double getNetWeight() {
        return getProductQuantity() * getSinglePieceWeight();
    }

    public double getGrossWeight() {
        return getProductQuantity() * super.getSinglePieceWeight() + productPackage.getWeight();
    }
}
