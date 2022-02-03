package com.UI;

import com.company.Main;
import com.models.addition.BaconAddition;
import com.models.addition.MashedPotatoesAddition;
import com.models.addition.PineapplePieceAddition;
import com.models.addition.SauceAddition;

public class HotDogMenu
{
    public static void showHotDogMenu()
    {
        int option = 0;

        do {
            System.out.println("--CHOOSE YOUR ADDITION--");

            System.out.println("1. Sauce\n" +
                    "2. Smashed potatoes\n" +
                    "3. Pineapple pieces\n" +
                    "4. Bacon\n" +
                    "5. Cancel");

            option = Main.input.nextInt();

            switch (option)
            {
                case 1:
                    String sauce = "";
                    try
                    {
                        System.out.println("Type a sauce : ");
                        sauce = Main.input.next();
                    }catch(Exception e)
                    {
                        System.out.println("Not valid word");
                    }
                    Main.hotDogOrder = new SauceAddition(Main.hotDogOrder, sauce);
                    break;
                case 2:
                    Main.hotDogOrder = new MashedPotatoesAddition(Main.hotDogOrder);
                    break;
                case 3:
                    Main.hotDogOrder = new PineapplePieceAddition(Main.hotDogOrder);
                    break;
                case 4:
                    Main.hotDogOrder = new BaconAddition(Main.hotDogOrder);
                    break;
                case 5:
                    System.out.println("Ok...");
                    break;
                default:
                    System.out.println("Type a valid option");
                    break;
            }

        }while(option != 5);
    }
}
