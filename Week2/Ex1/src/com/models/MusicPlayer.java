package com.models;

import com.interfaces.IBattery;
import com.interfaces.IColor;
import com.interfaces.IMemory;

public class MusicPlayer
{
    private IColor color;
    private IBattery battery;
    private IMemory memory;

    public MusicPlayer(){}

    public MusicPlayer(IColor iColor, IBattery iBattery, IMemory iMemory)
    {
        this.color = iColor;
        this.battery = iBattery;
        this.memory = iMemory;
    }

    public IColor getColor() {
        return color;
    }

    public void setColor(IColor color) {
        this.color = color;
    }

    public IBattery getBattery() {
        return battery;
    }

    public void setBattery(IBattery battery) {
        this.battery = battery;
    }

    public IMemory getMemory() {
        return memory;
    }

    public void setMemory(IMemory memory) {
        this.memory = memory;
    }

    @Override
    public String toString()
    {
        return "\n--MUSIC PLAYER INFO--\n" +
                "COLOR : "+color.colorMemory()+
                "\nBATTERY : "+battery.batteryInfo()+
                "\nMEMORY : "+memory.memoryInfo()+"\n";
    }
}
