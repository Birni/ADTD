package com.adtd.web.Messaging;

import com.adtd.web.dataAccess.JobDTO;

import com.adtd.web.services.JobIF;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.json.JsonObject;
import java.io.Console;


@Component
public class Listener {


    @Autowired
    JobIF jobIF;

    @JmsListener(destination = "testy")
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

