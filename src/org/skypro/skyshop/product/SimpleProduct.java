package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private double price;

    public SimpleProduct(String nameProduct, double price) {
        super(nameProduct);
        if (price <= 0) {
            throw new IllegalArgumentException("Цена не должна быть меньше или равна нулю");
        }
            this.price = price;
    }

    @Override
    public double getPrice() {
        return price;

    }

    @Override
    public String toString() {
        return nameProduct + ": " + getPrice();
    }

}
