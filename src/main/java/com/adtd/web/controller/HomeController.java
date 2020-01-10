package com.adtd.web.controller;

import com.adtd.web.dataAccess.*;
import com.adtd.web.mapComponents.LMap;
import com.adtd.web.services.LocationIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    private TransporterDTO TransporterDto;

    @Autowired
    private LMap Lmap;

    @Autowired
    private LocationIF locationIF;


    @RequestMapping("/home")
    public String getHomePage(Model model) {

        Iterable<TransporterDTO> tranList = TransporterDto.getListAllTransporter();
        model.addAttribute("transporterlist", tranList);

        model.addAttribute("LBasicMapData", Lmap.getBasicMapData());
        model.addAttribute("MapLocations", Lmap.getJsonLocation());
        model.addAttribute("MapRoutes", Lmap.getAllRoutesMap());
        model.addAttribute("MapMarker", Lmap.getAllMarker());

        model.addAttribute("newTransporterDTO", new NewTransporterDTO());
        model.addAttribute("delTransporterDTO",  new NewTransporterDTO());

        Iterable<LocationDTO> locationList = locationIF.GetAllProductions();
        model.addAttribute("ProductionLines",  locationList);
        model.addAttribute("jobRoute", new TransporterJob());


        return "index.html";
    }



}
