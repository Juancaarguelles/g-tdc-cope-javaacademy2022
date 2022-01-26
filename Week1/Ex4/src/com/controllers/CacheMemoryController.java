package com.controllers;

import com.models.CacheMemory;

public class CacheMemoryController
{
    private static CacheMemoryController cacheMemoryController;
    private CacheMemory cacheMemory;

    private CacheMemoryController()
    {
        cacheMemory = CacheMemory.getCacheMemory();
    }

    public static CacheMemoryController getCacheMemoryController()
    {
        if(cacheMemoryController == null)
            cacheMemoryController = new CacheMemoryController();
        return cacheMemoryController;
    }

    public void userExists(String id)
    {
        if(cacheMemory.existsUser(id.toLowerCase()))
            System.out.println("Getting user from cache memory");
        else
            System.out.println("User does not exists in cache memory,\n" +
                    "We are checking if it exists in database");
    }

    public void getUser(String id)
    {
        userExists(id.toLowerCase());

        if(cacheMemory.getUser(id.toLowerCase())!= null)
            System.out.println(cacheMemory.getUser(id.toLowerCase()));
    }
}
