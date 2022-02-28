package com.UI;

import com.company.Main;
import com.interfaces.IObserver;
import com.models.Client;
import com.models.Product;

public class MainMenu
{
    public static void showMenu()
    {
        int option = 0;

        do
        {
            System.out.println("\n--WELCOME TO THE VIRTUAL STORE--");
            System.out.println("1. Select user\n" +
                    "2. Edit product\n"+
                    "3.Exit");

            option = Main.input.nextInt();

            switch (option)
            {
                case 1 :
                    ClientMenu.showClientMenu();
                    break;
                case 2:
                    ProductMenu.editProduct();
                    break;
                case 3:
                    System.out.println("\nThank you, see you soon!");
                    break;
                default:
                    System.out.println("Type a valid option please!");
                    break;
            }

        }while(option != 3);

    }
}