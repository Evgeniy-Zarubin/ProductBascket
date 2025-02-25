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
        for (Product pr : products) {
            if (pr != null) {
                totalCost += pr.getPrice();
            }
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

    public void printContent() {
        System.out.println("Ваша корзина:");
        double totalCost = 0;
        int specialCount = 0;

        for (Product pr : products) {
            if (pr != null) {
                System.out.println(pr.toString());
                totalCost += pr.getPrice();
            }
            if (pr != null && pr.isSpecial()) {
                specialCount++;
            }
        }

        System.out.println("Итого стоимость корзины равна: " + totalCost);
        System.out.println("Специальных товаров в корзине: " + specialCount);
    }

}