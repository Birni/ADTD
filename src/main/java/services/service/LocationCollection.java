package services.service;

import services.entity.Location;

import java.util.ArrayList;
import java.util.List;

public class LocationCollection
{
    private static LocationCollection instance;

    private List<Location> Collection = new ArrayList<Location>();

    private LocationCollection()
    {

    }

    public static LocationCollection getInstance()
    {
        if(null == LocationCollection.instance)
        {
            LocationCollection.instance = new LocationCollection();
        }
        return LocationCollection.instance;
    }

    public static void addLocation (Location newLocation)
    {
        getInstance().Collection.add(newLocation);
    }

    public static List<Location> getLocations ()
    {
        return getInstance().Collection;
    }




    public Location getLocationByID(String ID)
    {
        for(int i = 0; i<Collection.size(); i++)
        {
            if(Collection.get(i).getLocationId() == ID)
            {
                return Collection.get(i);
            }
        }

        return null;
    }

}
