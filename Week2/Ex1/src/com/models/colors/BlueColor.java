package com.models.colors;

import com.interfaces.IColor;

public class BlueColor implements IColor
{
    private final String color = "Blue";

    @Override
    public String colorMemory()
    {
        return color;
    }
}
