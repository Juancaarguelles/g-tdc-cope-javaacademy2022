package com.thesis.persistence.dto;

import com.thesis.persistence.model.Message;

import java.util.Set;

public class UserDTO
{
    private int identification;
    private String userName;
    private String name;
    private String lastName;
    private String state;
    private String country;
    private boolean active;

    private Set<Message> allMessages;
    private Set<Message>sentMessages;
    private Set<Message>receivedMessages;

    public UserDTO(int identification, String userName, String name, String lastName, String state, String country, boolean active
    ,Set<Message>allMessages,Set<Message>sentMessages, Set<Message>receivedMessages) {
        this.identification = identification;
        this.userName = userName;
        this.name = name;
        this.lastName = lastName;
        this.state = state;
        this.country = country;
        this.active = active;
        this.allMessages = allMessages;
        this.sentMessages = sentMessages;
        this.receivedMessages = receivedMessages;
    }

    public UserDTO(){}

    public Set<Message> getAllMessages() {
        return allMessages;
    }

    public void setAllMessages(Set<Message> allMessages) {
        this.allMessages = allMessages;
    }

    public Set<Message> getSentMessages() {
        return sentMessages;
    }

    public void setSentMessages(Set<Message> sentMessages) {
        this.sentMessages = sentMessages;
    }

    public Set<Message> getReceivedMessages() {
        return receivedMessages;
    }

    public void setReceivedMessages(Set<Message> receivedMessages) {
        this.receivedMessages = receivedMessages;
    }

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
                "ACTIVE : "+active+"\n"+
                "ALL MESSAGES : "+allMessages+"\n"+
                "RECEIVED MESSAGES : "+receivedMessages+"\n"+
                "SENT MESSAGES : "+sentMessages;
    }
}
