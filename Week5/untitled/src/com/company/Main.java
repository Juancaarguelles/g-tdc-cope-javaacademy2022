package com.company;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
	    boolean passed = false;
        String number = "";
        double temp = 0;

        do {
            System.out.print("::TYPE A NUMBER WITH 4 DECIMALS : ");
            number = input.next();

            passed = number.indexOf(".")>0 && number.indexOf(".")== number.length() - 5;

            if(passed)
                temp = Double.parseDouble(number);
            System.out.println(passed+" "+temp);
            temp = 0;
        }while (!passed || (temp < -20 || temp > 20));
    }
}
