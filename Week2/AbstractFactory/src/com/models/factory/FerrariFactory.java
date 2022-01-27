package com.models.factory;

import com.models.cars.Car;
import com.models.cars.FerrariCar;
import com.models.souvenirs.FerrariSouvenir;
import com.models.souvenirs.Souvenir;
import com.models.watchs.FerrariWatch;
import com.models.watchs.Watch;

public class FerrariFactory extends AbstractFactory{


    @Override
    public Car getCar() {
        return new FerrariCar(100, 89.000f, "Enzo");
    }

    @Override
    public Watch getWatch() {
        return new FerrariWatch(101, 1000f);
    }

    @Override
    public Souvenir getSouvenir() {
        return new FerrariSouvenir(111, "Toy car", 456f);
    }
}
