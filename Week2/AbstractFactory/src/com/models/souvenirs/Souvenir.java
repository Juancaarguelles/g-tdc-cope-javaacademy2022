package com.models.souvenirs;

public abstract class Souvenir
{
    private int id;
    private String item;
    private float price;

    public Souvenir(int id, String item, float price)
    {
        this.id = id;
        this.item = item;
        this.price = price;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString()
    {
        return "\nID : "+this.id+"\n" +
                "ITEM : "+this.item+"\n" +
                "PRICE : "+this.price;
    }
}
