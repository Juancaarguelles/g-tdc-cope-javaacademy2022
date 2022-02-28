package com.company;

import com.interfaces.IGun;
import com.models.ButtGun;
import com.models.CannonGun;
import com.models.StandardGun;

public class Main {

    public static void main(String[] args)
    {
        IGun normalGun = new StandardGun();
        System.out.println("NORMAL GUN");
        normalGun.extraItem();

        IGun mediumGun = new ButtGun((new StandardGun()));
        System.out.println("\nMEDIUM GUN");
        mediumGun.extraItem();

        IGun longGun = new CannonGun(new ButtGun(new StandardGun()));
        System.out.println("\nLONG GUN");
        longGun.extraItem();
    }
}
