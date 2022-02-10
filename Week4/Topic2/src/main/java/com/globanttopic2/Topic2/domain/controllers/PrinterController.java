package com.globanttopic2.Topic2.domain.controllers;

import com.globanttopic2.Topic2.Topic2Application;
import com.globanttopic2.Topic2.domain.entities.BWMode;
import com.globanttopic2.Topic2.domain.enums.PrinterType;
import com.globanttopic2.Topic2.domain.entities.Printer;
import com.globanttopic2.Topic2.domain.entities.PrinterBW;
import com.globanttopic2.Topic2.domain.entities.PrinterColor;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PrinterController
{
    private static int ID;
    private static PrinterController printerController;

    private List<Printer>printers;

    private PrinterController()
    {
        this.printers = new ArrayList<>();
        ID = 0;
    }

    public static PrinterController getPrinterController()
    {
        if(printerController == null)
            printerController = new PrinterController();
        return printerController;
    }

    public List<Printer>getPrinters()
    {
        return this.printers;
    }

    public Printer getPrinter(int index)
    {
        return this.printers.get(index);
    }

    public void addPrinter(PrinterType type)
    {
        Printer printer = null;
        switch (type)
        {
            case BLACKWHITE:
                printer = Topic2Application.APPLICATION_CONTEXT.getBean(PrinterBW.class);
                System.out.println("--YOU ADDED A BLACK AND WHITE PRINTER--\n");
                break;
            case COLOR:
                printer = Topic2Application.APPLICATION_CONTEXT.getBean(PrinterColor.class);
                System.out.println("--YOU ADDED A COLOR PRINTER--\n");
                break;
            default:
                System.out.println("Something is wrong here");
                break;
        }

        if(Topic2Application.PRINTER_TYPE != PrinterType.NONE) {
            printer.setId(ID);
            this.printers.add(printer);
            ID++;
        }
    }

}
