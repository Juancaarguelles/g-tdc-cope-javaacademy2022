package com.models.souvenirs;

public class AudiSouvenir extends Souvenir
{
    public AudiSouvenir(int id, String item, float price) {
        super(id, item, price);
    }

    @Override
    public String toString()
    {
        return "Im an Audi souvenir : "+super.toString();
    }
}
