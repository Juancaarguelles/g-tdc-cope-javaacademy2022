package com.models;

import com.exceptions.MemoryOverFlowException;

public class ProcessMemory {
    private static ProcessMemory processMemory;

    private String[][] memory;
    private int availableSpaces;

    private ProcessMemory() {
        memory = new String[20][10];
        this.availableSpaces = 0;
    }

    public static ProcessMemory getProcessMemory() {
        if (processMemory == null)
            processMemory = new ProcessMemory();

        return processMemory;
    }

    public void showMemorySpace() {
        int rows = this.memory.length;
        int columns = this.memory[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (this.memory[i][j] == null)
                    System.out.print("**** ");
                else
                    System.out.print(this.memory[i][j]);
            }
            System.out.println("");
        }
    }

    public boolean canAddProcess(int processAmount) throws MemoryOverFlowException
    {
        if(processAmount <= this.availableSpaces)
        {
            addProcess(processAmount, true);
            return true;
        }
        else
            throw new MemoryOverFlowException("There is no memory");
    }

    public int getAvailableSpacesProcess()
    {
        int rows = this.memory.length;
        int columns = this.memory[0].length;

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
            {
                if(this.memory[i][j] == null)
                    this.availableSpaces++;
            }
        }
        return this.availableSpaces;
    }

    public void setAvailableSpaces(int availableSpaces)
    {
        this.availableSpaces = availableSpaces;
    }

    public int getAvailableSpaces()
    {
        return this.availableSpaces;
    }

    public void addProcess( int amount, boolean flag)
    {
        int rows = this.memory.length;
        int columns = this.memory[0].length;

        int counter = 0;

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
            {
                if(this.memory[i][j] == null && counter < amount)
                {
                    if(flag)
                        this.memory[i][j] = "1111 ";
                    else
                        this.memory[i][j] = "0000 ";
                    counter++;

                    if(counter >= amount)
                        break;
                }
            }
        }
        this.showMemorySpace();
    }

}
