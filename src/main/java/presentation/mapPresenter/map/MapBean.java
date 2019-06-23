package presentation.mapPresenter.map;

import services.entity.Coordinate;
import services.entity.Location;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;




import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import presentation.mapPresenter.mapComponents.*;
import services.service.LocationCollection;

import static services.entity.LocatonType.GARAGE;
import static services.entity.LocatonType.PRODUCTION;

@ManagedBean(name = "mapBean")
@ViewScoped
public class MapBean implements Serializable
{

    private Map myMapBean = new Map();

    public MapBean()
    {
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


        MapLayer testMarker =(new MapLayer().setLabel("stest"));
        Marker marker = new Marker(new MapCoordinate("49.002646","12.096865"));
        testMarker.addMarker(marker);

        myMapBean.addLayer(testMarker);



        MapLayer routeLayer = (new MapLayer().setLabel("Route"));
        MapRoute route = new MapRoute();
        route.addCoordinate(new MapCoordinate("49.003150","12.096859"));   // endpoint depot
        route.addCoordinate(new MapCoordinate("49.003150","12.096730"));   // Kreuzung Leoprechtinger depot
        route.addCoordinate(new MapCoordinate("49.003002","12.096730"));
        route.addCoordinate(new MapCoordinate("49.002917","12.096728"));
        route.addCoordinate(new MapCoordinate("49.002864","12.096712"));
        route.addCoordinate(new MapCoordinate("49.002806","12.096669"));   // Kreuzung Leoprechtinger weg
        route.addCoordinate(new MapCoordinate("49.002771","12.096637"));
        route.addCoordinate(new MapCoordinate("49.002724","12.096578"));
        route.addCoordinate(new MapCoordinate("49.002680","12.096481"));
        route.addCoordinate(new MapCoordinate("49.002653","12.096387"));
        route.addCoordinate(new MapCoordinate("49.002636","12.096181"));
        route.addCoordinate(new MapCoordinate("49.002636","12.096041"));
        route.addCoordinate(new MapCoordinate("49.002622","12.095682"));   // Kreuzung StudiHaus - Musikpavillon
        route.addCoordinate(new MapCoordinate("49.002576","12.095684"));
        route.addCoordinate(new MapCoordinate("49.002581","12.095553"));   // endpoint SudiHaus

        routeLayer.addRoute(route);
        myMapBean.addLayer(routeLayer);


        MapLayer routeLayer2 = (new MapLayer().setLabel("Route"));
        MapRoute route2 = new MapRoute();
        route2.addCoordinate(new MapCoordinate("49.003150","12.096859"));   // endpoint depot
        route2.addCoordinate(new MapCoordinate("49.003150","12.096730"));   // Kreuzung Leoprechtinger depot
        route2.addCoordinate(new MapCoordinate("49.003002","12.096730"));
        route2.addCoordinate(new MapCoordinate("49.002917","12.096728"));
        route2.addCoordinate(new MapCoordinate("49.002864","12.096712"));
        route2.addCoordinate(new MapCoordinate("49.002806","12.096669"));   // Kreuzung Leoprechtinger weg
        route2.addCoordinate(new MapCoordinate("49.002771","12.096637"));
        route2.addCoordinate(new MapCoordinate("49.002724","12.096578"));
        route2.addCoordinate(new MapCoordinate("49.002680","12.096481"));
        route2.addCoordinate(new MapCoordinate("49.002653","12.096387"));
        route2.addCoordinate(new MapCoordinate("49.002636","12.096181"));
        route2.addCoordinate(new MapCoordinate("49.002636","12.096041"));
        route2.addCoordinate(new MapCoordinate("49.002622","12.095682"));   // Kreuzung StudiHaus - Musikpavillon
        route2.addCoordinate(new MapCoordinate("49.002666","12.095682"));
        route2.addCoordinate(new MapCoordinate("49.002666","12.095440"));
        route2.addCoordinate(new MapCoordinate("49.002666","12.095440"));
        route2.addCoordinate(new MapCoordinate("49.002743","12.095338"));
        route2.addCoordinate(new MapCoordinate("49.002778","12.095443"));
        route2.addCoordinate(new MapCoordinate("49.002960","12.095440"));
        route2.addCoordinate(new MapCoordinate("49.002967","12.095540"));
        route2.addCoordinate(new MapCoordinate("49.003012","12.095537"));   // endpoint Musikpavillon

        routeLayer2.addRoute(route2);
        myMapBean.addLayer(routeLayer2);


        MapLayer routeLayer3 = (new MapLayer().setLabel("Route"));
        MapRoute route3 = new MapRoute();
        route3.addCoordinate(new MapCoordinate("49.003150","12.096859"));   // endpoint depot
        route3.addCoordinate(new MapCoordinate("49.003150","12.096730"));   // Kreuzung Leoprechtinger depot
        route3.addCoordinate(new MapCoordinate("49.003354","12.096727"));   // Kreuzung Mensa
        route3.addCoordinate(new MapCoordinate("49.003360","12.095963"));
        route3.addCoordinate(new MapCoordinate("49.003387","12.095961"));   // endpoint Mensa

        routeLayer3.addRoute(route3);
        myMapBean.addLayer(routeLayer3);


        MapLayer routeLayer4 = (new MapLayer().setLabel("Route"));
        MapRoute route4 = new MapRoute();
        route4.addCoordinate(new MapCoordinate("49.003150","12.096859"));   // endpoint depot
        route4.addCoordinate(new MapCoordinate("49.003150","12.096730"));   // Kreuzung Leoprechtinger depot
        route4.addCoordinate(new MapCoordinate("49.003002","12.096730"));
        route4.addCoordinate(new MapCoordinate("49.002917","12.096728"));
        route4.addCoordinate(new MapCoordinate("49.002864","12.096712"));
        route4.addCoordinate(new MapCoordinate("49.002806","12.096669"));   // Kreuzung Leoprechtinger weg
        route4.addCoordinate(new MapCoordinate("49.002794","12.096704"));
        route4.addCoordinate(new MapCoordinate("49.002734","12.096725"));
        route4.addCoordinate(new MapCoordinate("49.002590","12.096755"));
        route4.addCoordinate(new MapCoordinate("49.002572","12.096859"));   // endpoint infogebaeude

        routeLayer4.addRoute(route4);
        myMapBean.addLayer(routeLayer4);


        MapLayer routeLayer5 = (new MapLayer().setLabel("Route"));
        MapRoute route5 = new MapRoute();
        route5.addCoordinate(new MapCoordinate("49.003150","12.096859"));   // endpoint depot
        route5.addCoordinate(new MapCoordinate("49.003150","12.096730"));   // Kreuzung Leoprechtinger depot
        route5.addCoordinate(new MapCoordinate("49.003354","12.096727"));   // Kreuzung Mensa
        route5.addCoordinate(new MapCoordinate("49.003456","12.096733"));
        route5.addCoordinate(new MapCoordinate("49.003637","12.096792"));
        route5.addCoordinate(new MapCoordinate("49.003644","12.097004"));   // endpoint


        routeLayer5.addRoute(route5);
        myMapBean.addLayer(routeLayer5);

    }

    public Map getMap() {
        return myMapBean;
    }
}
