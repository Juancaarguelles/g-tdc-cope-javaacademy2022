package com.models;

import com.interfaces.IFoodCar;

public class StandardHotDog implements IFoodCar
{
    private float price;
    private String primaryContent;

    public StandardHotDog(float price, String primaryContent)
    {
        this.price = price;
        this.primaryContent = primaryContent;
    }


    @Override
    public void addItem()
    {
        System.out.println("\tCONTENT");
    }

    public void setPrice(float price)
    {
        this.price = price;
    }

    public float getPrice()
    {
        return this.price;
    }

    @Override
    public String toString()
    {
        return "Price : "+this.price+"\n"+
                "Basic content : "+this.primaryContent;
    }
}
