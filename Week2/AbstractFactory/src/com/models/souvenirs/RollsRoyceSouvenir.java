package com.models.souvenirs;

public class RollsRoyceSouvenir extends Souvenir
{
    public RollsRoyceSouvenir(int id, String item, float price) {
        super(id, item, price);
    }

    @Override
    public String toString()
    {
        return "Im a rolls royce souvenir : "+super.toString();
    }
}
