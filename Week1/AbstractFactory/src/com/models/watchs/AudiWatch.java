package com.models.watchs;

public class AudiWatch extends Watch
{
    public AudiWatch(int id, float price) {
        super(id, price);
    }

    @Override
    public String toString()
    {
        return "Im an Audi Watch : "+super.toString();
    }
}
