package com.globantbank.excersice1.service;

import com.globantbank.Exceptions.InsufficientFundsException;
import com.globantbank.Exceptions.InvalidFundTargetException;
import com.globantbank.Excersice1.service.BankAccountService;
import com.globantbank.Excersice1.persistence.BankAccountRepository;
import com.globantbank.Excersice1.persistence.models.AccountType;
import com.globantbank.Excersice1.persistence.models.Bank;
import com.globantbank.Excersice1.persistence.models.BankAccount;
import com.globantbank.Excersice1.persistence.models.OwnerData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BankAccountServiceTest
{
    @Mock
    private BankAccountRepository bankAccountRepository;

    @InjectMocks
    private BankAccountService bankAccountService;

    @BeforeEach
    public void setUp()
    {
        MockitoAnnotations.openMocks(this);
        Mockito.when(bankAccountRepository.findAll()).thenReturn(this.getBankAccounts());
    }

    @Test
    public void fail_when_origin_account_must_have_enough_balance_for_transaction()
    {
        BankAccount testAccount = bankAccountService.listAll().get(0);

        Exception e = Assertions.assertThrows(InsufficientFundsException.class, ()-> this.bankAccountService.checkEnoughBalance(testAccount, 234500));
        Assertions.assertEquals(this.bankAccountService.NOT_ENOUGH_BALANCE, e.getMessage());
        if(e != null)
            System.out.println(e.getMessage());

        Mockito.verify(this.bankAccountRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void return_less_initial_ammount_when_banks_are_different()
    {
        BankAccount originAccount = bankAccountService.listAll().get(0);
        BankAccount destinationAccount = bankAccountService.listAll().get(3);

        float result = this.bankAccountService.getTotalValueOfBalanceAfterTransaction(originAccount, destinationAccount, 2000);

        Assertions.assertEquals(4500, result);
        Mockito.verify(this.bankAccountRepository, Mockito.times(2)).findAll();

    }

    @Test
    public void fail_when_desired_transaction_amount_is_3_times_bigger_than_destination_account_and_these_one_ischecking_account()
    {

        BankAccount destinationAccount = bankAccountService.listAll().get(2);

        Exception ex = Assertions.assertThrows(InvalidFundTargetException.class, ()-> this.bankAccountService.checkCheckingAccountRestrictions(destinationAccount, 500));
        Assertions.assertEquals(this.bankAccountService.CHECKING_ACCOUNT_BALANCE_RESTRICTION, ex.getMessage());

        if(ex != null) System.out.println(ex.getMessage());
        Mockito.verify(this.bankAccountRepository, Mockito.times(1)).findAll();

    }

    @Test
    public void return_transaction_applying_taxes()
    {
        BankAccount testAccount = this.bankAccountService.listAll().get(3);
        float tax = this.bankAccountService.getTaxes(testAccount, 1600000f);
        Assertions.assertEquals(1552000f, tax);
        Mockito.verify(this.bankAccountRepository, Mockito.times(1)).findAll();

    }



    private List<BankAccount> getBankAccounts()
    {
        Bank globantBank = Bank.builder().id(Bank.DEFAULT_ID).name(Bank.DEFAULT_NAME).build();
        Bank trashBank = Bank.builder().id(1).name("Trash bank").build();

        OwnerData juan = OwnerData.builder().id(1).name("Juan").lastName("Perez").balance(10000).build();
        OwnerData camilo = OwnerData.builder().id(2).name("Camilo").lastName("Lopez").balance(22000).build();
        OwnerData david = OwnerData.builder().id(3).name("David").lastName("Vargas").balance(5000).build();

        return new ArrayList<>(Arrays.asList(
                BankAccount.builder().id(1).accountType(AccountType.CHECKING_ACCOUNT).ownerData(juan).bank(globantBank).build(),
                BankAccount.builder().id(2).accountType(AccountType.SAVING_ACCOUNT).ownerData(camilo).bank(globantBank).build(),
                BankAccount.builder().id(3).accountType(AccountType.CHECKING_ACCOUNT).ownerData(david).bank(globantBank).build(),
                BankAccount.builder().id(4).accountType(AccountType.SAVING_ACCOUNT).ownerData(juan).bank(trashBank).build()
                ));
    }
}