package com.globanttopic2.Topic2.domain.enums;

import com.globanttopic2.Topic2.domain.entities.Printer;

public enum PrinterType
{
    BLACKWHITE("Black and White Printer"),
    COLOR("Color Printer"),
    NONE("None");

    private final String printMode;

    private PrinterType(String printMode)
    {
        this.printMode = printMode;
    }

    public String getPrintMode()
    {
        return this.printMode;
    }
}
