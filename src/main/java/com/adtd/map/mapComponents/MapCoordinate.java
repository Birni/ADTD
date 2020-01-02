package com.adtd.map.mapComponents;

public class MapCoordinate
{
    private String Longitude;
    private String Latitude;

    public MapCoordinate(String Lat, String Long)
    {
        this.Latitude = Lat;
        this.Longitude = Long;
    }

    public String getLatitude()
    {
        return Latitude;
    }

    public MapCoordinate setLatitude(String Lat)
    {
        this.Latitude = Lat;
        return this;
    }

    public String getLongitude()
    {
        return Longitude;
    }

    public MapCoordinate setLongitude(String Long)
    {
        this.Longitude = Long;
        return this;
    }
}
