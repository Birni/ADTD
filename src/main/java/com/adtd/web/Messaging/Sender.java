package com.adtd.web.Messaging;


import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;

import com.adtd.web.HelperObjects.JobDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

/**
 * Sender to publish messages to the broker
 *
 * @author  Matthias Birnthaler
 */
@Component
@Scope("application")
public class Sender {

    @Value("${inbound-topic}")
    private String topicName;

    @Autowired
    private JmsTemplate jmsTemplate;


    public void sendTestBroadcastForOwnInbound(JobDTO jobDTO){

        JsonBuilderFactory factory = Json.createBuilderFactory(null);
        JsonObject value = factory.createObjectBuilder()
                    .add("NodeStartID", jobDTO.getNodeStartID())
                    .add("NodeTargetID", jobDTO.getNodeTargetID())
                    .add("JobPayload", jobDTO.getJobPayload())
                .build();

        jmsTemplate.send(topicName,new MessageCreator() {

            public Message createMessage(Session session) throws JMSException {
                TextMessage message = session.createTextMessage(value.toString());
                return message;
            }
        });
    }

    public void send(String topicName , String message){
        jmsTemplate.convertAndSend(topicName, message);
    }
}
