package com.globanttopic2.Topic2.domain.entities;

import com.globanttopic2.Topic2.domain.enums.PrinterType;

public class Printer
{
    protected IPrinter iPrinter;
    private int id;
    private PrinterType printerType;

    public Printer(PrinterType printerType)
    {
        this.printerType = printerType;
    }

    public IPrinter getIPrinter()
    {
        return this.iPrinter;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return this.id;
    }


    public void showPrinterMessage()
    {
        this.iPrinter.showPrinterMode();
    }

    public String getPrinterType()
    {
        return this.printerType.getPrintMode();
    }

    @Override
    public String toString()
    {
        return "\nID : "+this.id+"\n" +
                "PRINTER MODEL : "+this.printerType.getPrintMode()+"\n";
    }
}
