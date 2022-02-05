package com.models.battery;

import com.interfaces.IBattery;

public class ShortTimeBattery implements IBattery
{
    private final String battery = "5hs";

    @Override
    public String batteryInfo() {
        return battery;
    }
}
