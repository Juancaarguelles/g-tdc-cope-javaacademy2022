package com.company;

public class Main {

    public static void main(String[] args)
    {
	    School theClass = School.getClassroom();
        theClass.addStudent("Juan");
        theClass.addStudent("Camilo");
        School theClass2 = School.getClassroom();
        theClass2.addStudent("David");
        theClass2.addStudent("Daniela");

        System.out.println(theClass2.showAllClass());
    }
}
