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
            MapLocation mapLocation = new MapLocation();

            for (Coordinate Coord : CoordsList) {
                mapLocation.addCoordinate(new MapCoordinate(Coord.GetLatitudeString(), Coord.GetLongitudeString()));
            }
            myMapBean.addLocation(mapLocation);

        }

        RouteProvider RoutService = new RouteProvider();
        List<Route> streets  =  RoutService.GetFullsRoadNetwork();

        for(Route street : streets)
        {
            MapRoute route = new MapRoute();

            for(Node node : street.GetRouteNodes())
            {
                route.addCoordinate(new MapCoordinate(node.GetCoordinate().GetLatitudeString(), node.GetCoordinate().GetLongitudeString()));
            }

            myMapBean.addRoute(route);
        }


        for (Transporter transporter : VirtualTransporterManager.getInstance().GetAllTransporter())
        {
            Marker marker = new Marker(new MapCoordinate(transporter.GetPosition().GetLatitudeString(), transporter.GetPosition().GetLongitudeString()));
            myMapBean.addMarker(marker);
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
     //
     //       Marker marker = new Marker(new MapCoordinate(transporter.GetPosition().GetLatitudeString(), transporter.GetPosition().GetLongitudeString()));
     //          myMapBean.addMarker(marker);
     //   }
        myMapBean.setreloadAll(false);
        return myMapBean;
    }

    public Map getMap() {
        return myMapBean;
    }

}
