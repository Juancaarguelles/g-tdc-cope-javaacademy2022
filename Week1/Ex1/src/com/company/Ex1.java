package com.company;

public class Ex1 {

    private int[] wall = {3, 4, 2, 4, 2};

    public static void main(String[] args)
    {
	    //Calcular la cantidad de bloques
        //Promediar
        //Calculo

        Ex1 ex1 = new Ex1();

        System.out.println("Blocks amount : "+ex1.getBlocksAmount());
        System.out.println("Blocks average : "+ex1.getBlocksAverage());
        System.out.println("Amount of blocks to move : "+ex1.getAmountOfBlockToMove());
    }

    public int getBlocksAverage()
    {
        return this.getBlocksAmount() / this.wall.length;
    }


    public int getAmountOfBlockToMove()
    {
        int av = this.getBlocksAverage();
        int blocksToMove = 0;

        for(int i = 0; i < this.wall.length; i++)
        {
            if(wall[i] > av)
            {
                blocksToMove = blocksToMove + (wall[i] - av);
            }
        }
        return  blocksToMove;
    }



    public int getBlocksAmount()
    {
        int blocksAmount = 0;

        for(int i = 0; i < this.wall.length; i++)
            blocksAmount += this.wall[i];

        return blocksAmount;
    }
}
