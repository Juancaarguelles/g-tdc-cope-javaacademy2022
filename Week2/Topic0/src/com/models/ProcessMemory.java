package com.models;

import com.enums.ProcessType;
import com.exceptions.MemoryOverFlowException;

public class ProcessMemory {
    public static int ID_ITERATOR = 0;
    private static ProcessMemory processMemory;

    private String[][] memory;
    private int availableSpaces;

    private ProcessMemory() {
        memory = new String[10][5];
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
        System.out.println(this.availableSpaces);
        ID_ITERATOR++;
        this.showMemorySpace();
    }

    public void removeProcess(int amountProcessNeeded, ProcessType type)
    {
        int rows = this.memory.length;
        int columns = this.memory[0].length;
        int counter = 0;
        boolean mustRemove = true;

        do {

            String processId = this.memory[0][0];
            System.out.println(processId);

            for (int i = 0; i < rows; i++)
            {
                for (int j = 0; j < columns; j++)
                {
                    if (this.memory[i][j].equalsIgnoreCase(processId))
                    {
                        counter = ++this.availableSpaces;
                    }
                    else
                    {
                        if(counter >= amountProcessNeeded)
                        {
                            mustRemove = false;
                            break;
                        }
                        else
                        {
                            processId = this.memory[i][j];
                            ++counter;
                        }
                    }
                }
                if(!mustRemove)
                    break;
            }

            System.out.println("Counteeer : "+counter);

            System.out.println("Jump");

            /*
            for (int x = counter % rows; x < rows; x++)
            {
                for (int y = counter; y < columns; y++)
                {
                    this.memory[x - (counter% rows)][y - counter] = this.memory[x][y];
                }
            }

             */
        }while (counter >= amountProcessNeeded);

        this.addProcess(amountProcessNeeded, type);
    }

}
