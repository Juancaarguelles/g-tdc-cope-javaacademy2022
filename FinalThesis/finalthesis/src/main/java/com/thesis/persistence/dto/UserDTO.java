package com.thesis.persistence.dto;

public class UserDTO
{
    private Integer id;
    private String userName;
    private String name;
    private String lastName;
    private String state;
    private String country;

    public UserDTO(Integer id, String userName, String name, String lastName, String state, String city) {
        this.id = id;
        this.userName = userName;
        this.name = name;
        this.lastName = lastName;
        this.state = state;
        this.country = city;
    }

    public UserDTO(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

        return "UserDTO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", state='" + state + '\'' +
                ", city='" + country + '\'' +
                '}';
    }
}
