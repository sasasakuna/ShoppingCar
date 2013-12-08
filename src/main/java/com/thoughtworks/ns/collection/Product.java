package com.thoughtworks.ns.collection;

import com.google.common.base.Objects;

public class Product {

    String name;

    public Product(String name) {
        this.name = name;
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
        return Objects.equal(this.name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(
                this.name);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("name", name)
                .toString();
    }
}
