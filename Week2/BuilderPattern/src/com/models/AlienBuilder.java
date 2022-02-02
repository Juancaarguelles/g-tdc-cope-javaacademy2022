package com.models;

public class AlienBuilder
{
    private String id;
    private String name;
    private String planet;
    private boolean isMale;
    private int age;
    private float heigt;
    private boolean isMenace;

    public AlienBuilder(String id)
    {
        this.id = id;
    }

    public AlienBuilder setName(String name)
    {
        this.name = name;
        return this;
    }

    public AlienBuilder setPlanet(String planet)
    {
        this.planet = planet;
        return this;
    }

    public AlienBuilder setIsMale(boolean isMale)
    {
        this.isMale = isMale;
        return this;
    }

    public AlienBuilder setAge(int age)
    {
        this.age = age;
        return this;
    }

    public AlienBuilder setHeight(float height)
    {
        this.heigt = height;
        return this;
    }

    public AlienBuilder setIsMenace(boolean isMenace)
    {
        this.isMenace = isMenace;
        return this;
    }

    public Alien build()
    {
        return new Alien(this.id, this.name, this.planet, this.isMale, this.age, this.heigt, this.isMenace);
    }

}
