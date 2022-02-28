package com.models.factory;

import com.CompanyBrand;
import com.models.cars.Car;
import com.models.souvenirs.Souvenir;
import com.models.watchs.Watch;

public abstract class AbstractFactory
{

    private static final AudiFactory audiFactory = new AudiFactory();
    private static  final FerrariFactory ferrariFactory = new FerrariFactory();
    private static final RollsRoyceFactory rollsRoyceFactory = new RollsRoyceFactory();
    private static AbstractFactory abstractFactory;

    public abstract Car getCar();
    public abstract Watch getWatch();
    public abstract Souvenir getSouvenir();

    public static AbstractFactory getAbstractFactory(CompanyBrand brandName)
    {
        switch (brandName)
        {
            case AUDI : abstractFactory = audiFactory;
            break;
            case ROLLS_ROYCE: abstractFactory = rollsRoyceFactory;
            break;
            case FERRARI: abstractFactory = ferrariFactory;
        }
        return abstractFactory;
    }
}

