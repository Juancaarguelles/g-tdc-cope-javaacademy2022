package com.metereologic.persistence.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    private Location location;

    public MetereologicalData(LocalDate registryDate)
    {
        this.registryDate = registryDate;
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

    public Location getLocation()
    {
        return this.location;
    }

    public void setLocation(Location location)
    {
        this.location = location;
    }

    @Override
    public String toString()
    {
        return "ID : "+this.id+"\n"+
                "REGISTRY DATE : "+this.registryDate+"\n"+
                "LOCATION : "+this.location;
    }
}
