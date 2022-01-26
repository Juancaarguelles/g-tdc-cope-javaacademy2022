package com.models;

public class StandarCar
{
    private String id;
    private float price;
    private String brand;

    public StandarCar(String id , float price, String brand)
    {
        this.id = id;
        this.price = price;
        this.brand = brand;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void speedUp()
    {
        System.out.println("The car speeds up");
    }

    public void brake()
    {
        System.out.println("Thar car brakes");
    }

    public void beep()
    {
        System.out.println("The car beeps");
    }

    @Override
    public String toString()
    {
        return "\nID : "+this.getId()+"\n"+
                "PRICE : "+this.getPrice()+"$\n"+
                "BRAND : "+this.getBrand();

    }
}
