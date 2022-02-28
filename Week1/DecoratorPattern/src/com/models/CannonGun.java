package com.models;

import com.interfaces.IGun;

public class CannonGun extends GunModifier
{

    public CannonGun(IGun gun) {
        super(gun);
    }

    @Override
    public void extraItem()
    {
        getGun().extraItem();
        System.out.println("Plugging long cannon");
    }
}
