package com.company;

import com.company.UI.UIMenu;

import java.util.Scanner;

public class Main
{
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args)
    {
        UIMenu uiMenu = UIMenu.getUiMenu();

        uiMenu.showMenu();
    }
}
