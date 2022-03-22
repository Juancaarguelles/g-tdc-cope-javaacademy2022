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
import java.util.function.BiFunction;


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

    @NotNull(message = "Latitud cannot be null")
    @Digits(integer = 2, fraction = 4, message = "Degrees can have 2 values, after that you can type just 4 values")
    private BigDecimal lat;

    @NotNull(message = "longitud cannot be null")
    @Digits(integer = 2, fraction = 4, message = "Degrees can have 2 values, after that you can type just 4 values")
    private BigDecimal lon;

    @NotNull(message = "City cannot be null")
    @NotEmpty(message = "City cannot be empty")
    @NotBlank(message = "Are you serious?")
    @Column(nullable = false)
    private String city;

    @NotNull( message = "State cannot be null")
    @NotEmpty(message = "State cannot be empty")
    @NotBlank(message = "Are you serious?")
    @Column(nullable = false)
    private String state;


    public MetereologicalData(LocalDate registryDate, BigDecimal temperature, BigDecimal lat, BigDecimal lon,
                              String city, String state)
    {
        this.registryDate = registryDate;
        this.temperature = temperature;
        this.lat = lat;
        this.lon = lon;
        this.city = city;
        this.state = state;
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

    public BigDecimal getLat()
    {
        return this.lat;
    }

    public void setLat(BigDecimal lat)
    {
        this.lat = lat;
    }

    public BigDecimal getLon()
    {
        return this.lon;
    }

    public void setLon(BigDecimal lon)
    {
        this.lon = lon;
    }

    public String getState()
    {
        return this.state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getCity()
    {
        return this.city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    @Override
    public String toString()
    {
        return "ID : "+this.id+"\n"+
                "REGISTRY DATE : "+this.registryDate+"\n"+
                "TEMPERATURE : "+this.temperature+"\n"+
                "LATIUDE : "+this.lat+"\n"+
                "LONGITUDE : "+this.lon+"\n"+
                "CITY : "+this.city+"\n"+
                "STATE : "+this.state;
    }
}
