package com.models;

import java.util.ArrayList;
import java.util.List;

public class DataBase
{
    private static DataBase database;
    private List<User>users;

    private DataBase()
    {
        this.users = new ArrayList<>();
    }

    public static DataBase getDatabase()
    {
        if(database == null)
            database = new DataBase();

        return database;
    }

    public boolean addUser(String id, String name)
    {
        User temp = findOne(id);

        if(temp == null)
        {
            this.users.add(new User(id, name));
            return true;
        }
        else
            return false;
    }

    public String showUsers()
    {
        StringBuilder strb = new StringBuilder();

        for(User currentUser : this.users)
            strb.append(currentUser);

        return strb.toString();
    }

    public User findOne(String id)
    {
        for(User currentUser : this.users)
        {
            if(currentUser.getId() .equals(id))
                return currentUser;
        }
        return null;
    }

}
