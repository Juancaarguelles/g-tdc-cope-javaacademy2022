package com.metereologic.persistence.models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;
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

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY,orphanRemoval = true, mappedBy = "location")
    private MetereologicalData metereologicalData;


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
