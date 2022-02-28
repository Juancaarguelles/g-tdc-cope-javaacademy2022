package com.company;

public abstract class Person {
    private Identification identification;
    private int age;

    public Person(Identification identification, int age) {
        this.identification = identification;
        this.age = age;
    }

    public abstract String showIdentification();

    @Override
    public String toString() {
        return this.identification +
                "AGE : " + this.age + "\n";
    }
}