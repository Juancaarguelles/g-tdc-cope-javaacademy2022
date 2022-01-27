package com.company;

import com.CompanyBrand;
import com.models.cars.Car;
import com.models.factory.AbstractFactory;
import com.models.factory.RollsRoyceFactory;
import com.models.souvenirs.Souvenir;
import com.models.watchs.Watch;

public class Main {

    public static void main(String[] args)
    {
        AbstractFactory factory = AbstractFactory.getAbstractFactory(CompanyBrand.AUDI);
        Car audiCar = factory.getCar();
        System.out.println(audiCar);
        Watch audiWatch = factory.getWatch();
        System.out.println(audiWatch);

        factory = AbstractFactory.getAbstractFactory(CompanyBrand.ROLLS_ROYCE);
        Watch rollsRoyceWatch = factory.getWatch();
        System.out.println(rollsRoyceWatch);
        Souvenir rollsRoyceSouvenir = factory.getSouvenir();
        System.out.println(rollsRoyceSouvenir);
    }
}
