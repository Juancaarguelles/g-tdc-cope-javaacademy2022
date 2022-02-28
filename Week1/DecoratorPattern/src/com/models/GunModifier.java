package com.models;

import com.interfaces.IGun;

public abstract class GunModifier implements IGun
{
    private IGun gun;

    public GunModifier(IGun gun)
    {
        this.gun = gun;
    }

    protected IGun getGun()
    {
        return this.gun;
    }
}
