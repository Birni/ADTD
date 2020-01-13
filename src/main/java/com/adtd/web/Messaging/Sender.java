package com.adtd.web.Messaging;

import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;

import com.adtd.web.dataAccess.JobDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class Sender {


    @Autowired
    private JmsTemplate jmsTemplate;


    public void sendTestBroadcast(String topicName, JobDTO jobDTO){

        JsonBuilderFactory factory = Json.createBuilderFactory(null);
        JsonObject value = factory.createObjectBuilder()
                    .add("NodeStartID", jobDTO.getNodeStartID())
                    .add("NodeTargetID", jobDTO.getNodeTargetID())
                    .add("JobPayload", jobDTO.getJobPayload())
                .build();

        jmsTemplate.convertAndSend(topicName, "test");

        jmsTemplate.send(topicName,new MessageCreator() {

            public Message createMessage(Session session) throws JMSException {
                TextMessage message = session.createTextMessage(value.toString());
                return message;
            }
        });
    }

}
