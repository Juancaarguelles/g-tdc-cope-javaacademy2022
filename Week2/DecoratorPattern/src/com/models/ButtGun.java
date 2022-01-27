package com.models;

import com.interfaces.IGun;

public class ButtGun extends GunModifier
{
    public ButtGun(IGun gun) {
        super(gun);
    }

    @Override
    public void extraItem() {
        getGun().extraItem();
        System.out.println("Plugging butt Gun");
    }
}
