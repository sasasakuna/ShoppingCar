package com.thoughtworks.ns.collection;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class ShoppingCartTest {

    private ShoppingCart shoppingCart;

    @Before
    public void setUp() {
        shoppingCart = new ShoppingCart();

    }

    @Test
    public void should_get_product_amount() {
        assertThat(shoppingCart.getAmount(), is(0));
    }

    @Test
    public void should_add_products() {
        for (int i = 0; i < 10; i++)
            shoppingCart.addProduct("Food", new Product("Rice"));
        assertThat(shoppingCart.getAmount(), is(10));
    }

    @Test
    public void should_query_products_amount() {
        for (int i = 0; i < 10; i++)
            shoppingCart.addProduct("Book", new Product("Harry Potter"));
        assertThat(shoppingCart.queryAmount("Harry Potter"), is(10));
    }

    @Test
    public void should_remove_products() {
        for (int i = 0; i < 10; i++)
            shoppingCart.addProduct("Book", new Product("Harry Potter"));
        assertThat(shoppingCart.remove("Harry Potter").size(), is(10));
    }
}
