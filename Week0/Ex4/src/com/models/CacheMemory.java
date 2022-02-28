package com.models;

import com.controllers.DataBaseController;

import java.util.HashMap;
import java.util.Map;

public class CacheMemory {
    private static CacheMemory cacheMemory;
    private Map<String, User> memory;
    private DataBaseController dataBaseController;


    private CacheMemory() {
        this.memory = new HashMap<>();
        this.dataBaseController = DataBaseController.getDataBaseController();
    }

    public static CacheMemory getCacheMemory() {
        if (cacheMemory == null)
            cacheMemory = new CacheMemory();
        return cacheMemory;
    }

    public void addUser(User user) {
        this.memory.put(user.getId(), user);
    }

    public User findUser(String id) {
        for (User current : this.memory.values()) {
            if (current.getId().equals(id))
                return current;
        }
        return null;
    }

    public boolean existsUser(String id)
    {
        return findUser(id) != null ? true : false;
    }


    public User getUser(String id) {

        boolean exists = existsUser(id);

        if(exists)
        {
            User tempUser = findUser(id);
            return tempUser;
        }
        else
        {
            this.dataBaseController.getUserInfo(id);
            if (this.dataBaseController.existsUser(id))
            {
                User dbUser = this.dataBaseController.getUser(id);
                System.out.println("User added into cache memory");
                this.memory.put(dbUser.getId(), dbUser);
                return this.memory.get(id);
            }
        }
        return null;
    }
}
