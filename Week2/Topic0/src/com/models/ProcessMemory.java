package com.models;

import com.enums.ProcessType;
import com.exceptions.MemoryIDProcessException;
import com.exceptions.MemoryOverFlowException;
import com.exceptions.MemoryProcessException;

import java.lang.reflect.Type;

public class ProcessMemory {
    public static int ID_ITERATOR = 0;
    public static int ID_GARBAGE_COLLECTOR = 0;
    private static ProcessMemory processMemory;
    private static String EMPTY_SIGN = "**** ";

    private String[][] memory;
    private int availableSpaces;

    private ProcessMemory() {
        memory = new String[20][10];
        this.availableSpaces = this.memory.length * this.memory[0].length;
        initializeMemory();
    }

    public static ProcessMemory getProcessMemory() {
        if (processMemory == null)
            processMemory = new ProcessMemory();

        return processMemory;
    }

    private void initializeMemory()
    {
        int rows = this.memory.length;
        int columns = this.memory[0].length;

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
            {
                if(this.memory[i][j] == null)
                    this.memory[i][j] = EMPTY_SIGN;
            }
        }
    }

    public void showMemorySpace() {
        int rows = this.memory.length;
        int columns = this.memory[0].length;

        System.out.println("----------------------------------------------------");
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j < columns; j++) {
                    System.out.print(this.memory[i][j]);
            }
            System.out.println("");
        }
        System.out.println("----------------------------------------------------");

    }

    public boolean canAddProcess(int processAmount, ProcessType type) throws MemoryProcessException
    {
        if(processAmount <= this.availableSpaces)
        {
            addProcess(processAmount, type);
            return true;
        }
        else
            throw new MemoryOverFlowException("There is no memory");
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
                if(this.memory[i][j] == EMPTY_SIGN && counter < amount)
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

    public boolean specificIDProcessExists(int processId) throws MemoryProcessException
    {
        try
        {
            int rows = this.memory.length;
            int columns = this.memory[0].length;

            boolean greatherThan9 = processId > 9;
            int tempId = 0;

            for(int i = 0; i < rows; i++)
            {
                for(int j = 0; j < columns; j++)
                {
                    if(!this.memory[i][j].equalsIgnoreCase(EMPTY_SIGN))
                    {
                        if (greatherThan9) {
                            tempId = Integer.parseInt(this.memory[i][j].substring(2, 4));
                        } else {
                            tempId = Integer.parseInt(this.memory[i][j].substring(3, 4));
                        }

                        if(tempId == processId)
                        {
                            removeSpecifiedProcess(processId);
                            return true;
                        }
                    }
                }
            }
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
            throw new MemoryIDProcessException("The ID process is not found");
    }

    public void removeSpecifiedProcess(int id) {
        int rows = this.memory.length;
        int columns = this.memory[0].length;
        int firstPosIdX = 0, firstPosIdY = 0;
        int lastPosIdX = 0, lastPosIdY = 0;
        int tempId = 0;
        boolean catchedFirstIdPos = false, catchedLastPos = false;
        int positionsToMove = 0;

        boolean greatherThan9 = id > 9;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++)
            {
                if(!this.memory[i][j].equalsIgnoreCase(EMPTY_SIGN))
                {
                    try {
                        if (greatherThan9) {
                            tempId = Integer.parseInt(this.memory[i][j].substring(2, 4));
                        } else {
                            tempId = Integer.parseInt(this.memory[i][j].substring(3, 4));
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }


                    if (tempId == id)
                    {
                        if (!catchedFirstIdPos)
                        {
                            firstPosIdX = i;
                            firstPosIdY = j;
                            System.out.println("First POS ID : " + this.memory[firstPosIdX][firstPosIdY]);
                            catchedFirstIdPos = true;
                        }
                        this.memory[i][j] = EMPTY_SIGN;
                        this.availableSpaces++;
                        positionsToMove++;
                    }
                    else
                    {
                    if(catchedFirstIdPos && !catchedLastPos)
                    {
                        lastPosIdX = i;
                        lastPosIdY = j;
                        catchedLastPos = true;
                    }
                    }
                }
                else
                {
                    if(catchedFirstIdPos && !catchedLastPos)
                    {
                        lastPosIdX = i;
                        lastPosIdY = j;
                        catchedLastPos = true;
                    }
                }
            }
        }
        System.out.println("Hey");
        System.out.println("Poisitions to move : "+positionsToMove);
        //System.out.println("ID Process : "+memory[firstPosIdX][firstPosIdY]);
        System.out.println("First pos : ["+firstPosIdX+"]["+firstPosIdY+"]");
        System.out.println("Last pos : ["+lastPosIdX+"]["+lastPosIdY+"]");
        showMemorySpace();

        for (int i = 0; i < positionsToMove; i++)
        {
            String first = this.memory[firstPosIdX][firstPosIdY];
            int tempColumn = firstPosIdY + 1;
            int tempRow = firstPosIdX;
            int f = firstPosIdX;

            for (int x = firstPosIdX; x < rows; x++)
            {
                int y = x == f ? firstPosIdY : 0;
                //System.out.println("Hey");
                for (; y < columns; y++)
                {
                    if (tempColumn >= columns)
                    {
                        tempColumn = 0;
                        if (tempRow < rows - 1)
                            tempRow++;
                    }
                    this.memory[x][y] = this.memory[tempRow][tempColumn++];
                }
                y = 0;
            }
            this.memory[memory.length - 1][memory[0].length - 1] = first;
        }



        System.out.println("Available spaces in memory : "+availableSpaces);
        showMemorySpace();


    }


    public void removeProcess(int amountProcessNeeded, ProcessType type) {
        int rows = this.memory.length;
        int columns = this.memory[0].length;
        int amountSpacesToMove = 0;
        boolean canSkip = false;

        do {
            amountSpacesToMove = 0;
            String processId = this.memory[0][0];
            System.out.println("Process ID : " + processId);

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (this.memory[i][j].equalsIgnoreCase(processId)) {
                        this.memory[i][j] = EMPTY_SIGN;
                        this.availableSpaces++;
                        amountSpacesToMove++;
                    } else {
                        canSkip = true;
                        ID_GARBAGE_COLLECTOR++;
                        break;
                    }
                }
                if (canSkip)
                    break;
            }

            System.out.println("Amount Spaces to move : " + amountSpacesToMove);
            canSkip = false;

            System.out.println("--REMOVING--");

            for (int i = 0; i < amountSpacesToMove; i++)
            {
                String first = this.memory[0][0];
                int tempColumn = 1;
                int tempRow = 0;

                for (int x = 0; x < rows; x++)
                {
                    for (int y = 0; y < columns; y++)
                    {
                        if (tempColumn >= columns) {
                            tempColumn = 0;
                            if (tempRow < rows - 1)
                                tempRow++;
                        }
                        this.memory[x][y] = this.memory[tempRow][tempColumn++];
                    }
                }
                this.memory[memory.length - 1][memory[0].length - 1] = first;
            }

                showMemorySpace();

                if (availableSpaces < amountProcessNeeded)
                    System.out.println("Deleting more space because it is still not enough");

            }
            while (availableSpaces < amountProcessNeeded) ;
            addProcess(amountProcessNeeded, type);
            System.out.println("Remaining memory : "+this.availableSpaces);
    }
}
