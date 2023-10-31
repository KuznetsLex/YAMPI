package org.kuzne.labs.lab3;

public class PieceProductsPacked extends PieceProduct implements Packable{
    private final double productQuantity;
    private final ProductPackage productPackage;

    public PieceProductsPacked(String name, String description, double pieceWeight, double productQuantity, ProductPackage productPackage) {
        super(name, description, pieceWeight);
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
        return getProductQuantity() * super.getSinglePieceWeight();
    }

    public double getGrossWeight() {
        return getProductQuantity() * super.getSinglePieceWeight() + productPackage.getWeight();
    }
}
