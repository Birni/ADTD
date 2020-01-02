package com.adtd.web.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;


@Entity
public class Coordinate
{
    @Column(scale=6, precision = 8)
    BigDecimal Latitude;
    @Column(scale=6, precision = 8)
    BigDecimal  Longitude;

    public Coordinate()
    {

    }

    public Coordinate(float latitude, float longitude)
    {
        this.Latitude = BigDecimal.valueOf(latitude);
        this.Longitude = BigDecimal.valueOf(longitude);
    }

    public BigDecimal GetLatitude()
    {
        return Latitude;
    }

    public BigDecimal GetLongitude()
    {
        return Longitude;
    }

    public String GetLatitudeString()
    {
        return Latitude.toString();
    }

    public String GetLongitudeString()
    {
        return Longitude.toString();
    }

    public void SetCoordinates(float latitude, float longitude)
    {
        this.Latitude = BigDecimal.valueOf(latitude);
        this.Longitude = BigDecimal.valueOf(longitude);
    }
}