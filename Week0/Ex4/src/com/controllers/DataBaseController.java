package com.controllers;

import com.models.DataBase;
import com.models.User;

public class DataBaseController
{
    private static DataBaseController dataBaseController;
    private DataBase database;

    private DataBaseController()
    {
        this.database = DataBase.getDatabase();
    }

    public static DataBaseController getDataBaseController()
    {
        if(dataBaseController == null)
            dataBaseController = new DataBaseController();
        return dataBaseController;
    }

    public void getDatabaseInfo()
    {
        System.out.println(this.database.showUsers());
    }

    public void addUser(String id, String name)
    {
        if(this.database.addUser(id.toLowerCase(), name.toLowerCase()))
            System.out.println("User "+name+" added succesfully into the database");
        else
            System.out.println("User "+name+" couldn't be added into the database(Probably it already exists)");
    }

    public void getUserInfo(String id)
    {
        if(this.database.findOne(id.toLowerCase()) != null)
            System.out.println("USER WITH ID "+id+" EXISTS IN DATABASE WITH INFO "+this.database.findOne(id.toLowerCase()));
        else
            System.out.println("USER WITH ID "+id+" DOES NOT EXIST IN DATABASE\n"+
                    "PLEASE ADD USER TO DATABASE");
    }

    public boolean existsUser(String id)
    {
        if(this.database.findOne(id.toLowerCase()) != null)
            return true;
        return false;
    }

    public User getUser(String id)
    {
        return this.database.findOne(id.toLowerCase());
    }
}

