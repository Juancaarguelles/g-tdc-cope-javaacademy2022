package com.UI;

import com.company.Main;
import com.interfaces.IColor;
import com.models.battery.LongTimeBattery;
import com.models.battery.ShortTimeBattery;
import com.models.colors.BlueColor;
import com.models.colors.GreenColor;
import com.models.memory.BigMemory;
import com.models.memory.SmallMemory;

public class MediaPlayerMenu
{
    public static void showMediaPlayerMenu()
    {
        int option = 0;

        do {

            System.out.println("\n--SELECT YOUR CONFIGURATION--");
            System.out.println("1. Choose Color\n" +
                    "2. Choose battery\n" +
                    "3. Choose memory\n" +
                    "4. Cancel");

            option = Main.input.nextInt();

            switch (option)
            {
                case 1:
                    selectColor();
                    break;
                case 2:
                    selectBattery();
                    break;
                case 3:
                    selectMemory();
                    break;
                case 4:
                    System.out.println("\n--GOING TO MENU--");
                    break;
                default:
                    System.out.println("Please type a valid option");
                    break;
            }

        }while(option != 4);
    }

    private static void selectColor()
    {
        int option = 0;

        do
        {
            System.out.println("\n--SELECT THE COLOR--");
            System.out.println("1. Green\n" +
                    "2. Blue");

            option = Main.input.nextInt();

            switch (option)
            {
                case 1:
                    Main.color = new GreenColor();
                    break;
                case 2:
                    Main.color = new BlueColor();
                    break;
            }

            if(option < 1 || option > 2)
                System.out.println("\n--Please select a valid option--");

        }while(option < 1 || option > 2);

        Main.mp.setColor(Main.color);
    }
    private static void selectBattery()
    {
        int option = 0;

        do
        {
            System.out.println("\n--SELECT THE COLOR--");
            System.out.println("1. 8hs\n" +
                    "2. 5hs");

            option = Main.input.nextInt();

            switch (option)
            {
                case 1:
                    Main.battery = new LongTimeBattery();
                    break;
                case 2:
                    Main.battery = new ShortTimeBattery();
                    break;
            }

            if(option < 1 || option > 2)
                System.out.println("\n--Please select a valid option--");

        }while(option < 1 || option > 2);

        Main.mp.setBattery(Main.battery);
    }private static void selectMemory()
    {
        int option = 0;

        do
        {
            System.out.println("\n--SELECT THE COLOR--");
            System.out.println("1. 8GB\n" +
                    "2. 16GB");

            option = Main.input.nextInt();

            switch (option)
            {
                case 1:
                    Main.memory = new SmallMemory();
                    break;
                case 2:
                    Main.memory = new BigMemory();
                    break;
            }

            if(option < 1 || option > 2)
                System.out.println("\n--Please select a valid option--");

        }while(option < 1 || option > 2);

        Main.mp.setMemory(Main.memory);
    }



}
