package com.models.souvenirs;

public class FerrariSouvenir extends Souvenir
{
    public FerrariSouvenir(int id, String item, float price) {
        super(id, item, price);
    }

    @Override
    public String toString()
    {
        return "Im a ferrari souvenir : "+super.toString();
    }
}
