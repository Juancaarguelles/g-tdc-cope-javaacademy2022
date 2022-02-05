package com.models;

import com.interfaces.IObserver;

import java.util.ArrayList;
import java.util.List;

public class Product
{
    private String name;
    private float price;
    private List<IObserver>clients;

    public Product(String name, float price)
    {
        this.name = name;
        this.price = price;
        this.clients = new ArrayList<>();
    }

    public List<IObserver>getClients()
    {
        return this.clients;
    }

    public boolean addSubscriber(IObserver iObserver)
    {

        if(!this.clients.contains(iObserver))
        {
            this.clients.add(iObserver);
            return true;
        }
        return false;
    }

    public boolean detachSubscriber(IObserver product)
    {
        try
        {
            if(this.clients.contains(product)) {
                this.clients.remove(product);
                return true;
            }
            return false;
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void notifySubscribers(String productNanme)
    {
        this.clients.forEach(client -> client.update(productNanme));
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public void setPrice(float price)
    {
        this.price = price;
    }

    public float getPrice()
    {
        return this.price;
    }
}
