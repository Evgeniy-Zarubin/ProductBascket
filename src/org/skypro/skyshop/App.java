package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        Product milk = new SimpleProduct("Молоко", 50.78);
        Product bread = new SimpleProduct("Хлеб", 30.20);
        Product apples = new SimpleProduct("Яблоки", 100);
        Product meat = new SimpleProduct("Мясо", 300.22);
        Product cheese = new SimpleProduct("Сыр", 200.3);
        Product butter = new SimpleProduct("Масло", 150.83);


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

        //Заполняем корзину заново
        basket.addProduct(bread);
        basket.addProduct(apples);
        basket.addProduct(meat);
        basket.addProduct(cheese);
        basket.addProduct(butter);
        System.out.println("------------------Добавляем 6ой продукт------------------------");
        basket.addProduct(new SimpleProduct("Сахар", 80));

        System.out.println("------------------Выводим новую корзину------------------------");
        basket.printAllProducts();
        basket.clear();
        Product gamePad = new SimpleProduct("Геймпад", 8900);
        Product noteBook = new DiscountedProduct("Ноутбук Acer", 120000, 15);
        Product ssdM2 = new FixPriceProduct("Накопитель SSD M2");
        basket.addProduct(gamePad);
        basket.addProduct(noteBook);
        basket.addProduct(ssdM2);
        basket.printContent();



    }
}