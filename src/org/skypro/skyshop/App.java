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

        ProductBasket basket = new ProductBasket();

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

        Product gamePad = new SimpleProduct("Геймпад", 8900);
        Product noteBook = new DiscountedProduct("Ноутбук Acer", 120000, 15);
        Product ssdM2 = new FixPriceProduct("SSD M2");
        Article articleGamePad = new Article("Информация о Геймпаде", "Функциональные характеристики геймпада");
        Article articleNoteBook = new Article("Информация о Ноутбуке", "Функциональные характеристики ноутбука");

        basket.addProduct(gamePad);
        basket.addProduct(noteBook);
        basket.addProduct(ssdM2);
        basket.printAllProducts();

        double totalCost = basket.getTotalCost();
        System.out.println("Общая стоимость корзины: " + totalCost);

        boolean hasGamepad = basket.equalsProductName("Геймпад");
        System.out.println("Есть ли Геймпад в корзине? " + hasGamepad);

        boolean hasMeat = basket.equalsProductName("Мясо");
        System.out.println("Есть ли мясо в корзине? " + hasMeat);


        Searchable searchable = new Product("Наушники");
        SearchEngine searchEngine = new SearchEngine();

        searchEngine.add(gamePad);
        searchEngine.add(noteBook);
        searchEngine.add(ssdM2);
        searchEngine.add(articleGamePad);
        searchEngine.add(articleNoteBook);

        System.out.println("Ищем результат по Геймпаду");
        searchEngine.search("Геймпад");
        System.out.println("Ищем результат по Наушникам");
        searchEngine.search("Наушники");

        System.out.println("Информация по продукту:");
        System.out.println("Имя: " + searchable.getName());
        System.out.println("Тип контента: " + searchable.getContentType());
        System.out.println("Поисковый термин: " + searchable.getSearchTerm());
        System.out.println("Представление - " + searchable.getStringRepresentation());

        System.out.println("Информация о статье:");
        System.out.println("Имя: " + articleGamePad.getName());
        System.out.println("Тип контента: " + articleGamePad.getContentType());
        System.out.println("Поисковый термин: " + articleGamePad.getSearchTerm());
        System.out.println("Представление - " + articleGamePad.getStringRepresentation());


        try {
            // Поиск существующего элемента
            Searchable result = searchEngine.findBestMatch("Геймпад");
            System.out.println(result.getSearchTerm());

            // Поиск несуществующего элемента
            Searchable notFound = searchEngine.findBestMatch("ананас");
        } catch (BestResultNotFound e) {
            System.err.println(e.getMessage());
        }


        List<Product> removedList = basket.removeProductByName("SSD M2");
        System.out.println("Список удалённых товаров: " + removedList);

        basket.printBuсket();
        basket.clearRemovedList(removedList);
        basket.checkRemovedList(removedList);

        
    }
}
