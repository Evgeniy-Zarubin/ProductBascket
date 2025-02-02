package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Product milk = new Product("Молоко", 50.78);
        Product bread = new Product("Хлеб", 30.20);
        Product apples = new Product("Яблоки", 100);
        Product meat = new Product("Мясо", 300.22);
        Product cheese = new Product("Сыр", 200.3);
        Product butter = new Product("Масло", 150.83);

        ProductBasket basket = new ProductBasket();

        basket.addProduct(milk);
        basket.addProduct(bread);
        basket.addProduct(apples);
        basket.printAllProducts();

        double totalCost = basket.getTotalCost();
        System.out.println("Общая стоимость корзины: " + totalCost);

        boolean hasMilk = basket.equalsProductName("Молоко");
        System.out.println("Есть ли молоко в корзине? " + hasMilk);

        boolean hasMeat = basket.equalsProductName("Мясо");
        System.out.println("Есть ли мясо в корзине? " + hasMeat);

        basket.clear();
        basket.printAllProducts();

        double emptyTotalCost = basket.getTotalCost();
        System.out.println("Стоимость пустой корзины: " + emptyTotalCost);


        boolean hasAppleInEmpty = basket.equalsProductName("Яблоки");
        System.out.println("Есть ли яблоки в пустой корзине? " + hasAppleInEmpty);

        basket.addProduct(meat);
        basket.addProduct(cheese);
        basket.addProduct(butter);
        basket.addProduct(new Product("Сахар", 80));

    }
}