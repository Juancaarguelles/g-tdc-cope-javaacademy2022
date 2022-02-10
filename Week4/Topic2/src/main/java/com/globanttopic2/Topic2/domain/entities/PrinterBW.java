package com.globanttopic2.Topic2.domain.entities;

import com.globanttopic2.Topic2.domain.enums.PrinterType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PrinterBW extends Printer
{
    public PrinterBW()
    {
        super(PrinterType.BLACKWHITE);
    }

    @Autowired
    @Qualifier("bwMode")
    public void setIPrinter(IPrinter iPrinter)
    {
        this.iPrinter = iPrinter;
    }
}
