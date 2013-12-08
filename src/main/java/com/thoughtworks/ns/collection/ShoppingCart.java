package com.thoughtworks.ns.collection;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ShoppingCart {

    private Multimap<String, Product> products;

    public ShoppingCart() {
        this.products = ArrayListMultimap.create();
    }

    public ShoppingCart(Multimap products) {
        this.products = products;
    }

    public int getAmount() {
        return products.size();
    }

    public void addProduct(String kind, Product product) {
        products.put(kind, product);
    }

    public Multimap<String, Product> query(final String name) {
        return Multimaps.filterValues(products, new Predicate<Product>() {
            @Override
            public boolean apply(Product input) {
                return input.name.equals(name);
            }
        });
    }

    public int queryAmount(final String name) {
        return query(name).size();
    }

    public Multimap<String, Product> remove(String name) {
        Multimap<String, Product> retVal = query(name);
        if (retVal.size() > 0) {
            products.removeAll(retVal);
            return retVal;
        } else {
            return null;
        }
    }

}
