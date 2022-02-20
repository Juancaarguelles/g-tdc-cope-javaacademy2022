package com.company;

import com.company.exceptions.PasswordException;
import jdk.swing.interop.SwingInterOpUtils;
import org.w3c.dom.ls.LSOutput;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static final int MIN_BOUND = 1;
    public static final int MAX_BOUND = 10;


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] passwords = input.nextLine().toLowerCase().split("\\s+");
        System.out.println(Arrays.toString(passwords));


        System.out.print("Type the logging attempt : ");
        String loggingAttemp = input.next();

        try
        {
            System.out.println(firstPasswordChecker.apply(passwords, loggingAttemp));
        }catch (PasswordException e)
        {
            System.out.println(e.getMessage());
        }

        for(String currentPassword : passwords)
            System.out.println(currentPassword+" -> "+checkPassword.test(currentPassword, loggingAttemp));

    }

    public static BiPredicate<String, String> checkPassword = (password, loggingAttempt)->
            loggingAttempt.contains(password);

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
}