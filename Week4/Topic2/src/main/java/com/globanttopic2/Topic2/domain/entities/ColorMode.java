package com.globanttopic2.Topic2.domain.entities;

import org.springframework.stereotype.Component;

@Component("colorMode")
public class ColorMode implements  IPrinter
{
    @Override
    public void showPrinterMode()
    {
        System.out.println("We will print something in color!");
    }
}
