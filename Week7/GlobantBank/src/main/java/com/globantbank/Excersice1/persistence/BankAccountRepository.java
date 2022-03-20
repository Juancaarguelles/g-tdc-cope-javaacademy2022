package com.globantbank.Excersice1.persistence;

import com.globantbank.Excersice1.persistence.models.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Integer>
{
    BankAccount generate();
}
