package org.skypro.skyshop.basket;

import java.util.*;

import org.skypro.skyshop.product.Product;


public class ProductBasket {
    private final Map<String, List<Product>> products = new HashMap<>();

    public void addProduct(Product product) {
        String name = product.getName();
        if (!products.containsKey(name)) {
            products.put(name, new ArrayList<>());
        }
        products.get(name).add(product);
    }

    public double getTotalCost() {
        double totalCost = 0;
        for (List<Product> product : products.values()) {
            for(Product pr : product) {
                totalCost += pr.getPrice();
            }
        }

        return totalCost;
    }

    public void clear() {
        products.clear();
    }

    public void printAllProducts() {
        if (products.isEmpty()) {
            System.out.println("в корзине пусто");
        } else {
            for (List<Product> product : products.values()) {
                for (Product pr : product) {
                    System.out.println("Продукт: " + pr.getName() + " Цена: " + pr.getPrice());
                }
            }
            System.out.println("Итого: " + getTotalCost());
        }
    }

    public boolean equalsProductName(String name) {
        for (List<Product> product : products.values()) {
            for (Product pr : product) {
                if (pr.getName().equals(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<Product> removeProductByName(String name) {
        List<Product> removedProducts = products.remove(name);
        return removedProducts != null ? removedProducts : new ArrayList<>();
    }

    public void printContent() {
        System.out.println("Ваша корзина:");
        double totalCost = 0;
        int specialCount = 0;

        for(List<Product> product : products.values()) {
            for (Product pr : product) {
                if (pr != null) {
                    System.out.println(pr);
                    totalCost += pr.getPrice();
                }
                if (pr != null && pr.isSpecial()) {
                    specialCount++;
                }
            }
        }
        System.out.println("Итого стоимость корзины равна: " + totalCost);
        System.out.println("Специальных товаров в корзине: " + specialCount);
    }


    public void printBuсket() {
        System.out.println("Текущие товары в корзине:");
        System.out.println(products);
    }

    public void checkRemovedList(List<Product> removedList) {
        if (removedList.isEmpty()){
            System.out.println("Список удалённых товаров пуст");
        } else {
            System.out.println("Удалённые товары: " + removedList);
        }
    }

    public void clearRemovedList (List<Product> removedList) {
             removedList.clear();
    }

}