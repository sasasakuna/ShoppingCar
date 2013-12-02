package com.thoughtworks.ns.collection;

import com.google.common.base.Objects;

public class Product {

    String name;

    public Product(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }


    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return  true;
        if(getClass() != obj.getClass())
        {
             return  false;
        }
        Product product = (Product)obj;
        return name .equals(product.name);
    }
}
