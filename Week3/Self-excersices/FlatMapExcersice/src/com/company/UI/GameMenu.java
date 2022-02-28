package com.company.UI;

import com.company.Main;
import com.company.controllers.GameController;

public class GameMenu
{
    private static GameMenu gameMenu;
    private GameController gameController;

    private GameMenu()
    {
        this.gameController = GameController.getGameController();
    }

    public void showGameMenu()
    {
        int option = 0;

        do {

            System.out.println("\n--GAME MENU--");
            System.out.println("1. Add game\n" +
                    "2. Show Games\n" +
                    "3. Exit");

            option = Main.input.nextInt();

            switch (option)
            {
                case 1:
                    System.out.println("Type the id : ");
                    int id = Main.input.nextInt();
                    System.out.println("Type the name : ");
                    String name = Main.input.next();
                    System.out.println("Type the price : ");
                    float price = Main.input.nextFloat();

                    if(this.gameController.create(id, name, price))
                        System.out.println("--NEW GAME ADDED--");
                    else
                        System.out.println("--SOMETHING HAS GONE WRONG--");
                    break;
                case 2:
                    this.gameController.readList();
                    break;
                case 3:
                    System.out.println("--GOING BACK TO MENU--");
                    break;
                default:
                    System.out.println("--TYPE A VALID OPTION--");
                    break;
            }
        }while (option != 3);
    }

    public static GameMenu getGameMenu()
    {
        if(gameMenu == null)
            return new GameMenu();
        return gameMenu;
    }
}
