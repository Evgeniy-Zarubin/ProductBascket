package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private double basePrice;
    private int discountPercent;

    public DiscountedProduct(String nameProduct, double basePrice, int discountPercent) {
        super(nameProduct);
        this.basePrice = basePrice;
        this.discountPercent = discountPercent;
    }

    @Override
    public double getPrice() {
        if (discountPercent < 0) {
            System.out.println("Скидка не может быть отрицательной или равна нулю");
            return 0;
        }
        return basePrice * (1 - ((double) discountPercent / 100));
    }

    @Override
    public String toString() {
        return nameProduct + ": " + getPrice() + " (" + discountPercent + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
