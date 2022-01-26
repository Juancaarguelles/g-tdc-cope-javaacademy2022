package com.models;

import com.exceptions.InputValidWordException;

import java.util.Locale;

public class InputValidator
{
    public static final String SYSTEM_PROCESS_INPUT = "cs";
    public static final String APPLICATION_PROCESS_INPUT = "ca";
    public static final String END_EXECUTION = "exit";

    private static InputValidator inputValidator;

    private InputValidator()
    {

    }

    public static InputValidator getInputValidator()
    {
        if(inputValidator == null)
            inputValidator = new InputValidator();

        return inputValidator;
    }

    public void testInput(String input) throws InputValidWordException
    {
        if(input.contains("c".toLowerCase()) && (!input.equalsIgnoreCase(SYSTEM_PROCESS_INPUT) && (!input.equalsIgnoreCase(APPLICATION_PROCESS_INPUT))))
            throw  new InputValidWordException("You probably tried to type 'cs' or 'ca' \n Try again please");
        else if((input.contains("e".toLowerCase()) || input.contains("x".toLowerCase())) && !input.equalsIgnoreCase(END_EXECUTION))
            throw  new InputValidWordException("You probably wanted to type 'exit'\n Try again please");
        else if(!input.equalsIgnoreCase(SYSTEM_PROCESS_INPUT) &&
                !input.equalsIgnoreCase(APPLICATION_PROCESS_INPUT) &&
                !input.equalsIgnoreCase(END_EXECUTION))
            throw new InputValidWordException("Type a valid option please");


    }
}
