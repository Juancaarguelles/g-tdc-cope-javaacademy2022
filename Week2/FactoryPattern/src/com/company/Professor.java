package com.company;

public class Professor extends Person
{
    public Professor(Identification identification, int age)
    {
        super(identification, age);
    }

    @Override
    public String showIdentification()
    {
        return "Im a professor : and this is my info : "+
                super.toString();
    }


}
