package com.company;

public class Ex2 {


    public int[]wall = {3 ,4, 2, 4, 2};

    public static void main(String[] args)
    {
	    Ex2 ex2 = new Ex2();
        System.out.println("Max wall : "+ ex2.getMaxWallSize());
        System.out.println("Amount of blocks to get equity in blocks : "+ex2.getamountOfBlocksToMove());
    }

    public int getMaxWallSize()
    {
        if(this.wall.length >= 1) {
            int max = this.wall[0];

            for (int i = 1; i < this.wall.length; i++) {
                if (this.wall[i] > max)
                    max = this.wall[i];
            }
            return max;
        }
        return 0;
    }

    public int getamountOfBlocksToMove()
    {
        int amount = 0;

        for(int i  = 0; i < this.wall.length; i++)
        {
            if(this.wall[i]< this.getMaxWallSize())
                amount += this.getMaxWallSize() - this.wall[i];
        }
        return amount;
    }
}
