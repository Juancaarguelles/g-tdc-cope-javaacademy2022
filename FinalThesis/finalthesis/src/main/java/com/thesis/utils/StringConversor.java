package com.thesis.utils;

import java.util.List;

public class StringConversor
{
    public static List<String>splitElements(String world)
    {
        if(world != null)
        return List.of(world.split("[\\s,]+"));
        return null;
    }
}
