package com.models;

import com.enums.ProcessType;
import com.exceptions.MemoryOverFlowException;

import java.lang.reflect.Type;

public class ProcessMemory {
    public static int ID_ITERATOR = 0;
    public static int ID_GARBAGE_COLLECTOR = 0;
    private static ProcessMemory processMemory;

    private String[][] memory;
    private int availableSpaces;

    private ProcessMemory() {
        memory = new String[7][5];
        this.availableSpaces = this.memory.length * this.memory[0].length;
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

    public boolean canAddProcess(int processAmount, ProcessType type) throws MemoryOverFlowException
    {
        if(processAmount <= this.availableSpaces)
        {
            addProcess(processAmount, type);
            return true;
        }
        else
            throw new MemoryOverFlowException("There is no memory");
    }

    public int getAvailableSpacesProcess()
    {
        int rows = this.memory.length;
        int columns = this.memory[0].length;
        this.availableSpaces = 0;

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

    public void addProcess( int amount, ProcessType type)
    {
        int rows = this.memory.length;
        int columns = this.memory[0].length;

        int counter = 0;

        String units = ID_ITERATOR < 10 ? "00" : "0";

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
            {
                if(this.memory[i][j] == null && counter < amount)
                {
                    if(type == ProcessType.SYSTEM)
                        this.memory[i][j] = "s"+units+ + ID_ITERATOR + " ";
                    else
                        this.memory[i][j] = "a"+units + ID_ITERATOR + " ";

                    counter++;
                    this.availableSpaces--;

                    if(counter >= amount)
                        break;
                }
            }
        }
        System.out.println("Remaining memory : "+this.availableSpaces);
        ID_ITERATOR++;
        this.showMemorySpace();
    }

    public void removeProcess(int amountProcessNeeded, ProcessType type)
    {
        int rows = this.memory.length;
        int columns = this.memory[0].length;
        int amountSpacesToMove = 0;
        boolean canSkip = false;
        String units = ID_GARBAGE_COLLECTOR < 10 ? "00" : "0";
        String prefix = type == ProcessType.SYSTEM ? "s" : "a";


        do
        {
            amountSpacesToMove = 0;
            String processId = this.memory[0][0];
            System.out.println("Process ID : "+processId);

            for (int i = 0; i < rows; i++)
            {
                for (int j = 0; j < columns; j++)
                {
                    if (this.memory[i][j].equalsIgnoreCase(processId))
                    {
                        this.memory[i][j] = null;
                         this.availableSpaces = ++amountSpacesToMove;
                    }
                    else {
                        canSkip = true;
                        break;
                    }
                }
                if (canSkip)
                    break;
            }
            canSkip = false;
            System.out.println("--REMOVING--");
            showMemorySpace();

            int row = amountSpacesToMove / columns;
            int column = amountSpacesToMove % columns;
            processId = this.memory[row][column];
            System.out.println("Spaces to move : "+amountSpacesToMove);
            System.out.println("Row : "+row+" Column : "+column);
            processId = this.memory[row][column];
            System.out.println("process id : "+processId);
            int filledSpacesAmount = (rows * columns) - getAvailableSpacesProcess();
            System.out.println("Spaces used by memory : "+filledSpacesAmount);

            int rowBound = (filledSpacesAmount % rows == 0) ? filledSpacesAmount / rows : (filledSpacesAmount / rows) + 1;
            int columnBound = filledSpacesAmount % rows;

            for(int i = 0; i < rowBound; i++)
            {
                for(int j = 0, bound = (i == rowBound - 1) ? columnBound : columns; j < bound; j++)
                {
                    if(column >= bound)
                    {
                        column = 0;
                        row = 0;
                    }
                    this.memory[i][j] = this.memory[row][column++];
                }
            }


            /*
            for(int i = amountSpacesToMove / columns; i < (amountSpacesToMove / columns) + rows; i++)
            {
                for(int j = amountSpacesToMove % columns; j < columns + (amountSpacesToMove % columns); j++)
                {
                    if(this.memory[i - (amountSpacesToMove/columns)][j - (amountSpacesToMove%columns)] == null )
                    this.memory[i - (amountSpacesToMove/columns)][j - (amountSpacesToMove%columns)] = this.memory[i][j];
                    else
                    {
                        canSkip = true;
                        break;
                    }
                }
                if(canSkip)
                    break;
            }
             */

            /*
            int row = amountSpacesToMove / rows;
            int column = amountSpacesToMove % columns;

            for(int i = 0; i < rows; i++)
            {
                for(int j = 0; j < columns; j++)
                {
                    if(column >= columns)
                     row = column = 0;

                    this.memory[i][j] = this.memory[row][column++];
                }
                row = 0;
                column = 0;
            }
            */
            //showMemorySpace();



        }while(availableSpaces < amountProcessNeeded);
        showMemorySpace();
        System.out.println("End do while");
    }

}
