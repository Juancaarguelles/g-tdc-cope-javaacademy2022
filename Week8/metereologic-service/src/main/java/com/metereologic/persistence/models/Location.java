package com.metereologic.persistence.models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class Location
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Latitud cannot be null")
    @Digits(integer = 2, fraction = 4, message = "Degrees can have 2 values, after that you can type just 4 values")
    private BigDecimal lat;

    @NotNull(message = "longitud cannot be null")
    @Digits(integer = 2, fraction = 4, message = "Degrees can have 2 values, after that you can type just 4 values")
    private BigDecimal lon;

    @NotNull(message = "Enter a city please")
    @Column(nullable = false)
    private String city;

    @NotNull(message = "Enter a state please")
    @Column(nullable = false)
    private String state;



    public Location(BigDecimal lat, BigDecimal lon, String city, String state)
    {
        this.lat = lat;
        this.lon = lon;
        this.city = city;
        this.state = state;
    }
    public Location(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public BigDecimal getLon() {
        return lon;
    }

    public void setLon(BigDecimal lon) {
        this.lon = lon;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    @Override
    public String toString()
    {
        return "ID : "+this.id+"\n"+
                "LATITUD : "+this.lat+"\n"+
                "LONGITUD : "+this.lon+"\n"+
                "CITY : "+this.city+"\n"+
                "STATE : "+this.state+"\n";
    }

}
