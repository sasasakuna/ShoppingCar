package com.thoughtworks.ns.collection;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private int amount = 0;

    private final int CAPACITY = 10;
    private Product[] productsArray = new Product[CAPACITY];

    public int getAmount() {
        return amount;
    }

    public void addProduct(Product product) throws Exception {
        if (amount < CAPACITY) {
            productsArray[amount++] = product;
        } else {
            throw new Exception("overflow!");
        }
    }

    public Product queryProductByName(String name) {
        for (int i = 0; i < productsArray.length; i++) {
            if (productsArray[i].getName().equals(name)) {
                return productsArray[i];
            }
        }
        return null;
    }
}
