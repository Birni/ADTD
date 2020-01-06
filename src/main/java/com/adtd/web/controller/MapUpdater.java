package com.adtd.web.controller;


import com.adtd.web.mapComponents.LMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

@Controller

public class MapUpdater {

    @Autowired
    LMap Map;

    @RequestMapping(value = "map/update", method = RequestMethod.GET)
    @ResponseBody
    public List<LMap.MapMarker> updateMap (){
        return Map.getAllMarker();
    }

}
