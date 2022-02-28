package com.company;

import com.models.Cabriolet;
import com.models.Camper;
import com.models.StandarCar;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args)
    {
        List<StandarCar>cars = new ArrayList<>();

        cars.add(new StandarCar("100", 10.000f, "Chevy"));
        cars.add(new Cabriolet("200", 87.000f));
        cars.add(new Camper("300", 46.000f, "Ford"));

        for(StandarCar currentCar : cars)
        {
            System.out.println(currentCar);

            if(currentCar instanceof Cabriolet)
            {
                ((Cabriolet)currentCar).putRoof();
                ((Cabriolet)currentCar).removeRoof();
            }
            if(currentCar instanceof Camper)
                ((Camper)currentCar).applyTraction();
        }

    }
}
