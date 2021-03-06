package com.adtd.web.controller;

import com.adtd.web.Messaging.Sender;
import com.adtd.web.HelperObjects.JobDTO;
import com.adtd.web.services.JobIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



/**
 * Controller request handling to start jobs
 *
 * @author  Matthias Birnthaler
 */
@Controller
@Scope("request")
public class JobController {

    @Autowired
    JobIF jobIF;

    @Autowired
    Sender sender;

    /**
     * request handling to add a transportation job
     * @param job job data
     * @param model spring model
     *
     */
    @PostMapping("/addJob")
    public String addJob(@ModelAttribute JobDTO job , Model model) {
        JobIF.ErrorTypeJobIF error = jobIF.startJob(job);

        if(error == JobIF.ErrorTypeJobIF.ERROR_NO_ERROR) {

            model.addAttribute("state" , "Successfully");
            model.addAttribute("message" , "Transporter send out to destination");
        }
        if(error == JobIF.ErrorTypeJobIF.ERROR_INVALID_DATA){

            model.addAttribute("state" , "Error");
            model.addAttribute("message" , "Select valid targets");
        }
        if(error == JobIF.ErrorTypeJobIF.ERROR_NO_TRANSPORTER_AVAILABLE){
            model.addAttribute("state" , "Can not start job");
            model.addAttribute("message" , "No Transporter available");
        }
        if(error == JobIF.ErrorTypeJobIF.ERROR_UNKNOWN) {
            model.addAttribute("state" , "Error");
            model.addAttribute("message" , "Something bad happened");
        }
        else{
            /* no action planned*/
        }

        return "results";

    }
}


