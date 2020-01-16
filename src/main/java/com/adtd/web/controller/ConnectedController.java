package com.adtd.web.controller;


import com.adtd.web.Messaging.Sender;
import com.adtd.web.dataAccess.JMSMessage;
import com.adtd.web.dataAccess.JobDTO;
import com.adtd.web.dataAccess.LocationDTO;
import com.adtd.web.services.LocationIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Random;


/**
 * Controller for the request handling of the connected features
 *
 * @author  Matthias Birnthaler
 */
@Controller
public class ConnectedController {

    @Autowired
    private Sender sender;

    @Autowired
    private LocationIF locationIF;

    /**
     * request handling for the broadcast
     *
     */
    @PostMapping("/broadcast")
    public String broadcastForOwnInbound ( Model model){

        JobDTO jobDTO = new JobDTO();

        jobDTO.setJobPayload(10);

        List<LocationDTO> locationDTOList = locationIF.GetAllProductions();
        Random r = new Random();
        jobDTO.setNodeStartID(locationDTOList.get(r.nextInt(locationDTOList.size())).getIdentifier());
        jobDTO.setNodeTargetID(locationDTOList.get(r.nextInt(locationDTOList.size())).getIdentifier());

        sender.sendTestBroadcastForOwnInbound(jobDTO);

        model.addAttribute("state" , "Done");
        model.addAttribute("message" , "done broadcast but have not checked if received ");

        return "results";
    }

    /**
     * request handling to publish a message to a topc
     *
     */
    @PostMapping("/sendJmsMessage")
    public String sendJmsMessage (@ModelAttribute JMSMessage jmsMessage, Model model){

        sender.send(jmsMessage.getTopic(), jmsMessage.getMessage());

        model.addAttribute("state" , "Done");
        model.addAttribute("message" , "done broadcast but have not checked if received ");

        return "results";
    }
}
