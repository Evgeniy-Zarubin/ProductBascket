package org.skypro.skyshop.product;

public class Product {
    private String nameProduct;
    private double priceProduct;

    public Product(String nameProduct, double priceProduct) {
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
    }

    public String getName() {
        return nameProduct;
    }

    public double getPrice() {
        return priceProduct;
    }
}
