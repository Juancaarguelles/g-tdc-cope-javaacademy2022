package com.company;

import com.controllers.CacheMemoryController;
import com.controllers.DataBaseController;
import com.models.DataBase;

import javax.xml.crypto.Data;
import java.util.Locale;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        DataBaseController dbController = DataBaseController.getDataBaseController();
        CacheMemoryController cacheMemoryController = CacheMemoryController.getCacheMemoryController();

        dbController.addUser("100", "Juan Camilo");
        dbController.addUser("200", "Juan David");
        dbController.addUser("300", "William Ricardo");
        dbController.addUser("400", "Monica");


        char answer = ' ';

        do {
            int option = 0;
            do {
                System.out.println("1. add Database Users\n" +
                        "2. See database users\n"+
                        "3. Find User in cache memory\n");
                option = input.nextInt();
            }
            while (option < 1 || option > 3);

            switch (option)
            {
                case 1:
                    input.nextLine();
                    System.out.println("Type the ID for the user : ");
                    String id = input.nextLine();

                    System.out.println("Type the name for the user : ");
                    String name = input.nextLine();

                    dbController.addUser(id, name);
                    break;
                case 2:
                    dbController.getDatabaseInfo();
                    break;
                case 3:
                    System.out.print("Insert the id of the user : ");
                    id = input.next();
                    cacheMemoryController.getUser(id);
                    break;
                default:
                    System.out.println("Something is wrong");
                    break;
            }
            do
            {
                System.out.println("Do you want to exit? : (y for yes : n for no) : ");
                answer = input.next().charAt(0);
                if(answer >= 65 && answer <= 90)
                    answer += (char) 32;
            }
            while(answer != 'y' && answer != 'n');

        }while(answer != 'y');

                System.out.println("Thanks");

    }
}
