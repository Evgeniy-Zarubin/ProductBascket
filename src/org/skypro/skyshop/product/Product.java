package org.skypro.skyshop.product;

public abstract class Product {
    protected String nameProduct;

    public Product(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getName() {
        return nameProduct;
    }

    public abstract double getPrice();

    public boolean isSpecial() {
        return false;
    }
}
