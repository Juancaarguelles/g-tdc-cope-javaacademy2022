package com.company;

import com.sun.tools.jconsole.JConsoleContext;

import javax.swing.*;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> names = new ArrayList<>();

        char option = 'N';
        do {
            String name = JOptionPane.showInputDialog(null, "Type a name").toLowerCase();
            names.add(name);
            do {
                option = JOptionPane.showInputDialog(null, "Do you want to add a new Name?\n" +
                        "Type 'Y' for add another name \n" +
                        "Tye 'N' for quit").charAt(0);

                if (option >= 65 && option <= 90)
                    option += (char) 32;

                if (option != 'y' && option != 'n')
                    JOptionPane.showMessageDialog(null, "Type a valid answer");

            } while (option != 'y' && option != 'n');


        } while (option != 'n');

        String filterWord = JOptionPane.showInputDialog(null, "Type the filter word that you want to find").toLowerCase();

        Stream<String> filteredNames = names.stream().filter(text -> text.contains(filterWord));
        names = getListConverted(filteredNames);

        JOptionPane.showMessageDialog(null, showNames(names));
    }

    public static <T> List<T> getListConverted(Stream<T> stream)
    {
        return stream.collect(Collectors.toList());
    }

    public static String showNames(List<String>names)
    {
        String result = "";

        for(String currentElement : names)
            result += currentElement+"\n";

        return result;
    }

    public static String getConcatenatedElements(List<String> elements)
    {
        String result = "";
        for (String current : elements)
          result += current;

        return result;
    }
}
