package com.models;

public class Alien
{
    private String id;
    private String name;
    private String planet;
    private boolean isMale;
    private int age;
    private float heigt;
    private boolean isMenace;



    public Alien(String id, String name, String planet, boolean isMale, int age, float heigt, boolean isMenace)
    {
        this.id = id;
        this.name = name;
        this.planet = planet;
        this.isMale = isMale;
        this.age = age;
        this.heigt = heigt;
        this.isMenace = isMenace;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getHeigt() {
        return heigt;
    }

    public void setHeigt(float heigt) {
        this.heigt = heigt;
    }

    public boolean isMenace() {
        return isMenace;
    }

    public void setMenace(boolean menace) {
        isMenace = menace;
    }

    @Override
    public String toString()
    {
        return "Alien{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", planet='" + planet + '\'' +
                ", isMale=" + isMale +
                ", age=" + age +
                ", heigt=" + heigt +
                ", isMenace=" + isMenace +
                '}';
    }
}
