package com.company;

import java.util.Scanner;

public class Main {

    public static int ITERATOR = 0;

    public static final String SYSTEM_PROCESS = "cs";
    public static final String APPLICATION_PROCESS = "ca";

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        String[][]memorySpaces = new String[20][10];

        showMemorySpace(memorySpaces);
        
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
            }
            System.out.println("");
        }

    }
}
