package com.adtd.web.dataAccess;

public class JMSMessage {

    private String topic;
    private String message;

    public String getMessage() {
        return message;
    }

    public String getTopic() {
        return topic;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
