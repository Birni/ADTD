package com.adtd.web.controller;

import com.adtd.web.dataAccess.LocationDTO;
import com.adtd.web.dataAccess.NewTransporterDTO;
import com.adtd.web.dataAccess.TransporterJob;
import com.adtd.web.entity.Route;
import com.adtd.web.services.JobIF;
import com.adtd.web.services.TransporterIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JobController {

    @Autowired
    JobIF jobIF;

    @PostMapping("/addJob")
    public String addJob(@ModelAttribute TransporterJob job , Model model) {
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
        if(error == JobIF.ErrorTypeJobIF.ERROR_NO_TRANSPORTER_AVAILABLE) {
            model.addAttribute("state" , "Error");
            model.addAttribute("message" , "Something bad happened");
        }
        else{
            // no action planned
        }
        return "results";

    }

}


