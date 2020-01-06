package com.adtd.web.mapComponents;

import com.adtd.web.entity.Coordinate;
import com.adtd.web.entity.Location;
import com.adtd.web.entity.Node;
import com.adtd.web.entity.Transporter;
import com.adtd.web.repository.LocationRepository;
import com.adtd.web.repository.TransporterRepository;
import com.adtd.web.route.Route;
import com.adtd.web.route.RouteProvider;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    RouteProvider RouteProvider;


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

    public List<String> getAllRoutesMap() {
        List<String> jsonRoutNetwork = new ArrayList<>();
        for (Route route : RouteProvider.GetFullsRoadNetwork()){
            jsonRoutNetwork.add(getJsonStringRoutes("LineString" , route.GetRouteNodes()));
        }

        return jsonRoutNetwork;
    }

    public List<MapMarker> getAllMarker() {
        List<MapMarker> mapMarker = new ArrayList<>();
        for(Transporter transporter : TransporterRepo.findAll())
        {
            MapMarker marker = new MapMarker();
            marker.setLabel(transporter.getLabel());
            marker.setLatitude(transporter.GetPosition().GetLatitude().doubleValue());
            marker.setLongitude(transporter.GetPosition().GetLongitude().doubleValue());

            mapMarker.add(marker);
        }
        return mapMarker;
    }




    private String getJsonString(String type, String GeometryType, List<Coordinate> coords)
    {

        String jsonString = "{" +
                "\"type\":\""+ type +"\"," +
                "\"properties\": {\"party\": \"Democrat\"} ," +
                "\"geometry\":{" +
                "\"type\":\""+ GeometryType +"\","     +
                "\"coordinates\": [[";
        for(int i=0; i < coords.size(); i++ )
        {
            jsonString += "[" + coords.get(i).GetLongitude() +","+ coords.get(i).GetLatitude() +"]" +",";

        }

        jsonString += "[" + coords.get(0).GetLongitude() +","+ coords.get(0).GetLatitude() +"]";

        jsonString += "]]}}";


        return jsonString;
    }

    public String getJsonStringRoutes(String type, List<Node> routeNodes)
    {

        String jsonString = "{" +
                "\"type\":\""+ type +"\","                          +
                "\"coordinates\": [";
        for(int i=0; i < routeNodes.size(); i++ )
        {
            jsonString += "[" + routeNodes.get(i).GetCoordinate().GetLongitude() +","+  routeNodes.get(i).GetCoordinate().GetLatitude() +"]";

            if(i < routeNodes.size()-1)
            {
                jsonString +=",";
            }


        }

        jsonString += "]}";
        return jsonString;
    }

    public class MapMarker{
        private double Latitude;
        private double Longitude;
        private String Label;

        public String getLabel() {
            return Label;
        }

        public double getLatitude() {
            return Latitude;
        }

        public double getLongitude() {
            return Longitude;
        }

        public void setLabel(String label) {
            Label = label;
        }

        public void setLatitude(double latitude) {
            Latitude = latitude;
        }

        public void setLongitude(double longitude) {
            Longitude = longitude;
        }
    }


}

