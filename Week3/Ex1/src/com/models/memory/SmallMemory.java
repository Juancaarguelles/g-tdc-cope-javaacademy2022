package com.models.memory;

import com.interfaces.IMemory;

public class SmallMemory implements IMemory
{
    private final String memory = "8GB";

    @Override
    public String memoryInfo()
    {
        return memory;
    }
}
