package com.models;

import com.interfaces.IConvertible;

public class Cabriolet extends StandarCar implements IConvertible
{

    public Cabriolet(String id, float price) {
        super(id, price, "Cabriolet");
    }

    @Override
    public void removeRoof() {
        System.out.println("Removing the Cabriolet's roof");
    }

    @Override
    public void putRoof() {
        System.out.println("Putting up Cabriolet's roof");
    }

    @Override
    public String toString()
    {
        return super.toString();
    }
}
