package com.view;

import com.enums.ProcessType;
import com.exceptions.InputValidWordException;
import com.exceptions.MemoryOverFlowException;
import com.exceptions.MemoryProcessException;
import com.models.InputValidator;
import com.models.ProcessMemory;

import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final int SYSTEM_PROCESS_MIN_BOUND = 5;
    private static final int SYSTEM_PROCESS_MAX_BOUND = 15;

    private static final int APPLICATION_PROCESS_MIN_BOUND = 10;
    private  static final int APPLICACTION_PROCESS_MAX_BOUND = 20;

    public static void main(String[] args)
    {
        Random r = new Random();
        Scanner input = new Scanner(System.in);
        String option = "";

        ProcessMemory pm = ProcessMemory.getProcessMemory();
        InputValidator inputValidator = InputValidator.getInputValidator();
        //pm.setAvailableSpaces(10);
        System.out.println(pm.getAvailableSpaces());

        do {
            System.out.println("TYPE AN OPTION\n" +
                    "*. Type 'cs' in order to add a system process\n" +
                    "*. Type 'ca' in order to add an application process\n" +
                    "*. Type 'd + (ID process)' to delete an specific process\n"+
                    "*. Type 'exit' in order to finish this program");

            option = input.next();

            try
            {
                inputValidator.testInput(option);
            }
            catch (InputValidWordException e)
            {
                System.out.println(e.getMessage());
                continue;
            }

            ProcessType type = null;
            int amountProcess = 0;

            if(!option.equalsIgnoreCase(InputValidator.END_EXECUTION))
            {
                if(!option.equalsIgnoreCase(InputValidator.DELETE_PROCESS) && !option.contains(InputValidator.DELETE_PROCESS))
                {
                if(option.equalsIgnoreCase(InputValidator.SYSTEM_PROCESS_INPUT))
                {
                    System.out.println("Adding system process");
                    type = ProcessType.SYSTEM;
                    amountProcess = r.nextInt((SYSTEM_PROCESS_MAX_BOUND + 1) - SYSTEM_PROCESS_MIN_BOUND) + SYSTEM_PROCESS_MIN_BOUND;
                }
                if(option.equalsIgnoreCase(InputValidator.APPLICATION_PROCESS_INPUT)) {

                    System.out.println("Adding applicaction process");
                    type = ProcessType.APPLICATION;
                    amountProcess = r.nextInt((APPLICACTION_PROCESS_MAX_BOUND + 1) - APPLICATION_PROCESS_MIN_BOUND) + APPLICATION_PROCESS_MIN_BOUND;

                }
                try
                {
                    System.out.println("Amount required for the new system process : "+amountProcess);
                    pm.canAddProcess(amountProcess, type);
                }
                catch (MemoryProcessException e) {
                    System.out.println(e.getMessage());
                    pm.removeProcess(amountProcess, type);
                }
                }
                else
                {
                    int id = 0;
                    try {
                        if(option.length()>1) {
                            String number = "";
                            if(option.length()==2)
                            number = option.substring(1);
                            if(option.length() == 3)
                            number = option.substring(1,3);
                            System.out.println(number);

                            try
                            {
                                id = Integer.parseInt(number);
                            }catch (Exception e)
                            {
                                System.out.println("Not a number");
                                continue;
                            }

                        }
                        pm.specificIDProcessExists(id);
                    } catch (MemoryProcessException e)
                    {
                        System.out.println(e.getMessage());
                    }
                }
            }

        }while(!option.equalsIgnoreCase(InputValidator.END_EXECUTION));

        System.out.println("Thank you");

    }
}
