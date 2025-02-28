package org.skypro.skyshop.product;

import org.skypro.skyshop.Article.Searchable;

public class Product implements Searchable {
    protected final String nameProduct;

    public Product(String nameProduct) {
        if (nameProduct == null || nameProduct.trim().isEmpty()) {
            throw new IllegalArgumentException("Название продукта не должно быть пустым или null");
        }
        this.nameProduct = nameProduct;
    }

    @Override
    public String getName() {
        return nameProduct;
    }

    public double getPrice(){
        return 0;
    }

    public boolean isSpecial() {
        return false;
    }

    @Override
    public String getSearchTerm() {
        return nameProduct;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String getStringRepresentation() {
        return "Продукт: " + nameProduct;
    }

}
