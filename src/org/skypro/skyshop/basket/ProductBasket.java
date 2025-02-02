package org.skypro.skyshop.basket;
import java.util.Arrays;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private static final int maxProducts = 5;
    private Product[] products = new Product[maxProducts];
    private int countProducts = 0;

    public void addProduct(Product product) {
        if (countProducts >= maxProducts) {
            System.out.println("Невозможно добавить продукт - корзина полна");
        } else {
            products[countProducts++] = product;
        }
    }

    public double getTotalCost() {
        double totalCost = 0;
        for (int i = 0; i < countProducts; i++) {
            totalCost += products[i].getPrice();
        }
        return totalCost;
    }

    public void printAllProducts() {
        if (isEmpty()) {
            System.out.println("в корзине пусто");
        } else {
            for (int i = 0; i < countProducts; i++) {
                Product product = products[i];
                System.out.println("Продукт: " + product.getName() + " Цена: " + product.getPrice());
            }
            System.out.println("Итого: " + getTotalCost());
        }
    }

    public boolean equalsProductName(String name) {
        for (int i = 0; i < countProducts; ++i) {
            if (products[i].getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
        countProducts = 0;
    }

    private boolean isEmpty() {
        return countProducts == 0;
    }

}