package com.globanttopic2.Topic2.domain.entities;

import org.springframework.stereotype.Component;

@Component("bwMode")
public class BWMode implements IPrinter
{

    @Override
    public void showPrinterMode() {
        System.out.println("We will print something in B/W");
    }
}
