package com.models.addition;

import com.interfaces.IFoodCar;
import com.models.HotDogDecorator;

public class PineapplePieceAddition extends HotDogDecorator
{

    public PineapplePieceAddition(IFoodCar foodCar)
    {
        super(foodCar);
    }

    @Override
    public void addItem()
    {
        this.getFoodCar().addItem();
        System.out.println("Pineapple pieces");
    }
}
