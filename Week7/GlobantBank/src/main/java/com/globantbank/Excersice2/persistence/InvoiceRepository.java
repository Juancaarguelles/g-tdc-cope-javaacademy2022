package com.globantbank.Excersice2.persistence;

import com.globantbank.Excersice2.persistence.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, String>
{

}
