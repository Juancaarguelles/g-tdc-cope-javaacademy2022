package com.company.UI;

public class AccountMenu
{
     private static AccountMenu accountMenu;

     private AccountMenu()
     {

     }

     public void showAccountMenu()
     {

     }

     public static AccountMenu getAccountMenu()
     {
          if(accountMenu == null)
               accountMenu = new AccountMenu();

          return new AccountMenu();
     }
}
