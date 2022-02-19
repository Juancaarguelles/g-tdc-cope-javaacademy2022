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

        /*
        String logginAttempt = "youtubeholagentahh";
        String word = "hola";
        if(logginAttempt.contains(word))
        {
            int firstIndex = logginAttempt.indexOf(word.charAt(0));
            int secondIndex =logginAttempt.indexOf(word.charAt(word.length()-1));
            System.out.println(logginAttempt.substring(firstIndex, secondIndex + 1));
        }

         */

        System.out.print("Type the logging attempt : ");
        String loggingAttemp = input.next();

        System.out.println(loggingAttemp);

        for(String current : passwords)
        {
            System.out.println(current+ " -> "+checkPasswords.test(current, loggingAttemp));
        }
    }

    public static BiPredicate<String, String> checkPasswords = (password, loggingAttempt)->
            loggingAttempt.contains(password);
}