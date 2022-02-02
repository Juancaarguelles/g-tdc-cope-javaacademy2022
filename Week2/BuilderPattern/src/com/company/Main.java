package com.company;

import com.models.Alien;
import com.models.AlienBuilder;

public class Main
{
    public static void main(String[] args)
    {
        Alien alien = new AlienBuilder("100").setName("Aswed").setPlanet("Zircons").build();
        System.out.println(alien);
    }
}
