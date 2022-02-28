package com.company.models;

public class Game
{
    public static final int ID = 0;
    public static final int NAME = 1;
    public static final int PRICE = 2;

    private int id;
    private String name;
    private float price;

    public Game(int id, String name, float price)
    {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                "NAME : "+this.name+"\n" +
                "PRICE : "+this.price+"\n";
    }

}
