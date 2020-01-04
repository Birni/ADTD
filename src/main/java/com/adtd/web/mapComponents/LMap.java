package com.adtd.web.mapComponents;

import com.adtd.web.entity.Coordinate;
import com.adtd.web.entity.Location;
import com.adtd.web.repository.LocationRepository;
import com.adtd.web.repository.TransporterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LMap {

    @Autowired
    private BasicMapData basicMapData;

    @Autowired
    private TransporterRepository TransporterRepo;

    @Autowired
    private LocationRepository LocationRepo;

    public BasicMapData getBasicMapData() {
        return basicMapData;
    }

    public List<String> getJsonLocation() {
        List<String> jsonLocation = new ArrayList<>();
        for (Location location : LocationRepo.findAll()) {
            jsonLocation.add(getJsonString("Feature", "Polygon", location.GetCoordinateList()));
        }
        return jsonLocation;
    }

//    public List<String> getJsonLocation() {
//        List<String> jsonLocation = new ArrayList<>();
//        for (Location location : LocationRepo.findAll()) {
//            jsonLocation.add(getJsonString("Feature", "Polygon", location.GetCoordinateList()));
//        }
//
//        return jsonLocation;
//    }
//
    private String getJsonString(String type, String GeometryType, List<Coordinate> coords)
    {

        String jsonString = "{" +
                "\"type\":\""+ type +"\","                          +
                "\"geometry\":{"                                    +
                "\"type\":\""+ GeometryType +"\","     +
                "\"coordinates\": [[";
        for(int i=0; i < coords.size(); i++ )
        {
            jsonString += "[" + coords.get(i).GetLongitude() +","+ coords.get(i).GetLongitude() +"]";

            if(i < coords.size()-1)
            {
                jsonString +=",";
            }


        }

        jsonString += "]]}}";


        return jsonString;
    }
}

