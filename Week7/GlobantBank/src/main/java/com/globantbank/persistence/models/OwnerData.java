package com.globantbank.persistence.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OwnerData
{
    private Integer id;
    private String name;
    private  String lastName;
    private float balance;
}
