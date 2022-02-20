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

        /*
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


        if(checkPassword.test(passwords, loggingAttemp))
            System.out.println("Show password in correct order");
        else
            System.out.println("--INVALID PASSWORD--");
         */

        List<String>foundedPasswords = new ArrayList<>();
        String[]passwords = {"hola", "amigos", "de", "gaby"};
        String loggingAttempt = "amigosholade";


        for(String current : passwords)
        {
            for(int i = 0;  i < loggingAttempt.length() - current.length() + 1; i++)
            {
                String sub = loggingAttempt.substring(i, current.length()+i);

                if(current.equals(sub))
                {
                    foundedPasswords.add(sub);
                    loggingAttempt = loggingAttempt.replace(sub, "");
                    System.out.println(loggingAttempt);
                }
            }
        }
        if(!loggingAttempt.equals(""))
            System.out.println("There is trash in the password");
        else
            System.out.println("Password is clean");
        //foundedPasswords.forEach(System.out::println);

    }


    /*
    public static BiPredicate<String[], String> checkPassword = (passwords, loggingAttempt)->
    {
        for (String current : passwords)
        {
            int last = current.length();

            for(int i = 0, bound = loggingAttempt.length(); i < bound; i++)
            {
                if(current.equalsIgnoreCase(loggingAttempt.substring(i, last + i)))

            }
        }
        return true;
    };
     */

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