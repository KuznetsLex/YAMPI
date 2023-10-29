package org.kuzne.labs.lab3;

public class Main {
    public static void main(String[] args) {

        // Product
        WeightProduct bananas = new WeightProduct("Bananas", "Yellow and long");
        System.out.println(bananas.getName());
        PieceProduct picnic1 = new PieceProduct("Picnic", "Snack with waffles and nuts",0.12);
        PieceProduct picnic2 = new PieceProduct("Picnic", "Snack with waffles and nuts",0.12);
        PieceProduct twix = new PieceProduct("Twix", "Snack with waffles and nougat",0.12);
        System.out.println(picnic1.equals(picnic2));
        System.out.println(picnic1.equals(twix));
        System.out.println(twix);

        // Filter
        String str1 = "Мама мыла раму";
        BeginStringFilter filter1 = new BeginStringFilter("Мама");
        BeginStringFilter filter2 = new BeginStringFilter("мыла");
        boolean res1 = filter1.apply(str1);
        boolean res2 = filter2.apply(str1);
        System.out.println(res1);
        System.out.println(res2);

        LengthEightStringFilter filterLengthEightString = new LengthEightStringFilter();
        System.out.println(filterLengthEightString.apply("12345678"));
        System.out.println(filterLengthEightString.apply("1234567"));

        WithoutNumbersStringFilter filterWithoutNumbersString = new WithoutNumbersStringFilter();
        System.out.println(filterWithoutNumbersString.apply("1"));
        System.out.println(filterWithoutNumbersString.apply("one"));

        ProductPackage web = new ProductPackage("Web", 0.02);
        WeightProductsPacked orangesPacked = new WeightProductsPacked("Oranges", "Oranges in web", 3.0, web);
        WeightProductsPacked bananasPacked = new WeightProductsPacked("Bananas8", "Yellow and long in web", 5.0, web);
        ProductPackage wrapper = new ProductPackage("Wrapper", 0.005);
        PieceProductsPacked picnic = new PieceProductsPacked("Picnic88", "Snack with waffles and nuts",0.12, 1, wrapper);
        ProductPackage smallBox = new ProductPackage("SmallBox", 0.2);
        MixedProductsPacked fruits = new MixedProductsPacked("Fruits", smallBox, orangesPacked, bananasPacked);
        ProductBatch batch1 = new ProductBatch("Fruits and snacks", fruits, picnic);
        ProductBatch batch2 = new ProductBatch("Fruits", fruits);
        System.out.println(ProductService.countByFilter(batch1, filterLengthEightString));
        System.out.println(ProductService.countByFilterDeep(batch1, filterLengthEightString));
        System.out.println(ProductService.checkAllWeighted(batch2));
    }
}
