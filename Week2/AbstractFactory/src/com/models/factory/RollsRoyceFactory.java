package com.models.factory;

import com.models.cars.Car;
import com.models.cars.RollsRoyceCar;
import com.models.souvenirs.RollsRoyceSouvenir;
import com.models.souvenirs.Souvenir;
import com.models.watchs.RollsRoyceWatch;
import com.models.watchs.Watch;

public class RollsRoyceFactory extends AbstractFactory
{
    @Override
    public Car getCar() {
        return new RollsRoyceCar(200, 768.000f, "King of cars");
    }

    @Override
    public Watch getWatch() {
        return new RollsRoyceWatch(202, 2000f);
    }

    @Override
    public Souvenir getSouvenir() {
        return new RollsRoyceSouvenir(222, "Symbol", 105);
    }
}
