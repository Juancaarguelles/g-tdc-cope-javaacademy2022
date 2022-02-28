package com.models;

import com.UI.ProductMenu;
import com.interfaces.IObserver;

import java.util.ArrayList;
import java.util.List;

public class Client implements IObserver
{
    private String name;
    private List<Product> products;

    public Client(String name)
    {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public boolean setProduct(Product product)
    {
        if(!this.products.contains(product))
        {
            if (product.addSubscriber(this))
            {
                this.products.add(product);
                return true;
            }
        }
        return false;
    }

    public boolean deleteProduct(Product product)
    {

        if(this.products.contains(product))
        {
        if(product.detachSubscriber(this))
        {
            this.products.remove(product);
            return true;
        }
        }
        return false;
    }

    @Override
    public void update(String productName)
    {
        for(Product current : this.products)
        {
            if(current.getName().contentEquals(productName)) {
                System.out.println("Hello ! " + this.name + " the product " + current.getName() + " now costs " + current.getPrice());
                break;
            }
        }
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public List<Product> getProducts()
    {
        return this.products;
    }

    @Override
    public String toString()
    {
        return this.getName();
    }
}
