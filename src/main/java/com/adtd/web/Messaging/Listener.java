package com.adtd.web.Messaging;

import com.adtd.web.HelperObjects.JobDTO;

import com.adtd.web.services.JobIF;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;




/**
 * Listener to receive messages form the broker
 *
 * @author  Matthias Birnthaler
 */
@Component
@Scope("singleton")
public class Listener {


    @Autowired
    JobIF jobIF;

    @JmsListener(destination = "sw_matthias_birnthaler_topic_adtdjob")
    public void receiveJobMessage(String message) {

        Gson g = new Gson();

        JobDTO jobDTO = null;

        try {
             jobDTO = g.fromJson(message, JobDTO.class);
        }
        catch (JsonParseException e) {
        // no action planned
        }

        if(jobDTO != null) {
            jobIF.startJob(jobDTO);
        }
    }
}
