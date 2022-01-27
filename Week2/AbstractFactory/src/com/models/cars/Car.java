package com.models.cars;

public abstract class Car
{
    private int id;
    private String brand;
    private float price;


    public Car(int id, String brand, float price)
    {
        this.id = id;
        this.brand = brand;
        this.price = price;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public float getPrice()
    {
        return price;
    }

    public void setPrice(float price)
    {
        this.price = price;
    }

    @Override
    public String toString()
    {
        return "\nID : "+this.id+"\n" +
                "BRAND : "+this.brand+"\n" +
                "PRICE : "+this.price;
    }
}
