package com.adtd.web.services;

import com.adtd.web.dataAccess.LocationDTO;
import com.adtd.web.entity.Location;
import com.adtd.web.entity.LocatonType;
import com.adtd.web.repository.LocationRepository;
import com.adtd.web.repository.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.font.ShapeGraphicAttribute;
import java.util.ArrayList;
import java.util.List;

@Service
public class LocationIF {

    @Autowired
    LocationRepository LocationRepo;

    public List<LocationDTO> GetAllProductions() {
        List<LocationDTO> locationList = new ArrayList<>();
        for (Location location : LocationRepo.findAll()) {
            if(location.GetLocatonType() != LocatonType.GARAGE) {
                LocationDTO temp = new LocationDTO(location.GetName(), ((int) location.getRoadConnection()));

                locationList.add(temp);
            }
        }
        return locationList;
    }

}
