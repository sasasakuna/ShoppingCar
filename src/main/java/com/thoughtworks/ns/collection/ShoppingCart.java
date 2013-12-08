package com.thoughtworks.ns.collection;

import com.google.common.base.Function;
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
                return input.getName().equals(name);
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

    public int getPrice()
    {
//        int totalPrice = 0;
//        Iterable<Integer> price = Iterables.transform(products.values(), new Function<Product, Integer>() {
//            @Override
//            public Integer apply(Product input) {
//                return input.getPrice();
//            }
//        });
//        for(int i : price)
//             totalPrice+=i;
//        return totalPrice;
        return  Reduce.reduce(products.values(), new Func<Product, Integer>() {
            @Override
            public Integer apply(Product currentElement, Integer origin) {
                return  currentElement.getPrice() + origin;
            }
        }, 0);
    }
}
