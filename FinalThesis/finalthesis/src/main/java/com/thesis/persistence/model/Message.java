package com.thesis.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Message
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String origin;
    @JoinColumn(nullable = false)
    private String destination;
    private String cc;
    private String bcc;
    @Column(nullable = false)
    private String subject;
    private String body;
    private String attachment;

    @JsonIgnore
    @ManyToMany(mappedBy = "allMessages")
    private Set<User> users = new HashSet<>();

    public Message(){}

    public Message(String to, String cc, String bcc, String subject, String body, String attachment) {
        this.destination = to;
        this.cc = cc;
        this.bcc = bcc;
        this.subject = subject;
        this.body = body;
        this.attachment = attachment;
    }

    public Message(Message message) {
        this.origin = message.origin;
        this.destination = message.destination;
        this.cc = message.cc;
        this.bcc = message.bcc;
        this.subject = message.subject;
        this.body = message.body;
        this.attachment = message.attachment;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }



    @Override
    public String toString()
    {
        return "ID : "+this.id+"\n"+
                "FROM : "+this.origin +"\n"+
                "TO : "+this.destination +"\n"+
                "CC : "+this.cc+"\n"+
                "BCC : "+this.bcc+"\n"+
                "SUBJECT : "+this.subject+"\n"+
                "BODY : "+this.body+"\n"+
                "ATTACHMENT : "+this.attachment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (id != null ? !id.equals(message.id) : message.id != null) return false;
        if (origin != null ? !origin.equals(message.origin) : message.origin != null) return false;
        if (destination != null ? !destination.equals(message.destination) : message.destination != null) return false;
        if (cc != null ? !cc.equals(message.cc) : message.cc != null) return false;
        if (bcc != null ? !bcc.equals(message.bcc) : message.bcc != null) return false;
        if (subject != null ? !subject.equals(message.subject) : message.subject != null) return false;
        if (body != null ? !body.equals(message.body) : message.body != null) return false;
        return attachment != null ? attachment.equals(message.attachment) : message.attachment == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (origin != null ? origin.hashCode() : 0);
        result = 31 * result + (destination != null ? destination.hashCode() : 0);
        result = 31 * result + (cc != null ? cc.hashCode() : 0);
        result = 31 * result + (bcc != null ? bcc.hashCode() : 0);
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (attachment != null ? attachment.hashCode() : 0);
        return result;
    }
}
