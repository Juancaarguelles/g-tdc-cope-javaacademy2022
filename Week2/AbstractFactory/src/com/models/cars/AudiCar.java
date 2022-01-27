package com.models.cars;

public class AudiCar extends Car
{
    private String reference;

    public AudiCar(int id, float price, String reference) {
        super(id, "Audi", price);
        this.reference = reference;
    }


    @Override
    public String toString()
    {
        return super.toString()+"\nREFERENCE : "+this.reference;
    }
}
