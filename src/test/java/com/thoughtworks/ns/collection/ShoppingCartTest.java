package com.thoughtworks.ns.collection;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNull;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
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
    public void should_add_products(){
        for (int i = 0; i < 10; i++)
            shoppingCart.addProduct(new Product("shoe"+i));
        assertThat(shoppingCart.getAmount(), is(10));
    }

    @Test
    public void should_get_product_by_query(){
        shoppingCart.addProduct(new Product("food"));
        assertThat(shoppingCart.queryByName("food"), is(new Product("food")));
    }

    @Test
    public void should_get_product_by_remove(){
        shoppingCart.addProduct(new Product("book"));
        assertThat(shoppingCart.removeByName("book"), is(new Product("book")));
       // assertNull(shoppingCart.remove("book"));
        assertThat(shoppingCart.removeByName("drink"), is(nullValue()));
    }
}
