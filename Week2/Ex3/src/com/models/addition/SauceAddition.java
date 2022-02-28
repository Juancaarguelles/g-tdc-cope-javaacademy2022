package com.models.addition;

import com.interfaces.IFoodCar;
import com.models.HotDogDecorator;

public class SauceAddition extends HotDogDecorator
{
    private String sauce;
    public SauceAddition(IFoodCar foodCar, String sauce)
    {
        super(foodCar);
        this.sauce = sauce;
    }

    @Override
    public void addItem()
    {
        this.getFoodCar().addItem();
        System.out.println("Sauce : "+this.sauce);
    }
}
