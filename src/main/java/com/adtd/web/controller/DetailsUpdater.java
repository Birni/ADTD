package com.adtd.web.controller;


import com.adtd.web.HelperObjects.TransporterDTO;
import com.adtd.web.services.TransporterIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * Controller request handling to update the transporter information
 *
 * @author  Matthias Birnthaler
 */
@Controller
@Scope("request")
public class DetailsUpdater {

    @Autowired
    private TransporterIF transporterIF;

    /**
     * request handling to update transporter details table
     *
     */
    @RequestMapping(value = "table/update" , method = RequestMethod.GET)
    @ResponseBody
    public Iterable<TransporterDTO> updateDetails (){

        return  transporterIF.getListAllTransporter();
    }
}
