package com.thoughtworks.ns.collection;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private int amount = 0;


    private List<Product> products = new ArrayList<Product>();

    public int getAmount() {
        return amount;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product queryByName(String name) {
        for (int i = 0; i < products.size(); i++)
            if (products.get(i).getName().equals(name)) {
                return products.get(i);
            }
        return null;
    }

    public Product remove(String name) {
        Product product = null;
        for (int i = 0; i < products.size(); i++)
            if (products.get(i).getName().equals(name)) {
                product =  products.get(i);
                products.remove(product);
            }
        return product;
    }


}
