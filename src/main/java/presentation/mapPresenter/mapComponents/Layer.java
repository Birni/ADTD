package presentation.mapPresenter.mapComponents;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Layer
{

    private List<Marker> markers = new ArrayList<Marker>();
    private List<Location> locations = new ArrayList<Location>();
    private List<Circle> circles = new ArrayList<Circle>();
    private List<Route> routes = new ArrayList<Route>();

    private String label;

    private boolean checked = true;
    private boolean clusterEnabled = false;
    private int clusterDisableAtZoom = 19;
    private int clusterMaxRadius = 80;

    public List<Marker> getMarkers()
    {
        return markers;
    }

    public List<Location> getLocations()
    {
        return locations;
    }

    public List<Circle> getCircles()
    {
        return circles;
    }

    public List<Route> getRoutes()
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

    public Layer setLabel(String label)
    {
        this.label = label;
        return this;
    }

    public Layer addLocation(Location location)
    {
        this.locations.add(location);
        return this;
    }

    public Layer addMarker(Marker marker)
    {
        this.markers.add(marker);
        return this;
    }

    public Layer addRoute(Route route)
    {
        this.routes.add(route);
        return this;
    }

}
