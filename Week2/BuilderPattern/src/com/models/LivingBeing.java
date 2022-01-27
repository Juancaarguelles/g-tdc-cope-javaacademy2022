package com.models;

public class LivingBeing
{
    private String specie;
    private String name;
    private float height;

    private LivingBeing(String specie, String name, float height)
    {
        this.specie = specie;
        this.name = name;
        this.height = height;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public LivingBeing(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    @Override
    public String toString()
    {
        return "\nSPECIE : "+this.specie+"\n" +
                "NAME : "+this.name+"\n" +
                "HEIGHT : "+this.height+"cm";
    }
}
