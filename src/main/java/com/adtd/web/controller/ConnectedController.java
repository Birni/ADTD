package com.adtd.web.controller;


import com.adtd.web.Messaging.Sender;
import com.adtd.web.dataAccess.JobDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ConnectedController {

    @Autowired
    private Sender sender;


    @PostMapping("/broadcast")
    public String broadcastmessage ( Model model){

        JobDTO jobDTO = new JobDTO();
        jobDTO.setNodeStartID(23L);
        jobDTO.setNodeTargetID(16L);
        jobDTO.setJobPayload(10);
        sender.sendTestBroadcast("testy.test", jobDTO);

        model.addAttribute("state" , "Done");
        model.addAttribute("message" , "done broadcast but have not checked if received ");

        return "results";
    }
}
