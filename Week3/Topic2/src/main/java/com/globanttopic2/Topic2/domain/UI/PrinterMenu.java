package com.globanttopic2.Topic2.domain.UI;

import com.globanttopic2.Topic2.Topic2Application;
import com.globanttopic2.Topic2.domain.enums.PrinterType;
import com.globanttopic2.Topic2.domain.controllers.PrinterController;
import com.globanttopic2.Topic2.domain.entities.BWMode;
import com.globanttopic2.Topic2.domain.entities.ColorMode;
import com.globanttopic2.Topic2.domain.entities.Printer;
import com.globanttopic2.Topic2.domain.entities.PrinterColor;
import org.springframework.stereotype.Component;


@Component
public class PrinterMenu
{
    private PrinterController pc;



    public void showAllPrinters()
    {
        pc = Topic2Application.APPLICATION_CONTEXT.getBean(PrinterController.class);
        int index = 1;

        if(pc.getPrinters().size() > 0)
        {
            for (Printer current : pc.getPrinters())
                System.out.println((index++) + ". " + current.getPrinterType());
        }
        else
            System.out.println("--THERE IS NO ANY PRINTER YET, PLEASE ADD ONE--\n");
    }

    public void addPrinter()
    {
        pc = Topic2Application.APPLICATION_CONTEXT.getBean(PrinterController.class);
        showPrinterModes();
        if(Topic2Application.PRINTER_TYPE != PrinterType.NONE)
            pc.addPrinter(Topic2Application.PRINTER_TYPE);
    }

    public void printSomething()
    {
        pc = Topic2Application.APPLICATION_CONTEXT.getBean(PrinterController.class);
        int option = 0;

        do {

            showAllPrinters();
            System.out.println("\n--SELECT ONE--");
            option = Topic2Application.input.nextInt();

            if(option < 1 || option > pc.getPrinters().size())
                System.out.println("--PLEASE TYPE A VALID INDEX--");

        }while(option < 1 || option > pc.getPrinters().size());

        Printer tempPrinter = pc.getPrinter(option - 1);
        if(tempPrinter.getPrinterType()!= PrinterType.BLACKWHITE.getPrintMode())
        {
            showPrinterModes();
            switch (Topic2Application.PRINTER_TYPE)
            {
                case BLACKWHITE:
                ((PrinterColor) tempPrinter).setiPrinter(new BWMode());
                break;
                case COLOR:
                    ((PrinterColor) tempPrinter).setiPrinter(new ColorMode());
                    break;
            }
        }
        if(Topic2Application.PRINTER_TYPE != PrinterType.NONE)
        tempPrinter.showPrinterMessage();
    }

    private void showPrinterModes()
    {
        int option = 0;

        do {
            System.out.println("\n--CHOOSE PRINT MODE--");
            System.out.println("1. Black and White\n" +
                    "2. Color\n" +
                    "3. Exit");

            option = Topic2Application.input.nextInt();

            switch (option)
            {
                case 1:
                    Topic2Application.PRINTER_TYPE = PrinterType.BLACKWHITE;
                    option = 3;
                    break;
                case 2:
                    Topic2Application.PRINTER_TYPE = PrinterType.COLOR;
                    option = 3;
                    break;
                case 3:
                    Topic2Application.PRINTER_TYPE = PrinterType.NONE;
                    System.out.println("\n--GOING BACK TO MENU--");
                    break;
                default:
                    System.out.println("--TYPE A VALID OPTION--");
                    break;
            }

        }while(option != 3);
    }
}
