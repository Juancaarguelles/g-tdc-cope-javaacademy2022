package com.globantbank.persistence.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Bank
{
    public static final Integer DEFAULT_ID = 5;
    public static final String DEFAULT_NAME  = "Globant Bank";

    private Integer id;
    private String name;
}
