package com.adtd.web.controller;

import com.adtd.web.HelperObjects.TransporterDTO;
import com.adtd.web.services.TransporterIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



/**
 * Controller request to add or delete transporter
 *
 * @author  Matthias Birnthaler
 */
@Controller
@Scope("request")
public class TransporterController {

    @Autowired
    TransporterIF transporterIF;

    /**
     * request handling to add a transporter
     * @param newTransporterDTO transporter details
     * @param model spring model
     */
    @PostMapping("/addTransporter")
    public String addSubmit(@ModelAttribute TransporterDTO newTransporterDTO , Model model) {
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


    /**
     * request handling to delete a transporter
     * @param newTransporterDTO transporter details
     * @param model spring model
     */
    @PostMapping("/delTransporter")
    public String delSubmit(@ModelAttribute TransporterDTO newTransporterDTO ,Model model) {
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
            /* no action planned */
        }
        return "results";
    }
}

