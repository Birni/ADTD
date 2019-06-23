package presentation.mapPresenter.mapComponents;

import java.util.ArrayList;
import java.util.List;

public class MapLayer
{

    private List<Marker> markers = new ArrayList<Marker>();
    private List<MapLocation> locations = new ArrayList<MapLocation>();
    private List<MapRoute> routes = new ArrayList<MapRoute>();

    private String label;

    private boolean checked = true;
    private boolean clusterEnabled = false;
    private int clusterDisableAtZoom = 19;
    private int clusterMaxRadius = 80;

    public List<Marker> getMarkers()
    {
        return markers;
    }

    public List<MapLocation> getLocations()
    {
        return locations;
    }

    public List<MapRoute> getRoutes()
    {
        return routes;
    }

    public boolean isChecked()
    {
        return checked;
    }

    public boolean isClusterEnabled()
    {
        return clusterEnabled;
    }

    public int getClusterDisableAtZoom()
    {
        return clusterDisableAtZoom;
    }

    public int getClusterMaxRadius()
    {
        return clusterMaxRadius;
    }

    public String getLabel()
    {
        return label;
    }

    public MapLayer setLabel(String label)
    {
        this.label = label;
        return this;
    }

    public MapLayer addLocation(MapLocation location)
    {
        this.locations.add(location);
        return this;
    }

    public MapLayer addMarker(Marker marker)
    {
        this.markers.add(marker);
        return this;
    }

    public MapLayer addRoute(MapRoute route)
    {
        this.routes.add(route);
        return this;
    }

}
