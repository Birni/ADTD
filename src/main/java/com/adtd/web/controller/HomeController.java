package com.adtd.web.controller;

import com.adtd.web.dataAccess.*;
import com.adtd.web.mapComponents.LMap;
import com.adtd.web.services.LocationIF;
import com.adtd.web.services.TransporterIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Controller request handling of the home page
 *
 * @author  Matthias Birnthaler
 */
@Controller
public class HomeController {

    @Autowired
    private TransporterIF transporterIF;

    @Autowired
    private LMap Lmap;

    @Autowired
    private LocationIF locationIF;


    @RequestMapping(value = {"", "/", "/home"})
    public String getHomePage(Model model) {

        Iterable<TransporterDTO> tranList = transporterIF.getListAllTransporter();
        model.addAttribute("transporterlist", tranList);

        model.addAttribute("LBasicMapData", Lmap.getBasicMapData());
        model.addAttribute("MapLocations", Lmap.getJsonLocation());
        model.addAttribute("MapRoutes", Lmap.getAllRoutesMap());
        model.addAttribute("MapMarker", Lmap.getAllMarker());

        model.addAttribute("newTransporterDTO", new TransporterDTO());
        model.addAttribute("delTransporterDTO",  new TransporterDTO());

        Iterable<LocationDTO> locationList = locationIF.GetAllProductions();
        model.addAttribute("ProductionLines",  locationList);
        model.addAttribute("jobRoute", new JobDTO());
        model.addAttribute("jmsMessage", new JMSMessage());

        return "index.html";
    }
}
