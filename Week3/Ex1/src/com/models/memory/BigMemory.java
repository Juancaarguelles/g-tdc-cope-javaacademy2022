package com.models.memory;

import com.interfaces.IMemory;

public class BigMemory implements IMemory
{
    private final String memory = "16GB";

    @Override
    public String memoryInfo()
    {
        return memory;
    }
}
