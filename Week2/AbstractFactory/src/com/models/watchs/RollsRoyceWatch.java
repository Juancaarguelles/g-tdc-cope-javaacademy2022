package com.models.watchs;

public class RollsRoyceWatch extends Watch
{
    public RollsRoyceWatch(int id, float price) {
        super(id, price);
    }

    @Override
    public String toString()
    {
        return "Im a Rolls Royce Watch : "+super.toString();
    }
}
