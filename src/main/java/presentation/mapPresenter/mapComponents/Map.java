package presentation.mapPresenter.mapComponents;

import services.entity.Location;

import java.util.ArrayList;
import java.util.List;


public class Map
{

    private List<Marker> markers = new ArrayList<Marker>();
    private List<MapLocation> locations = new ArrayList<MapLocation>();
    private List<MapRoute> routes = new ArrayList<MapRoute>();

    private MapCoordinate center = new MapCoordinate("49.003038", "12.096346") ;
    private String width = "100";
    private String height = "100";
    private int zoom = 18;
    private int minZoom = 1;
    private int maxZoom = 19;
    private boolean zoomControl = false;
    private boolean zoomEnabled = true;
    private boolean draggingEnabled = true;
    private boolean layerControl = true;
    private String urlTemplate = "http://{s}.tile.osm.org/{z}/{x}/{y}.png";
    private boolean reloadAll = true;


    public void addLocation(MapLocation location)
    {
        this.locations.add(location);
    }

    public List<MapLocation> getLocations()
    {
        return this.locations;
    }

    public void addRoute(MapRoute route)
    {
        this.routes.add(route);
    }

    public List<MapRoute> getRoutes(){
        return this.routes;
    }

    public void addMarker(Marker marker){
        this.markers.add(marker);
    }

    public List<Marker> getMarkers(){
        return this.markers;
    }

    public MapCoordinate getMapCenter()
    {
        return center;
    }


    public String getWidth()
    {
        return width;
    }

    public String getHeight()
    {
        return height;
    }


    public int getZoom()
    {
        return zoom;
    }

    public int getMinZoom()
    {
        return minZoom;
    }

    public int getMaxZoom()
    {
        return maxZoom;
    }

    public boolean getZoomControl()
    {
        return zoomControl;
    }

    public boolean getZoomEnabled()
    {
        return zoomEnabled;
    }

    public boolean getDraggingEnabled()
    {
        return draggingEnabled;
    }

    public boolean getLayerControl()
    {
        return layerControl;
    }

    public String getUrlTemplate()
    {
        return urlTemplate;
    }

    public boolean getmapreloadAll()
    {
        return reloadAll;
    }

    public void setreloadAll(boolean reload)
    {
         this.reloadAll = reload;
    }
}