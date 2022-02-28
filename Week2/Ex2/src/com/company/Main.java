package com.company;

import com.UI.MainMenu;
import com.interfaces.IObserver;
import com.models.Client;
import com.models.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Scanner input = new Scanner(System.in);
    public static List<Product>products = new ArrayList<>();
    public static List<IObserver>clients = new ArrayList<>();

    public static IObserver activeClient;

    public static void main(String[] args)
    {
        products.add(new Product("Nike air", 180));
        products.add(new Product("Iphone 13", 2000));
        products.add(new Product("Gibson guitar", 800));
        products.add(new Product("PS5", 1000));

        clients.add(new Client("Juan Camilo"));
        clients.add(new Client("Daniela"));

        MainMenu.showMenu();
    }

}
