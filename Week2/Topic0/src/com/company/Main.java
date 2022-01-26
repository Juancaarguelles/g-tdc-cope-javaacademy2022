package com.company;

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

        String[][]memorySpaces = new String[20][10];

        showMemorySpace(memorySpaces);

        int amountProcess = r.nextInt((APPLICACTION_PROCESS_MAX_BOUND + 1) - APPLICATION_PROCESS_MIN_BOUND) + APPLICATION_PROCESS_MIN_BOUND;
        System.out.println("Amount : "+amountProcess);
        showMemorySpace(addProcess(memorySpaces, amountProcess, false));

        amountProcess = r.nextInt((APPLICACTION_PROCESS_MAX_BOUND + 1) - APPLICATION_PROCESS_MIN_BOUND) + APPLICATION_PROCESS_MIN_BOUND;
        System.out.println("Amount : "+amountProcess);
        showMemorySpace(addProcess(memorySpaces, amountProcess, true));

        amountProcess = r.nextInt((APPLICACTION_PROCESS_MAX_BOUND + 1) - APPLICATION_PROCESS_MIN_BOUND) + APPLICATION_PROCESS_MIN_BOUND;
        System.out.println("Amount : "+amountProcess);
        showMemorySpace(addProcess(memorySpaces, amountProcess, false));

    }

    public static void showMemorySpace(String[][]matrix)
    {
        int rows = matrix.length;
        int columns = matrix[0].length;

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
            {
                if(matrix[i][j] == null)
                System.out.print("**** ");
                else
                    System.out.print(matrix[i][j]);
            }
            System.out.println("");
        }
    }

    public static String[][] addProcess(String[][]matrix, int amount, boolean flag)
    {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int counter = 0;

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
            {
                if(matrix[i][j] == null && counter < amount)
                {
                    if(flag)
                    matrix[i][j] = "1111 ";
                    else
                        matrix[i][j] = "0000 ";
                    counter++;

                    if(counter >= amount)
                        break;
                }
            }
        }
        return  matrix;
    }
}
