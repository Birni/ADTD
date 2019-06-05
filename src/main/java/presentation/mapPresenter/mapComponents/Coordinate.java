package presentation.mapPresenter.mapComponents;

public class Coordinate
{
    private String Longitude;
    private String Latitude;

    public Coordinate(String Lat, String Long)
    {
        this.Latitude = Lat;
        this.Longitude = Long;
    }

    public String getLatitude()
    {
        return Latitude;
    }

    public Coordinate setLatitude(String Lat)
    {
        this.Latitude = Lat;
        return this;
    }

    public String getLongitude()
    {
        return Longitude;
    }

    public Coordinate setLongitude(String Long)
    {
        this.Longitude = Long;
        return this;
    }
}
