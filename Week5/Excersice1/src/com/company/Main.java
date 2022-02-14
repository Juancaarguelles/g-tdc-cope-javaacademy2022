package com.company;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Main
{
    final Function<Integer,Integer> factorial = x ->
            x <= 1 ? 1 : x * this.factorial.apply(x - 1);


    final BiFunction<Double, Integer, Double>evaluate_e_z = (value, amount)->
    {
      if(amount <= 1)
          return (double)value + 1;
      else
      {
          double pow = Math.pow(value, amount);
          double factorial = this.factorial.apply(amount);
          return (pow / factorial) + this.evaluate_e_z.apply(value, amount - 1);
      }
    };

    public List<Double>numbers = new ArrayList<>();


    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args)
    {
        Main m = new Main();

        m.executeOperation();
    }

    private void executeOperation()
    {
        int amount = 0;
        double value = 0;

        do {
            System.out.print("::TYPE THE AMOUNT OF TEST CASES  (BETWEEN 1 AND 50) : ");
            amount = input.nextInt();

            if(amount < 1 || amount > 50)
                System.out.println("--PLEASE TYPE A CORRECT VALUE--");
        }while(amount < 1 || amount > 50);

        for(int i = 0; i < amount; i++)
        {
            boolean canSetValue = false, canContinue = false;
            String number = "";
            do {
                System.out.print("::TYPE A VALUE (BETWEEN -20 AND 20) : ");
                number = input.next();

                canSetValue = number.indexOf(".")>= 0 && number.indexOf(".")== number.length() - 5;

                if(canSetValue)
                {
                    value = Double.parseDouble(number);

                    if (value < -20.00 || value > 20.00)
                        System.out.println("--PLEASE TYPE A VALUE INSIDE THE RANGE--");
                    else
                        canContinue = true;
                }
                else
                    System.out.println("--PLEASE TYPE A NUMBER WITH 4 DECIMALS--");
            }while(!canContinue);

            DecimalFormat df = new DecimalFormat("#.####");
            double result = this.evaluate_e_z.apply(value, amount);
            numbers.add(truncate(result, 4));
        }

        System.out.println("\n--RESULT--");
        numbers.stream().forEach(System.out::println);
    }

    private static double truncate(double value, int decimal)
    {
        value = value * Math.pow(10, decimal);
        value = Math.floor(value);
        value = value / Math.pow(10, decimal);
        return value;
    }
}
