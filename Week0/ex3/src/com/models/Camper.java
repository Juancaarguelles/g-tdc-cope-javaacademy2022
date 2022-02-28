package com.models;

import com.interfaces.ITraction;

public class Camper extends StandarCar implements ITraction {
    public Camper(String id, float price, String brand) {
        super(id, price, brand);
    }

    @Override
    public void applyTraction() {
        System.out.println("Applying traction to the camper");
    }

    @Override
    public String toString()
    {
        return super.toString();
    }
}
