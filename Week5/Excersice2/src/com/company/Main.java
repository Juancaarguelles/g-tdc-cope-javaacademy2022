package com.company;

import com.company.enums.ModeValue;
import com.company.exceptions.PasswordException;
import com.company.interfaces.IPasswordChecker;

import java.util.*;
import java.util.function.*;

public class Main {

    public static final int MIN_BOUND = 1;
    public static final int MAX_BOUND = 10;
    private static  Scanner input = new Scanner(System.in);


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[]passwords;


        int testCasesAmount = getAmount(ModeValue.TEST_CASES_AMOUNT);
        int counter = 0;

        do {

            int usersAmount = getAmount(ModeValue.USER_AMOUNT);

            passwords = getPassword(usersAmount);

            System.out.print("::TYPE THE LOGGING ATTEMPT : ");
            String loggingAttemp = input.next();
            input.nextLine();

            try {
                firstPasswordChecker.apply(passwords, loggingAttemp);
            } catch (PasswordException e) {
                System.out.println(e.getMessage());
            }

            System.out.println(checkPassword.apply(passwords, loggingAttemp));
            counter++;
        }while (counter < testCasesAmount);
    }


    public static String[]getPassword(int usersAmount)
    {
        String[]passwords;
        do {
            System.out.print("::TYPE THE PASSWORDS : ");
            passwords = input.nextLine().toLowerCase().split("\\s+");

            if(passwords.length != usersAmount)
                System.out.println("--THE USERS PASSWORD AMOUNT IS DIFFERENT TO THE SPECIFIED VALUE--");
        }
        while (passwords.length != usersAmount);
        return  passwords;
    }



    public static BiFunction<String[], String, String> checkPassword = (passwords, loggingAttempt)->
    {
        String finalPassword = "";

        for(String current : passwords)
        {
            for(int i = 0;  i < loggingAttempt.length() - current.length() + 1; i++)
            {
                String sub = loggingAttempt.substring(i, current.length()+i);

                if(current.equals(sub))
                {
                    finalPassword += sub+" ";
                    loggingAttempt = loggingAttempt.replace(sub, "");
                }
            }
        }
        if(!loggingAttempt.equals(""))
            return "--INVALID PASSWORD--";
        else
            return finalPassword;
    };


    public static IPasswordChecker<String[], String, Boolean> firstPasswordChecker = (passwords, loggingAttempt)->
    {
        if(loggingAttempt.length()<=2000)
        {
            for(int i = 0; i < passwords.length; i++)
            {
                for(int j = i + 1; j < passwords.length; j++)
                {
                    if(passwords[i].equalsIgnoreCase(passwords[j]))
                        throw new PasswordException("--"+passwords[j]+" IS DUPLICATED--");
                    if(passwords[j].length()> 10)
                        throw new PasswordException("--"+passwords[j]+" IS BIGGER THAN 10--");
                }
            }
            return true;
        }
        else
            throw  new PasswordException("--ATTEMPT LOGGING IS BIGGER THAN 2000 CHARACTERS--");

    };

    public static int getAmount(ModeValue mode)
    {
        int amount = 0;
        boolean validFormat = false;
        do {
            try {
                String title = mode == ModeValue.TEST_CASES_AMOUNT ? "TEST CASES" : "USER PASSWORDS";
                System.out.print("::TYPE THE AMOUNT OF "+ title+" : ");
                amount = input.nextInt();
                input.nextLine();
                validFormat = true;
            } catch (Exception e) {
                System.out.println("--TYPE A VALID INTEGER FORMAT--");
                amount = -1;
                input.nextLine();
            }
        }while (!validFormat);
        return amount;
    }
}