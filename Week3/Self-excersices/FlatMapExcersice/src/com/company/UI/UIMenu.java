package com.company.UI;

import com.company.Main;

public class UIMenu
{
    private static UIMenu uiMenu;
    private GameMenu gameMenu;

    private UIMenu()
    {
        this.gameMenu = GameMenu.getGameMenu();
    }

    public void showMenu()
    {
        int option = 0;

        do
        {
            System.out.println("--SIMULATION SYSTEM ACCOUNT--");
            System.out.println("1. GAMES MENU\n" +
                    "2. ACCOUNT MENU\n" +
                    "3. EXIT ");

            option = Main.input.nextInt();

            switch (option)
            {
                case 1:
                    this.gameMenu.showGameMenu();
                    break;
                case 2: break;
                case 3:
                    System.out.println("--THANK YOU--");
                    break;
                default:
                    System.out.println("--TYPE A VALID OPTION--");
                    break;
            }

        }while(option != 3);
    }

    public static UIMenu getUiMenu()
    {
        if(uiMenu == null)
            return new UIMenu();
        return new UIMenu();

    }
}
