package com.globanttopic2.Topic2.domain.UI;

import com.globanttopic2.Topic2.Topic2Application;
import org.apache.catalina.util.ToStringUtil;
import org.springframework.stereotype.Component;


@Component
public class UIMenu
{
    public void showMenu()
    {
        int option = 0;

        do
        {
            System.out.println("\n--WELCOME TO THE PRINTER MENU--");
            System.out.println("1. Add printer\n" +
                    "2. See current printers\n" +
                    "3. Print something\n" +
                    "4. Exit\n");

            option = Topic2Application.input.nextInt();
            PrinterMenu pm = Topic2Application.APPLICATION_CONTEXT.getBean(PrinterMenu.class);

            switch (option)
            {
                case 1:
                    pm.addPrinter();
                    break;
                case 2:
                    pm.showAllPrinters();
                    break;
                case 3:
                    pm.printSomething();
                    break;
                case 4:
                    System.out.println("--THANK YOU, SEE YOU SOON!--");
                    break;
                default:
                    System.out.println("--PLEASE TYPE A VALID OPTION--");
                    break;
            }

        }while(option != 4);
    }
}
