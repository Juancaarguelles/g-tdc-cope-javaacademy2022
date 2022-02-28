package com.company.controllers;

import com.company.models.Account;

public class AccountController extends AbstractController
{
    private static AccountController accountController;

    private AccountController()
    {
        super();
    }

    @Override
    public boolean create(Object... args)
    {
        try
        {
            this.getObjects().add(new Account((Integer)args[Account.ID], (String)args[Account.NAME]));
            return true;
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public void readList()
    {
        if(this.getObjects().size()>0)
        {
            this.getObjects().forEach(o->
            {
                Account account = ((Account) o);
                System.out.println(account);
            });
        }
        else
            System.out.println("--THERE ARE NO ACCOUNTS YET--");
    }

    @Override
    public boolean update(int index, Object... args)
    {
        try {
            this.getObjects().set(index, new Account((Integer)args[Account.ID], (String)args[Account.NAME]));
            return true;
        }catch (Exception e)
        {
        System.out.println(e.getMessage());
        }
        return false;
    }

    public static AccountController getAccountController()
    {
        if(accountController == null)
            accountController = new AccountController();

        return accountController;
    }
}
