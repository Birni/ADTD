package com.adtd.web.controller;

import com.adtd.web.mapComponents.LMap;
import com.adtd.web.dataAccess.TransporterDTO;
import com.adtd.web.repository.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private TransporterDTO TransporterDto;

    @Autowired
    private LMap Lmap;

    @RequestMapping("/home")
    public String starten(Model model) {

        Map<String, Object> map = new HashMap<>();
        Iterable<TransporterDTO> tranList = TransporterDto.getListAllTransporter();
        model.addAttribute("transporterlist", tranList);

        model.addAttribute("LBasicMapData", Lmap.getBasicMapData());
        model.addAttribute("MapLocations", Lmap.getJsonLocation());
        model.addAttribute("MapRoutes", Lmap.getAllRoutesMap());
        model.addAttribute("MapMarker", Lmap.getAllMarker());
        //model.addAttribute("Lmap", Lmap);
        model.mergeAttributes(map);
        return "index.html";
    }



}
