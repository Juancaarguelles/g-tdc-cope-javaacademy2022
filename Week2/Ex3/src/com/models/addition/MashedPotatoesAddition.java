package com.models.addition;

import com.interfaces.IFoodCar;
import com.models.HotDogDecorator;

public class MashedPotatoesAddition extends HotDogDecorator
{
    public MashedPotatoesAddition(IFoodCar foodCar) {
        super(foodCar);
    }

    @Override
    public void addItem() {
        this.getFoodCar().addItem();
        System.out.println("Mashed potatoes");
    }
}
