package com.UI;

import com.company.Main;

public class MainMenu
{
    public static void showMenu()
    {
        int option = 0;

        do {
            System.out.println("--WELCOME TO THE HOT DOG TRASH--\nType an option");
            System.out.println("1. Add element\n" +
                    "2. Show hot dog\n" +
                    "3. Exit");

            option = Main.input.nextInt();

            switch (option)
            {
                case 1 :
                    HotDogMenu.showHotDogMenu();
                    break;
                case 2 :
                    System.out.println("---------------------------");
                    Main.hotDogOrder.addItem();
                    System.out.println("---------------------------");
                    break;
                case 3 :
                    System.out.println("Thank you, see you soon");
                    break;
                default:
                    System.out.println("Type a valid option");
            }

        }while(option != 3);
    }
}
