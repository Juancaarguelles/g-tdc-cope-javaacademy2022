package com.models.cars;

public class RollsRoyceCar extends Car
{
    private String nameCollection;

    public RollsRoyceCar(int id, float price, String nameCollection) {
        super(id, "Rolls Royce", price);
        this.nameCollection = nameCollection;
    }


    @Override
    public String toString()
    {
        return super.toString()+"\nCOLLECTION NAME : "+this.nameCollection;
    }
}
