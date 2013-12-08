package com.thoughtworks.ns.collection;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private final int CAPACITY = 10;
    private int amount;
    private Product[] productsArray;


    public ShoppingCart() {
        this.amount = 0;
        this.productsArray = new Product[CAPACITY];
    }

    public ShoppingCart(int amount, Product[] productsArray) {
        this.amount = amount;
        this.productsArray = productsArray;
    }


    public int getAmount() {
        return amount;
    }

    public void addProduct(Product product) throws MyShoppingCartOverFlowException {
        if (amount < CAPACITY) {
            productsArray[amount++] = product;
        } else {
            throw new MyShoppingCartOverFlowException("OVERFLOW!");
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
