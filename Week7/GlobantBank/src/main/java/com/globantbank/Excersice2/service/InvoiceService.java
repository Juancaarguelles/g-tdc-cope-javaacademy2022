package com.globantbank.Excersice2.service;

import com.globantbank.Exceptions.InsufficientFundsException;
import com.globantbank.Exceptions.InvalidBillIdException;
import com.globantbank.Excersice1.persistence.BankAccountRepository;
import com.globantbank.Excersice1.persistence.models.AccountType;
import com.globantbank.Excersice1.persistence.models.BankAccount;
import com.globantbank.Excersice2.persistence.InvoiceRepository;
import com.globantbank.Excersice2.persistence.models.Invoice;
import com.globantbank.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class InvoiceService implements ModelService<Invoice>
{

    public static final String NOT_ENOUGH_FUNDS = "--NOT ENOUGH FUNDS HERE--";
    public static  final String INVALID_ID = "--THE ID IS NOT VALID--";

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired BankAccountRepository bankAccountRepository;

    @Override
    public List<Invoice> listAll() {
        return this.invoiceRepository.findAll();
    }

    @Override
    public Invoice getById(Integer id) {
        return null;
    }

    @Override
    public void save(Invoice invoice) {

    }

    @Override
    public void delete(Integer id) {

    }

    public boolean canDoPayment(BankAccount bankAccount, Invoice invoice)
    {
        return bankAccount.getOwnerData().getBalance() > invoice.getAmount();
    }

    public float getInvoiceDiscount(BankAccount bankAccount, Invoice invoice)
    {
        if(bankAccount.getAccountType()== AccountType.CHECKING_ACCOUNT)
        {
            float discount = invoice.getAmount() * 0.1f;
            invoice.setAmount((invoice.getAmount() - discount));
            bankAccount.getOwnerData().setBalance((bankAccount.getOwnerData().getBalance() - invoice.getAmount()));
            return invoice.getAmount();
        }
        return invoice.getAmount();
    }

    public boolean validatePayment(BankAccount bankAccount, Invoice invoice) throws Exception
    {
        float balanceRequirement = invoice.getAmount() * 0.2f;
        balanceRequirement += invoice.getAmount();

        if(bankAccount.getOwnerData().getBalance() >= balanceRequirement)
            return true;
        throw new InsufficientFundsException("--NOT ENOUGH FUNDS HERE--");
    }

    public boolean checkInvoiceId(Invoice invoice) throws  Exception
    {
        String id = invoice.getId().toString();

        if(id.length() == 7)
        {
            if(id.charAt(0) == '0' && id.charAt(1) == '0')
                return true;
        }
        throw new InvalidBillIdException("--THE ID IS NOT VALID--");
    }
}
