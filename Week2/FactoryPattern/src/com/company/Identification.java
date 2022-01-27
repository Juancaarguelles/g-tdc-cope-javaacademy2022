package com.company;

public class Identification
{
    private int id;
    private String country;

    public Identification(int id, String country)
    {
        this.id = id;
        this.country = country;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return this.id;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getCountry()
    {
        return this.country;
    }

    @Override
    public String toString()
    {
        return "ID : "+this.id+"\n"+
                "COUNTRY : "+this.country+"\n";
    }
}
