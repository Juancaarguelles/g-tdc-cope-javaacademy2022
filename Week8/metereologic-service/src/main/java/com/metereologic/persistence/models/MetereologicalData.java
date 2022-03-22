package com.metereologic.persistence.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
public class MetereologicalData
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @Column(nullable = false)
    @NotNull(message = "Registry Date cannot be emty")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate registryDate;

    @NotNull(message = "Temperature cannot be null")
    @Digits(integer = 3, fraction = 1, message = "Just one decimal allowed")
    private BigDecimal temperature;

    @OneToOne(cascade = CascadeType.MERGE, orphanRemoval = true)
    @JoinColumn(name = "location_id")
    private Location location;
    private Integer locId;

    public MetereologicalData(LocalDate registryDate, BigDecimal temperature)
    {
        this.registryDate = registryDate;
        this.temperature = temperature;
    }

    public MetereologicalData(){}


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getRegistryDate() {
        return registryDate;
    }

    public void setRegistryDate(LocalDate registryDate) {
        this.registryDate = registryDate;
    }

    public BigDecimal getTemperature()
    {
        return this.temperature;
    }

    public void setTemperature(BigDecimal temperature)
    {
        this.temperature = temperature;
    }

    public Location getLocation()
    {
        return this.location;
    }

    public void setLocation(Location location)
    {
        this.location = location;
    }

    public Integer getLocId()
    {
        return this.locId;
    }

    public void setLocId(Integer locId)
    {
        this.locId = locId;
    }

    @Override
    public String toString()
    {
        return "ID : "+this.id+"\n"+
                "REGISTRY DATE : "+this.registryDate+"\n"+
                "TEMPERATURE : "+this.temperature+"\n"+
                "LOCATION : "+this.location;
    }
}
