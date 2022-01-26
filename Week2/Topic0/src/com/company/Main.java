package com.company;

import com.exceptions.MemoryOverFlowException;
import com.models.ProcessMemory;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static int ITERATOR = 0;

    public static final String SYSTEM_PROCESS = "cs";
    private static final int SYSTEM_PROCESS_MIN_BOUND = 5;
    private static final int SYSTEM_PROCESS_MAX_BOUND = 15;

    public static final String APPLICATION_PROCESS = "ca";
    private static final int APPLICATION_PROCESS_MIN_BOUND = 10;
    private  static final int APPLICACTION_PROCESS_MAX_BOUND = 20;

    public static void main(String[] args)
    {
        Random r = new Random();
        Scanner input = new Scanner(System.in);

        ProcessMemory pm = ProcessMemory.getProcessMemory();
        pm.setAvailableSpaces(10);
        System.out.println(pm.getAvailableSpaces());

        try {
            System.out.println(pm.canAddProcess(10));
        } catch (MemoryOverFlowException e) {
            System.out.println(e.getMessage());
        }

        //showMemorySpace(memorySpaces);

        /*
        int amountProcess = r.nextInt((APPLICACTION_PROCESS_MAX_BOUND + 1) - APPLICATION_PROCESS_MIN_BOUND) + APPLICATION_PROCESS_MIN_BOUND;
        System.out.println("Amount : "+amountProcess);
        //showMemorySpace(addProcess(memorySpaces, amountProcess, false));

        amountProcess = r.nextInt((APPLICACTION_PROCESS_MAX_BOUND + 1) - APPLICATION_PROCESS_MIN_BOUND) + APPLICATION_PROCESS_MIN_BOUND;
        System.out.println("Amount : "+amountProcess);
        //showMemorySpace(addProcess(memorySpaces, amountProcess, true));

        amountProcess = r.nextInt((APPLICACTION_PROCESS_MAX_BOUND + 1) - APPLICATION_PROCESS_MIN_BOUND) + APPLICATION_PROCESS_MIN_BOUND;
        System.out.println("Amount : "+amountProcess);
        //showMemorySpace(addProcess(memorySpaces, amountProcess, false));
         */

    }



}
