package com.globantbank.Excersice1.service;

import com.globantbank.Exceptions.InsufficientFundsException;
import com.globantbank.Exceptions.InvalidFundTargetException;
import com.globantbank.ModelService;
import com.globantbank.Excersice1.persistence.BankAccountRepository;
import com.globantbank.Excersice1.persistence.models.AccountType;
import com.globantbank.Excersice1.persistence.models.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccountService implements ModelService<BankAccount>
{
    public static final String NOT_ENOUGH_BALANCE = "--THIS ACCOUNT DOES NOT HAVE ENOUGH BALANCE--";
    public static final String CHECKING_ACCOUNT_BALANCE_RESTRICTION = "--THE BALANCE CANNOT BE THREE TIMES BIGGER THAN THE CURRENT DESIRED AMOUNT--";

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Override
    public List<BankAccount> listAll() {
        return this.bankAccountRepository.findAll();
    }

    @Override
    public BankAccount getById(Integer id) {
        return null;
    }

    @Override
    public void save(BankAccount bankAccount) {

    }

    @Override
    public void delete(Integer id) {

    }

    public boolean checkEnoughBalance(BankAccount bankAccount, float desiredAmount) throws Exception
    {
        if((bankAccount.getOwnerData().getBalance() + 3500) < desiredAmount)
            throw new InsufficientFundsException("--THIS ACCOUNT DOES NOT HAVE ENOUGH BALANCE--");
        return true;
    }

    public float getTotalValueOfBalanceAfterTransaction(BankAccount origin, BankAccount destination, float desiredAmount)
    {
        if(origin.getBank().getId() != destination.getBank().getId())
        {
            origin.getOwnerData().setBalance((origin.getOwnerData().getBalance()-desiredAmount-3500));
            return origin.getOwnerData().getBalance();
        }

        destination.getOwnerData().setBalance((destination.getOwnerData().getBalance() + desiredAmount));
        return origin.getOwnerData().getBalance();
    }

    public boolean checkCheckingAccountRestrictions(BankAccount destination, float desiredAmount) throws Exception
    {
        if(destination.getAccountType() == AccountType.CHECKING_ACCOUNT) {
            float restrictionBalance = desiredAmount * 3;

            if (destination.getOwnerData().getBalance() > restrictionBalance)
                throw new InvalidFundTargetException("--THE BALANCE CANNOT BE THREE TIMES BIGGER THAN THE CURRENT DESIRED AMOUNT--");
        }
        return true;
    }


    public float getTaxes(BankAccount destination, float desiredAmount)
    {
        if(desiredAmount >= 1500000)
        {
            float tax = desiredAmount * 0.03f;
            desiredAmount -= tax;
            destination.getOwnerData().setBalance((destination.getOwnerData().getBalance()+desiredAmount));
        }
        return desiredAmount;
    }
}
