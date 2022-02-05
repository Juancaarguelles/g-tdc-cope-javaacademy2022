package com.UI;

import com.company.Main;
import com.interfaces.IObserver;
import com.models.Client;

public class ClientMenu
{
    public static void showClientMenu()
    {
        showClients();
    }

    public static void showClients()
    {
        int selectedClient = 0;

        do
        {
            int index = 0;

            System.out.println("\n--SELECT THE INDEX OF THE CLIENT--");

            for(IObserver current : Main.clients)
            {
                Client client = ((Client)current);
                System.out.println((++index)+" "+client.getName());
            }
            selectedClient = Main.input.nextInt();

            if(selectedClient < 1 || selectedClient > Main.clients.size())
                System.out.println("Please type a valid index");
        }
        while(selectedClient < 1 || selectedClient > Main.clients.size());

        Main.activeClient = Main.clients.get(selectedClient - 1);

        System.out.println("\n--"+((Client)Main.activeClient).getName()+" SELECTED--");

        selectClientOption();
    }

    public static void selectClientOption()
    {
        int option = 0;
        do
        {
            System.out.println("--TYPE THE OPTION THAT YOU WANT FOR THE CLIENT--");
            System.out.println("\n1. Subscribe to product\n" +
                    "2. Unsubscribe to product\n" +
                    "3. Cancel");

            option = Main.input.nextInt();

            switch (option)
            {
                case 1 :
                    ProductMenu.subscribeProduct();
                    break;
                case 2:
                    ProductMenu.unsubscribeProduct();
                    break;
                case 3:
                    System.out.println("--Coming back to the menu!");
                    break;
                default:
                    System.out.println("Please type a valid option");
                    break;
            }

        }while(option != 3);
        Main.activeClient = null;
    }
}
