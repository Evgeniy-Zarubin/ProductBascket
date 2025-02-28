package org.skypro.skyshop;

import org.skypro.skyshop.Article.Article;
import org.skypro.skyshop.Article.SearchEngine;
import org.skypro.skyshop.Article.Searchable;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

import java.util.Arrays;
import java.util.List;

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

        //Наследование
        Product gamePad = new SimpleProduct("Геймпад", 8900);
        Product noteBook = new DiscountedProduct("Ноутбук Acer", 120000, 15);
        Product ssdM2 = new FixPriceProduct("Накопитель SSD M2");
        basket.addProduct(gamePad);
        basket.addProduct(noteBook);
        basket.addProduct(ssdM2);
        basket.printContent();
        basket.clear();

        test("", 10);
        test("Банан", -10);
        try {
            // Простые продукты
            SimpleProduct product1 = new SimpleProduct("Tecт", 10);   // Ошибка: пустое имя
            System.out.println(product1.getName());

            SimpleProduct product2 = new SimpleProduct("Test", -5);  // Ошибка: отрицательная цена
            System.out.println(product2.getPrice());

            // Продукты со скидкой
            DiscountedProduct discountedProduct1 = new DiscountedProduct(null, 50, 20); // Ошибка: null-имя
            System.out.println(discountedProduct1.getPrice());

            DiscountedProduct discountedProduct2 = new DiscountedProduct("Sale", 30, 120); // Ошибка: слишком большой процент скидки
            System.out.println(discountedProduct2.getDiscountPercent());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());  // Выводим сообщение ошибки
        }

        SearchEngine searchEngine = new SearchEngine(10);
        Searchable searchable = new Product("Наушники");
        Product gamePad1 = new SimpleProduct("Геймпад", 8900);
        Product noteBook1 = new DiscountedProduct("Ноутбук Acer", 120000, 15);
        Product ssdM22 = new FixPriceProduct("SSD M2");
        Article articleGamePad = new Article("Информация о Геймпаде", "Функциональные характеристики геймпада");
        Article articleNoteBook = new Article("Информация о Ноутбуке", "Функциональные характеристики ноутбука");

        searchEngine.add(gamePad1);
        searchEngine.add(noteBook1);
        searchEngine.add(ssdM22);
        searchEngine.add(articleGamePad);
        searchEngine.add(articleNoteBook);


        try {
            // Поиск существующего элемента
            Searchable result = searchEngine.findBestMatch("Геймпад");
            System.out.println(result.getSearchTerm());

            // Поиск несуществующего элемента
            Searchable notFound = searchEngine.findBestMatch("ананас");
        } catch (BestResultNotFound e) {
            System.err.println(e.getMessage());
        }


    }

    //Тестовый метод
    public static void test(String name, double price) {
        try {
            SimpleProduct product2 = new SimpleProduct(name, price);
            System.out.println(product2.getName());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());}
    }

}

