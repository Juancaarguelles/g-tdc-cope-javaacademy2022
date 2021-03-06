package com.globantbank.Excersice1.persistence.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class BankAccount
{
    private Integer id;
    private AccountType accountType;
    private OwnerData ownerData;
    private Bank bank;
}
