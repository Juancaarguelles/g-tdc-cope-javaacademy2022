package com.models;

import com.interfaces.IFoodCar;

public class HotDogDecorator implements IFoodCar
{
    private IFoodCar foodCar;

    public HotDogDecorator(IFoodCar foodCar)
    {
        this.foodCar = foodCar;
    }

    

    @Override
    public void addItem() {

    }
}
