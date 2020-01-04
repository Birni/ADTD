package com.adtd.web.mapComponents;


import java.io.Console;
import java.util.List;


import com.adtd.web.entity.Coordinate;
import com.adtd.web.entity.Location;
import com.adtd.web.entity.Transporter;
import com.adtd.web.repository.LocationRepository;
import com.adtd.web.repository.TransporterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



public class MapComponment{


    @Autowired
    private LocationRepository  LocationRepo;

    @Autowired
    private TransporterRepository TransporterRepo;


  //  private static Map myMapBean = new Map();

    private void GenerateMap()
    {

        System.out.println("done");
//        myMapBean = new Map();
//
//
//        for(Location location : LocationRepo.findAll())
//        {
//
//            List<Coordinate> CoordsList = location.GetCoordinateList();
//            MapLocation mapLocation = new MapLocation();
//
//            for (Coordinate Coord : CoordsList) {
//                mapLocation.addCoordinate(new MapCoordinate(Coord.GetLatitudeString(), Coord.GetLongitudeString()));
//            }
//            myMapBean.addLocation(mapLocation);
//
//        }
//
//     //   RouteProvider RoutService = new RouteProvider();
//     //   List<Route> streets  =  RoutService.GetFullsRoadNetwork();
//
//     //   for(Route street : streets)
//     //   {
//     //       MapRoute route = new MapRoute();
//     //
//     //       for(Node node : street.GetRouteNodes())
//     //       {
//     //           route.addCoordinate(new MapCoordinate(node.GetCoordinate().GetLatitudeString(), node.GetCoordinate().GetLongitudeString()));
//     //       }
//     //
//     //       myMapBean.addRoute(route);
//     //   }
//
//
//        for (Transporter transporter : TransporterRepo.findAll())
//        {
//            MapMarker marker = new MapMarker(new MapCoordinate(transporter.GetPosition().GetLatitudeString(), transporter.GetPosition().GetLongitudeString()));
//            myMapBean.addMarker(marker);
//        }

    }


    public MapComponment()
    {
        GenerateMap();
    }


//    public Map UpdateMap()
//    {
//        GenerateMap();
//
//        //   for (Transporter transporter : VirtualTransporterManager.getInstance().GetTransporterWithJob())
//        //   {
//        //
//        //       Marker marker = new Marker(new MapCoordinate(transporter.GetPosition().GetLatitudeString(), transporter.GetPosition().GetLongitudeString()));
//        //          myMapBean.addMarker(marker);
//        //   }
//        myMapBean.setreloadAll(false);
//        return myMapBean;
//    }
//
//    public Map getMap() {
//        return myMapBean;
//    }

}
