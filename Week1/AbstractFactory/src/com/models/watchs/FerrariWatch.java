package com.models.watchs;

public class FerrariWatch extends Watch
{

    public FerrariWatch(int id, float price) {
        super(id, price);
    }

    @Override
    public String toString(){
        return "Im a Ferrari Watch : "+super.toString();
    }
}
