package com.adtd.web.mapComponents;

import com.adtd.web.entity.Coordinate;
import com.adtd.web.entity.Location;
import com.adtd.web.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
public class LMap {

    private double centerLat = 49.003038;
    private double centerLong = 12.096346;
    private int zoom = 18;
    private int minZoom = 1;
    private int maxZoom = 19;
    private boolean zoomControl = false;
    private boolean zoomEnabled = true;
    private boolean draggingEnabled = true;
    private String urlTemplate = "http://{s}.tile.osm.org/{z}/{x}/{y}.png";

    @Autowired
    private List<MapLocation> jsonLocation; //= new ArrayList<>();

    @Autowired
    private LocationRepository LocationRepo;

    public LMap() {
      //  for (Location location : LocationRepo.findAll()) {
      //      jsonLocation.add(getJsonString("Feature", "Polygon", location.GetCoordinateList()));
      //  }
    }


    public void setCenterLat(double centerLat) {
        centerLat = centerLat;
    }

    public void setCenterLong(double centerLong) {
        centerLong = centerLong;
    }

    public void setZoom(int zoom){
        this.zoom = zoom;
    }

    public void setMinZoom(int zoom){
        this.minZoom = zoom;
    }

    public void setMaxZoom(int zoom) {
        this.maxZoom = zoom;
    }

    public void setZoomControl(boolean zoomControl) {
        this.zoomControl = zoomControl;
    }

    public void setZoomEnabled(boolean zoomEnabled) {
        this.zoomControl = zoomEnabled;
    }

    public void setDraggingEnabled(boolean draggingEnabled) {
        this.draggingEnabled = draggingEnabled;
    }

    public void setUrlTemplate(String urlTemplate) {
        this.urlTemplate =urlTemplate;
    }

    public void setJsonLocation(List<String> jsonLocation) {
   //     this.jsonLocation = jsonLocation;
    }

    public boolean isDraggingEnabled() {
        return draggingEnabled;
    }

    public boolean isZoomControl() {
        return zoomControl;
    }

    public boolean isZoomEnabled() {
        return zoomEnabled;
    }

    public double getCenterLat() {
        return centerLat;
    }

    public double getCenterLong() {
        return centerLong;
    }

    public int getMaxZoom() {
        return maxZoom;
    }

    public int getMinZoom() {
        return minZoom;
    }

    public int getZoom() {
        return zoom;
    }

    public String getUrlTemplate() {
        return urlTemplate;
    }

   // public List<String> getJsonLocation() {
   //     return jsonLocation;
   // }

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

