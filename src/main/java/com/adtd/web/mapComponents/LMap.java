package com.adtd.web.mapComponents;

import com.adtd.web.entity.Coordinate;
import com.adtd.web.entity.Location;
import com.adtd.web.entity.Node;
import com.adtd.web.entity.Transporter;
import com.adtd.web.repository.LocationRepository;
import com.adtd.web.repository.TransporterRepository;
import com.adtd.web.entity.Job;
import com.adtd.web.route.RouteProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.json.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Component with basic map data for the leaflet/ osm map
 *
 * @author  Matthias Birnthaler
 */
@Service
@Scope("session")
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


    /**
     * generates a list with all locations as geo json
     * leaflet adds the geo json as layer to the map
     *
     */
    public List<String> getJsonLocation() {
        List<String> jsonLocation = new ArrayList<>();
        for (Location location : LocationRepo.findAll()) {
            jsonLocation.add(getJsonString("Feature", "Polygon",location.GetLocatonType().toString(),
                    location.GetCoordinateList()));
        }
        return jsonLocation;
    }


    /**
     * generates a list with all streets/routes as geo json
     * leaflet adds the geo json as layer to the map
     *
     */
    public List<String> getAllRoutesMap() {
        List<String> jsonRoutNetwork = new ArrayList<>();
        for (Job job : RouteProvider.GetFullsRoadNetwork()){
            jsonRoutNetwork.add(getJsonStringRoutes("LineString" , job.getRouteNodes()));
        }

        return jsonRoutNetwork;
    }


    /**
     * generates a list with all marker i.e. transporter
     * leaflet adds the maker to the map
     *
     */
    public List<MapMarker> getAllMarker() {
        List<MapMarker> mapMarker = new ArrayList<>();
        for(Transporter transporter : TransporterRepo.findAll())
        {
            MapMarker marker = new MapMarker();
            marker.setLabel(transporter.getLabel());
            marker.setLatitude(transporter.GetPosition().GetCoordinate().GetLatitude().doubleValue());
            marker.setLongitude(transporter.GetPosition().GetCoordinate().GetLongitude().doubleValue());

            mapMarker.add(marker);
        }
        return mapMarker;
    }


    /**
     * generates a geo json string
     * @param type geo json type
     * @param GeometryType geo json geometry types
     * @param LocationType type of the location, garage or production
     * @param coords list with coordinates
     */
    private String getJsonString(String type, String GeometryType,String LocationType, List<Coordinate> coords){

        JsonBuilderFactory factory = Json.createBuilderFactory(null);

        JsonArrayBuilder coordinates = Json.createArrayBuilder();
        for(Coordinate coord: coords) {
            JsonArrayBuilder jsonCord = Json.createArrayBuilder();
            jsonCord.add(coord.GetLongitude());
            jsonCord.add(coord.GetLatitude());
            coordinates.add(jsonCord);
        }


        JsonArrayBuilder coordinateArray = Json.createArrayBuilder();
        coordinateArray.add(coordinates);

        JsonObjectBuilder properties = Json.createObjectBuilder();
        properties.add("Location",LocationType);

        JsonObjectBuilder geometry = Json.createObjectBuilder();
        geometry.add("type", GeometryType);
        geometry.add("coordinates", coordinateArray);

        JsonObject value = factory.createObjectBuilder()
                        .add("type", type)
                        .add("properties", properties)
                        .add("geometry", geometry)

                .build();

        return value.toString();
    }

    /**
     * generates a geo json string
     * @param type geo json type
     * @param routeNodes list with coordinates
     *
     */
    public String getJsonStringRoutes(String type, List<Node> routeNodes){

        JsonBuilderFactory factory = Json.createBuilderFactory(null);

        JsonArrayBuilder coordinates = Json.createArrayBuilder();
        for (Node node : routeNodes) {
            JsonArrayBuilder jsonCoord = Json.createArrayBuilder();
            jsonCoord.add(node.GetCoordinate().GetLongitude());
            jsonCoord.add(node.GetCoordinate().GetLatitude());

            coordinates.add(jsonCoord);
        }


        JsonObject value = factory.createObjectBuilder()
                    .add("type", type )
                    .add("coordinates", coordinates)
                .build();


        String debug = value.toString();

        return value.toString();

    }

    /**
     * class for a Map Marker
     *
     */
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

