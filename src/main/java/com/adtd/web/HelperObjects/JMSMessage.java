package com.adtd.web.HelperObjects;


/**
 * Class for a JMS Message
 *
 * @author  Matthias Birnthaler
 */
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
