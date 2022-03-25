package com.thesis.persistence.dto;

public class UserDTO
{
    private int identification;
    private String userName;
    private String name;
    private String lastName;
    private String state;
    private String country;
    private boolean active;

    public UserDTO(int identification, String userName, String name, String lastName, String state, String country, boolean active) {
        this.identification = identification;
        this.userName = userName;
        this.name = name;
        this.lastName = lastName;
        this.state = state;
        this.country = country;
        this.active = active;
    }

    public UserDTO(){}

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getIdentification() {
        return identification;
    }

    public void setIdentification(int identification) {
        this.identification = identification;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    @Override
    public String toString() {

        return "IDENTIFICATION : "+identification+"\n"+
                "USERNAME : "+userName+"\n"+
                "NAME : "+name+"\n"+
                "LAST NAME : "+lastName+"\n"+
                "STATE : "+state+"\n"+
                "COUNTRY : "+country+"\n"+
                "ACTIVE : "+active;
    }
}
