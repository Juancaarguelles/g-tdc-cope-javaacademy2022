package com.models.addition;

import com.interfaces.IFoodCar;
import com.models.HotDogDecorator;

public class BaconAddition extends HotDogDecorator
{
    public BaconAddition(IFoodCar foodCar)
    {
        super(foodCar);
    }

    @Override
    public void addItem() {
        this.getFoodCar().addItem();
        System.out.println("Bacon");
    }
}
