package com.adtd.web.controller;


import com.adtd.web.mapComponents.LMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;


/**
 * Controller request to update the map layers
 *
 * @author  Matthias Birnthaler
 */
@Controller
@Scope("request")
public class MapUpdater {

    @Autowired
    LMap Map;

    /**
     * request handling to update the map
     *
     *
     */
    @RequestMapping(value = "map/update", method = RequestMethod.GET)
    @ResponseBody
    public List<LMap.MapMarker> updateMap (){
        return Map.getAllMarker();
    }
}
