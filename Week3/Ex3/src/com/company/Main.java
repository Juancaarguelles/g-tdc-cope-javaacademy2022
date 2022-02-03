package com.company;

import com.UI.MainMenu;
import com.interfaces.IFoodCar;
import com.models.StandardHotDog;
import com.models.addition.BaconAddition;
import com.models.addition.PineapplePieceAddition;
import com.models.addition.SauceAddition;

import java.util.Scanner;

public class Main {

    public static IFoodCar hotDogOrder = new StandardHotDog();
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args)
    {
        MainMenu.showMenu();
    }
}