package presentation.mapPresenter.map;

import org.primefaces.context.RequestContext;
import services.entity.Coordinate;
import services.entity.Location;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


import java.io.Serializable;
import java.util.List;

import presentation.mapPresenter.mapComponents.*;
import services.entity.Node;
import services.entity.Transporter;
import services.service.LocationCollection;
import services.service.Route;
import services.service.RouteProvider;
import services.service.VirtualTransporterManager;


@ManagedBean(name = "mapBean")
@ViewScoped
public class MapBean implements Serializable
{

    private Map myMapBean = new Map();

    private void GenerateMap()
    {

        myMapBean = new Map();

        List <Location> collection = LocationCollection.getLocations();

        for(Location location : collection)
        {

            List<Coordinate> CoordsList = location.GetCoordinateList();
            MapLayer garageLayer = (new MapLayer().setLabel(location.GetName()));
            MapLocation MapGarage = new MapLocation();

            for (Coordinate Coord : CoordsList) {
                MapGarage.addCoordinate(new MapCoordinate(Coord.GetLatitudeString(), Coord.GetLongitudeString()));
            }
            garageLayer.addLocation(MapGarage);
            myMapBean.addLayer(garageLayer);


        }

        RouteProvider RoutService = new RouteProvider();
        List<Route> streets  =  RoutService.GetFullsRoadNetwork();

        for(Route street : streets)
        {
            MapLayer routeLayer = (new MapLayer().setLabel("dummy"));
            MapRoute route = new MapRoute();

            for(Node node : street.GetRouteNodes())
            {
                route.addCoordinate(new MapCoordinate(node.GetCoordinate().GetLatitudeString(), node.GetCoordinate().GetLongitudeString()));
            }

            routeLayer.addRoute(route);
            myMapBean.addLayer(routeLayer);

        }


        for (Transporter transporter : VirtualTransporterManager.getInstance().GetTransporterWithJob())
        {
            MapLayer testMarker =(new MapLayer().setLabel("marker"));
            Marker marker = new Marker(new MapCoordinate(transporter.GetPosition().GetLatitudeString(), transporter.GetPosition().GetLongitudeString()));
            testMarker.addMarker(marker);

            myMapBean.addLayer(testMarker);
        }

    }


    public MapBean()
    {
        GenerateMap();
    }


    public Map UpdateMap()
    {
        GenerateMap();

     //   for (Transporter transporter : VirtualTransporterManager.getInstance().GetTransporterWithJob())
     //   {
     //       MapLayer testMarker =(new MapLayer().setLabel("marker"));
     //       Marker marker = new Marker(new MapCoordinate(transporter.GetPosition().GetLatitudeString(), transporter.GetPosition().GetLongitudeString()));
     //       testMarker.addMarker(marker);
//
     //       myMapBean.addLayer(testMarker);
     //   }
        myMapBean.setreloadAll(false);
        return myMapBean;
    }

    public Map getMap() {
        return myMapBean;
    }

}
