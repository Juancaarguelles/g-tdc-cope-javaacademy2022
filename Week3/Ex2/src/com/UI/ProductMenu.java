package com.UI;

import com.company.Main;
import com.models.Client;
import com.models.Product;

import java.util.List;

public class ProductMenu
{
    private static int option = 0;

    public static void subscribeProduct()
    {
        showAllProducts(Main.products);

        Client client = (Client)Main.activeClient;
        Product product = Main.products.get(option - 1);
        System.out.println("--SELECTED PRODUCT "+product.getName()+"--");

        if(client.setProduct(product))
        System.out.println("\n--"+client.getName()+" SUBSCRIBED SUCCESFULLY TO "+product.getName()+"--");
        else
            System.out.println("\n--"+client.getName()+" ALREADY IS SUBSCRIBED TO "+product.getName()+"--");

    }

    public static void ejectUnsubsribeAction()
    {
        int option = 0;

        do
        {
            System.out.println("1. Delete product\n" +
                    "2. Cancel");

            option = Main.input.nextInt();

            switch (option)
            {
                case 1:
                    Client client = (Client)Main.activeClient;
                    Product product = client.getProducts().get(option - 1);
                    int index = product.getClients().indexOf(client);

                    if(client.deleteProduct(product))
                        System.out.println("\n--"+client.getName()+" UNSUBSCRIBED SUCCESFULLY TO "+product.getName()+"--");
                    return;
                case 2:
                    System.out.println("\n--CANCELING ACTION--");
                    break;
                default:
                    System.out.println("\n--PLEASE TYPE A VALID OPTION--");
                    break;
            }

        }while(option != 2);

    }

    public static  void unsubscribeProduct()
    {
        Client client = (Client)Main.activeClient;

        if(client.getProducts().size() > 0)
        {
            showAllProducts(client.getProducts());
            ejectUnsubsribeAction();
        }
        else
            System.out.println("\n--"+client.getName()+" IS NOT SUBSCRIBED TO ANY PRODUCT YET--");

    }

    public static void editProduct()
    {
        showAllProducts(Main.products);

        Product product = Main.products.get(option - 1);
        float price = 0;

        try
        {
            System.out.println("--TYPE THE NEW PRICE OF "+product.getName()+" : ");
            price = Main.input.nextFloat();
            product.setPrice(price);
            product.notifySubscribers(product.getName());
        }catch (Exception e)
        {
            System.out.println("Type a numeric value");
        }
    }

    public static void showAllProducts(List<Product>productList)
    {
        do {

            int index = 0;
            System.out.println("\n--TYPE THE PRODUCT THAT YOU WANT SELECT--");

            for(Product currentProduct : productList)
                System.out.println((++index)+" "+currentProduct.getName()+" $"+currentProduct.getPrice());

            option = Main.input.nextInt();

            if(option < 1 || option > productList.size())
                System.out.println("Type a valid index please");

        }while(option < 1 || option > productList.size());

    }

}
