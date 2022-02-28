package com.models.battery;

import com.interfaces.IBattery;

public class LongTimeBattery implements IBattery
{

    private final String battery = "8hs";
    @Override
    public String batteryInfo() {
        return battery;
    }
}
