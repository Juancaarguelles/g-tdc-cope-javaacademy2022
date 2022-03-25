package com.thesis.persistence.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private int identification;
    @Column(nullable = false, unique = true)
    private String userName;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String zipCode;
    @Column(nullable = false)
    private String state;
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private boolean active;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "all_users_messages", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "message_id"))
    private Set<Message> allMessages = new HashSet<>();

    public Set<Message> getReceivedMessages() {
        return receivedMessages;
    }

    public void setReceivedMessages(Set<Message> receivedMessages) {
        this.receivedMessages = receivedMessages;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "sent_users_messages", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "message_id"))
    private Set<Message> sentMessages = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "received_users_messages", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "message_id"))
    private Set<Message> receivedMessages = new HashSet<>();

    public User(int identification, String userName, String password, String name, String lastName, String address, String zipCode, String state, String country) {
        this.identification = identification;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.zipCode = zipCode;
        this.state = state;
        this.country = country;
        this.active = false;
    }

    public User(){}

    public Set<Message> getSentMessages() {
        return sentMessages;
    }

    public void setSentMessages(Set<Message> sentMessages) {
        this.sentMessages = sentMessages;
    }

    public void addToAllMessages(Message message)
    {
        this.allMessages.add(message);
    }

    public void addToSentMessages(Message message)
    {
        this.sentMessages.add(message);
    }

    public void addToReceivedMessages(Message message)
    {
        this.receivedMessages.add(message);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIdentification(int identification) {
        this.identification = identification;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIdentication(int identification)
    {
        this.identification = identification;
    }

    public int getIdentification()
    {
        return this.identification;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
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

    public Set<Message> getAllMessages() {
        return allMessages;
    }

    public void setAllMessages(Set<Message> allMessages) {
        this.allMessages = allMessages;
    }

    @Override
    public String toString() {
        return "ID : "+id+"\n"+
                "USERNAME : "+userName+"\n"+
                "NAME : "+name+"\n"+
                "LAST NAME : "+lastName+"\n"+
                "ADDRESS : "+address+"\n"+
                "ZIP CODE : "+zipCode+"\n"+
                "STATE : "+state+"\n"+
                "COUNTRY : "+country+"\n"+
                "ACTIVE : "+active+"\n"+
                "MESSAGES : "+this.allMessages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (identification != user.identification) return false;
        if (active != user.active) return false;
        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (address != null ? !address.equals(user.address) : user.address != null) return false;
        if (zipCode != null ? !zipCode.equals(user.zipCode) : user.zipCode != null) return false;
        if (state != null ? !state.equals(user.state) : user.state != null) return false;
        if (country != null ? !country.equals(user.country) : user.country != null) return false;
        return allMessages != null ? allMessages.equals(user.allMessages) : user.allMessages == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + identification;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (active ? 1 : 0);
        result = 31 * result + (allMessages != null ? allMessages.hashCode() : 0);
        return result;
    }
}
