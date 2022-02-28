package com.company.controllers;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractController
{
    private List<Object>objects;

    public AbstractController()
    {
        this.objects = new ArrayList<>();
    }

    public List<Object> getObjects()
    {
        return this.objects;
    }

    public abstract boolean create(Object...args);
    public abstract void readList();
    public abstract boolean update(int index, Object...args);
    public boolean delete(int index)
    {
        try
        {
            this.objects.remove(index);
            return true;
        }catch (Exception e)
        {
            System.out.println("--COULD NOT BE DELETED");
        }
        return false;
    }

}
