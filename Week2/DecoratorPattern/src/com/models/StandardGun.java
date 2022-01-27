package com.models;

import com.interfaces.IGun;

public class StandardGun implements IGun
{
    @Override
    public void extraItem()
    {
        System.out.println("Normal gun");
    }
}
