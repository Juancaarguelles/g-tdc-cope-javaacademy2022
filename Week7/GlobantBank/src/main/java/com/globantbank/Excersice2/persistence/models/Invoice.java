package com.globantbank.Excersice2.persistence.models;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder

public class Invoice
{
    private String id;
    private Integer companyId;
    private float amount;
    private LocalDate expirationDate;
}
