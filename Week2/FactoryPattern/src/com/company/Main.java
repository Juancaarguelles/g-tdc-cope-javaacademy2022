package com.company;

import javax.swing.*;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args)
    {

        Scanner input = new Scanner(System.in);

        Identification identification;
        Person person;

        char option = ' ';

        do
        {
            option = JOptionPane.showInputDialog(null, "type s for student and p for professor : ").charAt(0);

            if(option >= 65 && option <= 90)
                option += (char) 32;

            if(option != 'p' && option != 's') {
                System.out.println("Type a valid option please");
                continue;
            }
        }while(option != 'p' && option != 's');

        System.out.println( (option == 's' ? "student mode" : "professor mode"));

        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Type the id"));
        String country = JOptionPane.showInputDialog(null, "Type the country");
        int age = Integer.parseInt(JOptionPane.showInputDialog(null, "Type the age"));
        identification = new Identification(id, country);

        person = option == 's' ? new Student(identification, age) : new Professor(identification, age);
        System.out.println(person.showIdentification());

    }

}


