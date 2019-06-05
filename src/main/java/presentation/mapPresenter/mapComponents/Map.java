package presentation.mapPresenter.mapComponents;

import java.util.ArrayList;
import java.util.List;


public class Map
{

    List<Layer> layers = new ArrayList<Layer>();
    private Coordinate center = new Coordinate("49.013432", "12.101624") ;
    private String width = "1000px";
    private String height = "1000px";
    private String attribution = "Map data &copy; <a href=\"http://openstreetmap.org\">OpenStreetMap</a> contributors,<a href=\"http://creativecommons.org/licenses/by-sa/2.0/\">CC-BY-SA</a>";
    private int zoom = 1;
    private int minZoom = 1;
    private int maxZoom = 19;
    private boolean zoomControl = true;
    private boolean zoomEnabled = true;
    private boolean draggingEnabled = true;
    private boolean layerControl = true;
    private String urlTemplate = "http://{s}.tile.osm.org/{z}/{x}/{y}.png";


    public Coordinate getMapCenter()
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

    public String getAttribution()
    {
        return attribution;
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


}