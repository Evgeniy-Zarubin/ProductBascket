package org.skypro.skyshop.basket;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.skypro.skyshop.product.Product;


public class ProductBasket {
    private final List<Product> products = new ArrayList<>();
    private int countProducts = 0;

    public void addProduct(Product product) {
        this.products.add(product);
        this.countProducts++;
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

    public void clear() {
        for (int i = 0; i < products.size(); ) {
            products.remove(i);
        }
        countProducts = 0;
    }


    public void printAllProducts() {
        if (products.isEmpty()) {
            System.out.println("в корзине пусто");
        } else {
            for (int i = 0; i < countProducts; i++) {
                Product product = products.get(i);
                System.out.println("Продукт: " + product.getName() + " Цена: " + product.getPrice());
            }
            System.out.println("Итого: " + getTotalCost());
        }
    }

    public boolean equalsProductName(String name) {
        for (int i = 0; i < countProducts; ++i) {
            if (products.get(i).getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public List<Product> removeProductByName(String name) {
        List<Product> removedProducts = new ArrayList<>();

        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product currentProduct = iterator.next();
            if (currentProduct.getName().equals(name)) {
                removedProducts.add(currentProduct);
                iterator.remove();
                countProducts--;
            }
        }
        return removedProducts;
    }

    public void printContent() {
        System.out.println("Ваша корзина:");
        double totalCost = 0;
        int specialCount = 0;

        for (Product pr : products) {
            if (pr != null) {
                System.out.println(pr);
                totalCost += pr.getPrice();
            }
            if (pr != null && pr.isSpecial()) {
                specialCount++;
            }
        }

        System.out.println("Итого стоимость корзины равна: " + totalCost);
        System.out.println("Специальных товаров в корзине: " + specialCount);
    }


    public void printBasket() {
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