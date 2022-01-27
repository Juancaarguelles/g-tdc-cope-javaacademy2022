package com.models.cars;

public class FerrariCar extends Car
{
    private String model;
    public FerrariCar(int id, float price, String model)
    {
        super(id, "Ferrari", price);
        this.model = model;
    }

    @Override
    public String toString()
    {
        return super.toString()+"\nMODEL : "+this.model;
    }
}
