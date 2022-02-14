package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Main
{
    final Function<Double,Double> factorial = x ->
            x <= 1 ? 1 : x * this.factorial.apply(x - 1);

    final BiFunction<Double, Double, Double> pow = (x, exp)->
    {
        if(exp < 1)
        {
            return (double)1;
        }
        else
            return x * this.pow.apply(x,exp -1);
    };

    final BiFunction<Double, Double, Double>evaluate_e_z = (value, amount)->
    {
      if(amount <= 1)
          return amount + 1;
      else
      {
          double pow = this.pow.apply(value, amount);
          double factorial = this.factorial.apply(amount);
          return (pow / factorial) + this.evaluate_e_z.apply(value, amount - 1);

      }
    };

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args)
    {

        Main m = new Main();
        DecimalFormat df = new DecimalFormat("#.####");
        double result = m.executeOperation();
        System.out.println("RESULT : "+df.format(result));

    }

    private double executeOperation()
    {
        double value = 0, amount = 0;

        do {
            System.out.print("::TYPE A VALUE (BETWEEN 1 AND 50) : ");
            value = input.nextDouble();

            if(value < 1 || value > 50)
                System.out.println("--PLEASE TYPE A CORRECT VALUE--");
        }while(value < 1 || value > 50);

        do {
            System.out.print("::TYPE AN EXPONENT (BETWEEN -20 AND 20) : ");
            amount = input.nextDouble();

            if(amount < -20 || amount > 20)
                System.out.println("--PLEASE TYPE A CORRECT VALUE--");
        }while(amount < -20 || amount > 20);

        return this.evaluate_e_z.apply(value, amount);
    }
}
