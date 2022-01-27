package com.company;

public class Student extends Person
{
    public Student(Identification identification, int age)
    {
        super(identification, age);
    }

    @Override
    public String showIdentification() {
        return "Im a student : and this is my info : "+
                super.toString();
    }
}
