package com.models.colors;

import com.interfaces.IColor;

public class GreenColor implements IColor
{
    private final String color = "Green";

    @Override
    public String colorMemory()
    {
        return color;
    }
}
