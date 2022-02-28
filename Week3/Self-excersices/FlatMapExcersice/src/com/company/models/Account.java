package com.company.models;

import java.util.ArrayList;
import java.util.List;

public class Account
{
    public static final int ID = 0;
    public static final int NAME = 1;

    private int id;
    private String name;
    private List<Game>games;

    public Account(int id, String name)
    {
        this.id = id;
        this.name = name;
        this.games = new ArrayList<>();
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

    @Override
    public String toString()
    {
        return "\nID : "+this.id+"\n" +
                "NAME : "+this.name+"\n";
    }
}
