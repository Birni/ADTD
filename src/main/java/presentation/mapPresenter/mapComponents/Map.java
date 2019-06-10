package presentation.mapPresenter.mapComponents;

import java.util.ArrayList;
import java.util.List;


public class Map
{

    private List<Layer> layers = new ArrayList<Layer>();
    private Coordinate center = new Coordinate("49.00326", "12.09678") ;
    private String width = "100hh";
    private String height = "100vh";
    private String attribution = "Map data &copy; <a href=\"http://openstreetmap.org\">OpenStreetMap</a> contributors,<a href=\"http://creativecommons.org/licenses/by-sa/2.0/\">CC-BY-SA</a>";
    private int zoom = 19;
    private int minZoom = 1;
    private int maxZoom = 19;
    private boolean zoomControl = false;
    private boolean zoomEnabled = true;
    private boolean draggingEnabled = true;
    private boolean layerControl = true;
    private String urlTemplate = "http://{s}.tile.osm.org/{z}/{x}/{y}.png";


    public List<Layer> getLayers()
    {
        return layers;
    }

    public Map addLayer(Layer layer) {
        this.layers.add(layer);
        return this;
    }


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