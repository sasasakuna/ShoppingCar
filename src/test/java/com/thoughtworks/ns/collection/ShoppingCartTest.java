package com.thoughtworks.ns.collection;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
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
    public void should_add_product() throws Exception {
        for (int i = 0; i < 10; i++)
            shoppingCart.addProduct(product);
        assertThat(shoppingCart.getAmount(), is(10));
    }

    @Test
    public void should_add_product_throwsException_test() throws Exception {
        try {
            for (int i = 0; i < 11; i++)
                shoppingCart.addProduct(product);
            fail("Expected an overflow Exception to be thrown");
        } catch (Exception e) {
            assertThat(e.getMessage(), is("overflow!"));
        }
    }

    @Test
    public void should_queryProductByName_Test() throws Exception {
        product = new Product("food");
        shoppingCart.addProduct(product);
        assertThat(shoppingCart.queryProductByName("food"), is(product));
    }
}
