package com.UI;

import com.company.Main;

public class MainMenu
{
    public static void showMenu()
    {
        int option = 0;

        do {
            System.out.println("\n--WELCOME TO JC STORE--");
            System.out.println("1. Assemble your MUSIC PLAYER\n" +
                    "2. See your MUSIC PLAYER\n" +
                    "3. Exit");

            option = Main.input.nextInt();

            switch (option)
            {
                case 1:
                    MediaPlayerMenu.showMediaPlayerMenu();
                    break;
                case 2:
                    if(Main.battery != null && Main.memory != null && Main.color != null)
                        System.out.println(Main.mp);
                    else
                        System.out.println("\n--IN ORDER TO SEE THE COMPONENTS OF THE \n" +
                                " MUSIC PLAYER YOU NEED TO SPECIFIY ALL CHARACTERISTICS--");
                    break;
                case 3:
                    System.out.println("Thank you, See you soon!");
                    break;
                default:
                    System.out.println("Please type a valid option");
                    break;
            }

        }while(option != 3);
    }
}