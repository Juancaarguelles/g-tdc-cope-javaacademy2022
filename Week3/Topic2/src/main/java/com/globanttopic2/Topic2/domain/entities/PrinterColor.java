package com.globanttopic2.Topic2.domain.entities;

import com.globanttopic2.Topic2.domain.enums.PrinterType;
import org.springframework.stereotype.Component;

@Component
public class PrinterColor extends Printer
{
    public PrinterColor() {
        super(PrinterType.COLOR);
    }

    public void setiPrinter(IPrinter iPrinter)
    {
        this.iPrinter = iPrinter;
    }
}
