package com.company;

import com.UI.MainMenu;
import com.interfaces.IBattery;
import com.interfaces.IColor;
import com.interfaces.IMemory;
import com.models.MusicPlayer;

import java.util.Scanner;

public class Main {

    public static Scanner input = new Scanner(System.in);
    public static MusicPlayer mp = new MusicPlayer();
    public static IColor color;
    public static IBattery battery;
    public static IMemory memory;

    public static void main(String[] args)
    {
        MainMenu.showMenu();
    }
}
