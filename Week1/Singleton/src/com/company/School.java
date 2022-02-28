package com.company;

import java.util.ArrayList;
import java.util.List;

public class School
{
    private static School classroom;

    private List<String>names;

    private School()
    {
        this.names = new ArrayList<>();
    }

    public static School getClassroom()
    {
        if(classroom == null)
            classroom = new School();
        return classroom;
    }

    public void addStudent(String name)
    {
        String student = findOne(name);

        if(student != null)
            System.out.println(name+" is already in the classroom");
        else
        {
            names.add(name);
            System.out.println(name+" is the new of the class :)");
        }
    }

    public String showAllClass()
    {
        StringBuilder str = new StringBuilder();

        for (String name : names)
            str.append(name+"\n");

        return str.toString();
    }

    public String findOne(String name)
    {
        for(String currentStudent : names)
        {
            if(currentStudent.equals(name))
                return currentStudent;
        }
        return null;
    }

}
