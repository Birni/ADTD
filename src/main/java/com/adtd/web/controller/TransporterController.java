package com.adtd.web.controller;

import com.adtd.web.dataAccess.NewTransporterDTO;
import com.adtd.web.services.TransporterIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TransporterController {

    @Autowired
    TransporterIF transporterIF;

    @PostMapping("/addTransporter")
    public String addSubmit(@ModelAttribute NewTransporterDTO newTransporterDTO ,Model model) {
        TransporterIF.ErrorTypeTransporterIf error = transporterIF.AddTransporterToRepo(newTransporterDTO);

        if(error == TransporterIF.ErrorTypeTransporterIf.ERROR_NO_ERROR) {

            model.addAttribute("state" , "Successfully added");
            model.addAttribute("message" , "Transporter added to System");
        }
        if(error == TransporterIF.ErrorTypeTransporterIf.ERROR_DB){

            model.addAttribute("state" , "Error");
            model.addAttribute("message" , "Transporter is already in Database");
        }
        if(error == TransporterIF.ErrorTypeTransporterIf.ERROR_INVALID_DATA){
            model.addAttribute("state" , "Error");
            model.addAttribute("message" , "Add a Label");
        }
        else{
            // no action planned
        }

        return "results";
    }

    @PostMapping("/delTransporter")
    public String delSubmit(@ModelAttribute NewTransporterDTO newTransporterDTO ,Model model) {
        TransporterIF.ErrorTypeTransporterIf error = transporterIF.DelTransporterFromRepo(newTransporterDTO);

        if(error == TransporterIF.ErrorTypeTransporterIf.ERROR_NO_ERROR) {

            model.addAttribute("state" , "Successfully deleted");
            model.addAttribute("message" , "Transporter deleted from system");
        }
        if(error == TransporterIF.ErrorTypeTransporterIf.ERROR_DB){

            model.addAttribute("state" , "Error");
            model.addAttribute("message" , "Looks like it is already deleted");
        }
        if(error == TransporterIF.ErrorTypeTransporterIf.ERROR_INVALID_DATA){
            model.addAttribute("state" , "Error");
            model.addAttribute("message" , "Select a transporter ");
        }
        else{
            // no action planned
        }
        return "results";
    }

}

