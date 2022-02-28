package com.models;

import com.interfaces.IFoodCar;

public abstract class HotDogDecorator implements IFoodCar
{
    private IFoodCar foodCar;

    public HotDogDecorator(IFoodCar foodCar)
    {
        this.foodCar = foodCar;
    }

    public IFoodCar getFoodCar()
    {
        return this.foodCar;
    }


}
