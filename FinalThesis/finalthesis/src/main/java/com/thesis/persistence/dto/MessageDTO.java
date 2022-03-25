package com.thesis.persistence.dto;

public class MessageDTO
{
    private String origin;
    private String destination;
    private String cc;
    private String bcc;
    private String subject;
    private String body;
    private String attachment;

    public MessageDTO(String origin, String destination, String cc, String bcc, String subject, String body, String attachment) {
        this.origin = origin;
        this.destination = destination;
        this.cc = cc;
        this.bcc = bcc;
        this.subject = subject;
        this.body = body;
        this.attachment = attachment;
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

    @Override
    public String toString()
    {
        return "ORIGIN : "+this.origin+"\n"+
                "DESTINATION : "+this.destination+"\n"+
                "CC : "+this.cc+"\n"+
                "BCC : "+this.bcc+"\n"+
                "SUBJECT : "+this.subject+"\n"+
                "BODY : "+this.body+"\n"+
                "ATTACHMENT : "+this.attachment;
    }
}
