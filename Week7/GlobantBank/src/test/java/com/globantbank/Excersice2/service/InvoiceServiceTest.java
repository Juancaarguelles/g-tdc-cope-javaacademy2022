package com.globantbank.Excersice2.service;

import com.globantbank.Exceptions.InsufficientFundsException;
import com.globantbank.Exceptions.InvalidBillIdException;
import com.globantbank.Excersice1.persistence.BankAccountRepository;
import com.globantbank.Excersice1.persistence.models.AccountType;
import com.globantbank.Excersice1.persistence.models.Bank;
import com.globantbank.Excersice1.persistence.models.BankAccount;
import com.globantbank.Excersice1.persistence.models.OwnerData;
import com.globantbank.Excersice2.persistence.InvoiceRepository;
import com.globantbank.Excersice2.persistence.models.Invoice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.beans.Transient;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceServiceTest
{
    @Mock
    private InvoiceRepository invoiceRepository;

    @Mock
    private BankAccountRepository bankAccountRepository;

    @InjectMocks
    private InvoiceService invoiceService;

    @BeforeEach
    public void setUp()
    {
        MockitoAnnotations.openMocks(this);
        Mockito.when(invoiceRepository.findAll()).thenReturn(this.getInvoices());
        Mockito.when(bankAccountRepository.generate()).thenReturn(BankAccount.builder().id(1).
                accountType(AccountType.CHECKING_ACCOUNT).ownerData(OwnerData.builder().id(1).name("Juan Camilo").lastName("Argüelles").balance(20000).build()).
                bank(Bank.builder().id(5).name("Globant Bank").build()).build());
    }

    @Test
    public void return_true_when_balance_account_is_bigger_than_invoice_amount()
    {
        BankAccount testAccount = bankAccountRepository.generate();
        Invoice invoiceTest = this.invoiceService.listAll().get(0);
        boolean result = this.invoiceService.canDoPayment(testAccount, invoiceTest);

        Assertions.assertEquals(true, result);

        Mockito.verify(invoiceRepository, Mockito.times(1)).findAll();
        Mockito.verify(bankAccountRepository, Mockito.times(1)).generate();
    }

    @Test
    public void return_invoice_disccount_when_typeAccount_is_checking_account()
    {
        BankAccount bankAccount = this.bankAccountRepository.generate();
        Invoice invoiceTest = this.invoiceService.listAll().get(1);
        float result = this.invoiceService.getInvoiceDiscount(bankAccount, invoiceTest);
        Assertions.assertEquals(18000f, result);

        Mockito.verify(invoiceRepository, Mockito.times(1)).findAll();
        Mockito.verify(bankAccountRepository, Mockito.times(1)).generate();
    }

    @Test
    public void fail_when_balance_is_less_than_20_percent_plus_invoice_balance()
    {
        BankAccount testAccount = this.bankAccountRepository.generate();
        Invoice testInvoice = this.invoiceService.listAll().get(2);

        Exception e = Assertions.assertThrows(InsufficientFundsException.class, ()-> this.invoiceService.validatePayment(testAccount, testInvoice));

        Assertions.assertEquals(InvoiceService.NOT_ENOUGH_FUNDS, e.getMessage());

        if(e != null)
            System.out.println(e.getMessage());

        Mockito.verify(invoiceRepository, Mockito.times(1)).findAll();
        Mockito.verify(bankAccountRepository, Mockito.times(1)).generate();
    }

     @Test
     public void fail_when_id_is_invalid()
     {
         Invoice invoiceTest = this.invoiceService.listAll().get(0);

         Exception ex = Assertions.assertThrows(InvalidBillIdException.class, ()-> this.invoiceService.checkInvoiceId(invoiceTest));

         Assertions.assertEquals(this.invoiceService.INVALID_ID, ex.getMessage());

         if(ex != null)
             System.out.println(ex.getMessage());

         Mockito.verify(invoiceRepository, Mockito.times(1)).findAll();
     }

    private List<Invoice>getInvoices()
    {
        Invoice invoice1 = Invoice.builder().id("1").companyId(1).amount(10000).expirationDate(LocalDate.of(2022, 8, 26)).build();
        Invoice invoice2 = Invoice.builder().id("0012345").companyId(2).amount(20000).expirationDate(LocalDate.of(2022, 4, 4)).build();
        Invoice invoice3 = Invoice.builder().id("3").companyId(3).amount(20000).expirationDate(LocalDate.of(2022, 8, 28)).build();

        return new ArrayList<>(Arrays.asList(invoice1, invoice2, invoice3));
    }



}