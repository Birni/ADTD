package com.adtd.web.dataAccess;

public class LocationDTO {

    private String name;
    private long roadConnection;

    public LocationDTO() {

    }

    public LocationDTO (String name, long roadConnection)
    {
        this.name = name;
        this.roadConnection = roadConnection;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public long getRoadConnection() {
        return roadConnection;
    }

    public void setRoadConnection(long roadConnection) {
        roadConnection = roadConnection;
    }
}