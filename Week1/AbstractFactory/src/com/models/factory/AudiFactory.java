package com.models.factory;

import com.models.cars.AudiCar;
import com.models.cars.Car;
import com.models.souvenirs.AudiSouvenir;
import com.models.souvenirs.Souvenir;
import com.models.watchs.AudiWatch;
import com.models.watchs.Watch;

public class AudiFactory extends AbstractFactory
{

    @Override
    public Car getCar() {
        return new AudiCar(300, 120.000f, "R8");
    }

    @Override
    public Watch getWatch() {
        return new AudiWatch(303, 200f);
    }

    @Override
    public Souvenir getSouvenir() {
        return new AudiSouvenir(333, "Picture", 45f);
    }
}
