package com.adtd.web.controller;


import com.adtd.web.dataAccess.TransporterDTO;
import com.adtd.web.services.TransporterIF;
import org.springframework.beans.factory.annotation.Autowired;
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
public class DetailsUpdater {

    @Autowired
    private TransporterIF transporterIF;

    @RequestMapping(value = "table/update" , method = RequestMethod.GET)
    @ResponseBody
    public Iterable<TransporterDTO> updateDetails (){
        Iterable<TransporterDTO> translist = transporterIF.getListAllTransporter();

        return translist;
    }
}
