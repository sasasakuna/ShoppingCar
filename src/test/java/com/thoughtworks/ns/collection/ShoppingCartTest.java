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
    Product product;

    @Before
    public void setUp() {
        shoppingCart = new ShoppingCart();

    }

    @Test
    public void should_get_product_amount() throws Exception {
        assertThat(shoppingCart.getAmount(), is(0));
    }

    @Test
    public void should_add_products(){
        product = new Product("shoe");
        for (int i = 0; i < 11; i++)
            shoppingCart.addProduct(product);
    }

    @Test
    public void should_get_product_by_query() throws Exception {
        product = new Product("food");
        shoppingCart.addProduct(product);
        assertThat(shoppingCart.queryByName("food"), is(product));
    }

    @Test
    public void should_get_product_by_remove() throws Exception {
        shoppingCart.addProduct(new Product("food"));
        assertThat(shoppingCart.remove("food"), is(new Product("food")));
       // assertNull(shoppingCart.remove("book"));
        assertThat(shoppingCart.remove("book"), is(nullValue()));
    }
}
