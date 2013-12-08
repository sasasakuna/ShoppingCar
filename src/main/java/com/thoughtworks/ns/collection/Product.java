package com.thoughtworks.ns.collection;

import com.google.common.base.Objects;

public class Product {

    private String name;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        final Product other = (Product) obj;
        return Objects.equal(this.name, other.name)
                && Objects.equal(this.price, other.price);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(
                this.name, this.price);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("name", name)
                .add("price", price)
                .toString();
    }
}
