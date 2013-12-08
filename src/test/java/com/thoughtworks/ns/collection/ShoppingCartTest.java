package com.thoughtworks.ns.collection;

import org.junit.Before;
import org.junit.Test;

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
    public void should_get_product_amount(){
        assertThat(shoppingCart.getAmount(), is(0));
    }

    @Test
    public void should_add_products() throws MyShoppingCartOverFlowException {
        for (int i = 0; i < 10; i++)
            shoppingCart.addProduct(new Product("food"+i));
        assertThat(shoppingCart.getAmount(), is(10));
    }

    @Test (expected = MyShoppingCartOverFlowException.class)
    public void should_add_product_throwsException() throws MyShoppingCartOverFlowException{
        for (int i = 0; i < 11; i++)
            shoppingCart.addProduct(new Product("food"+i));
        fail("Expected an overflow Exception to be thrown");
    }

    @Test
    public void should_queryProductByName_Test() throws MyShoppingCartOverFlowException {
        shoppingCart.addProduct(new Product("book"));
        assertThat(shoppingCart.queryProductByName("book"), is(new Product("book")));
    }
}
