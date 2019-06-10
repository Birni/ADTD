package presentation.mapPresenter.map;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

import presentation.mapPresenter.mapComponents.*;


@ManagedBean(name = "mapBean")
@ViewScoped
public class MapBean implements Serializable
{
    private Map myMapBean = new Map();

    public MapBean()
    {
        Layer depotLayer = (new Layer().setLabel("production0"));
        Location depot = new Location();
        depot.addCoordinate(new Coordinate("49.003428","12.096859"));
        depot.addCoordinate(new Coordinate("49.003432","12.097264"));
        depot.addCoordinate(new Coordinate("49.003071","12.097276"));
        depot.addCoordinate(new Coordinate("49.003066","12.096873"));
        depotLayer.addLocation(depot);
        myMapBean.addLayer(depotLayer);


        Layer productionLayer_ = (new Layer().setLabel("production0"));
        Location production_ = new Location();
        production_.addCoordinate(new Coordinate("49.002643","12.096865"));
        production_.addCoordinate(new Coordinate("49.002664","12.098222"));
        production_.addCoordinate(new Coordinate("49.002177","12.098243"));
        production_.addCoordinate(new Coordinate("49.002160","12.096892"));
        productionLayer_.addLocation(production_);
        myMapBean.addLayer(productionLayer_);

        Layer productionLayer = (new Layer().setLabel("production"));
        Location production = new Location();
        production.addCoordinate(new Coordinate("49.002633","12.095355"));
        production.addCoordinate(new Coordinate("49.002635","12.095542"));
        production.addCoordinate(new Coordinate("49.002481","12.095550"));
        production.addCoordinate(new Coordinate("49.002479","12.095360"));
        productionLayer.addLocation(production);
        myMapBean.addLayer(productionLayer);

        Layer productionLayer1 = (new Layer().setLabel("production1"));
        Location production1 = new Location();
        production1.addCoordinate(new Coordinate("49.003262","12.095220"));
        production1.addCoordinate(new Coordinate("49.003271","12.095569"));
        production1.addCoordinate(new Coordinate("49.003021","12.095582"));
        production1.addCoordinate(new Coordinate("49.003015","12.095231"));
        productionLayer1.addLocation(production1);
        myMapBean.addLayer(productionLayer1);

        Layer productionLayer2 = (new Layer().setLabel("production1"));
        Location production2 = new Location();
        production2.addCoordinate(new Coordinate("49.003955","12.097010"));
        production2.addCoordinate(new Coordinate("49.003958","12.097201"));
        production2.addCoordinate(new Coordinate("49.003508","12.097224"));
        production2.addCoordinate(new Coordinate("49.003505","12.097015"));
        productionLayer2.addLocation(production2);
        myMapBean.addLayer(productionLayer2);

        Layer productionLayer3 = (new Layer().setLabel("production1"));
        Location production3 = new Location();
        production3.addCoordinate(new Coordinate("49.003399","12.096229"));
        production3.addCoordinate(new Coordinate("49.003442","12.096199"));
        production3.addCoordinate(new Coordinate("49.003500","12.096186"));
        production3.addCoordinate(new Coordinate("49.003589","12.096215"));
        production3.addCoordinate(new Coordinate("49.003656","12.096213"));
        production3.addCoordinate(new Coordinate("49.003755","12.096154"));
        production3.addCoordinate(new Coordinate("49.003829","12.096049"));
        production3.addCoordinate(new Coordinate("49.003853","12.095985"))   ;
        production3.addCoordinate(new Coordinate("49.003869","12.095915"));

        production3.addCoordinate(new Coordinate("49.003876","12.095867"));
        production3.addCoordinate(new Coordinate("49.003394","12.095800"));

        productionLayer3.addLocation(production3);
        myMapBean.addLayer(productionLayer3);


        Layer testMarker =(new Layer().setLabel("test"));
        Marker marker = new Marker(new Coordinate("49.002646","12.096865"));
        testMarker.addMarker(marker);

        myMapBean.addLayer(testMarker);



        Layer routeLayer = (new Layer().setLabel("Route"));
        Route route = new Route();
        route.addCoordinate(new Coordinate("49.003150","12.096859"));   // endpoint depot
        route.addCoordinate(new Coordinate("49.003150","12.096730"));   // Kreuzung Leoprechtinger depot
        route.addCoordinate(new Coordinate("49.003002","12.096730"));
        route.addCoordinate(new Coordinate("49.002917","12.096728"));
        route.addCoordinate(new Coordinate("49.002864","12.096712"));
        route.addCoordinate(new Coordinate("49.002806","12.096669"));   // Kreuzung Leoprechtinger weg
        route.addCoordinate(new Coordinate("49.002771","12.096637"));
        route.addCoordinate(new Coordinate("49.002724","12.096578"));
        route.addCoordinate(new Coordinate("49.002680","12.096481"));
        route.addCoordinate(new Coordinate("49.002653","12.096387"));
        route.addCoordinate(new Coordinate("49.002636","12.096181"));
        route.addCoordinate(new Coordinate("49.002636","12.096041"));
        route.addCoordinate(new Coordinate("49.002622","12.095682"));   // Kreuzung StudiHaus - Musikpavillon
        route.addCoordinate(new Coordinate("49.002576","12.095684"));
        route.addCoordinate(new Coordinate("49.002581","12.095553"));   // endpoint SudiHaus

        routeLayer.addRoute(route);
        myMapBean.addLayer(routeLayer);


        Layer routeLayer2 = (new Layer().setLabel("Route"));
        Route route2 = new Route();
        route2.addCoordinate(new Coordinate("49.003150","12.096859"));   // endpoint depot
        route2.addCoordinate(new Coordinate("49.003150","12.096730"));   // Kreuzung Leoprechtinger depot
        route2.addCoordinate(new Coordinate("49.003002","12.096730"));
        route2.addCoordinate(new Coordinate("49.002917","12.096728"));
        route2.addCoordinate(new Coordinate("49.002864","12.096712"));
        route2.addCoordinate(new Coordinate("49.002806","12.096669"));   // Kreuzung Leoprechtinger weg
        route2.addCoordinate(new Coordinate("49.002771","12.096637"));
        route2.addCoordinate(new Coordinate("49.002724","12.096578"));
        route2.addCoordinate(new Coordinate("49.002680","12.096481"));
        route2.addCoordinate(new Coordinate("49.002653","12.096387"));
        route2.addCoordinate(new Coordinate("49.002636","12.096181"));
        route2.addCoordinate(new Coordinate("49.002636","12.096041"));
        route2.addCoordinate(new Coordinate("49.002622","12.095682"));   // Kreuzung StudiHaus - Musikpavillon
        route2.addCoordinate(new Coordinate("49.002666","12.095682"));
        route2.addCoordinate(new Coordinate("49.002666","12.095440"));
        route2.addCoordinate(new Coordinate("49.002666","12.095440"));
        route2.addCoordinate(new Coordinate("49.002743","12.095338"));
        route2.addCoordinate(new Coordinate("49.002778","12.095443"));
        route2.addCoordinate(new Coordinate("49.002960","12.095440"));
        route2.addCoordinate(new Coordinate("49.002967","12.095540"));
        route2.addCoordinate(new Coordinate("49.003012","12.095537"));   // endpoint Musikpavillon

        routeLayer2.addRoute(route2);
        myMapBean.addLayer(routeLayer2);


        Layer routeLayer3 = (new Layer().setLabel("Route"));
        Route route3 = new Route();
        route3.addCoordinate(new Coordinate("49.003150","12.096859"));   // endpoint depot
        route3.addCoordinate(new Coordinate("49.003150","12.096730"));   // Kreuzung Leoprechtinger depot
        route3.addCoordinate(new Coordinate("49.003354","12.096727"));   // Kreuzung Mensa
        route3.addCoordinate(new Coordinate("49.003360","12.095963"));
        route3.addCoordinate(new Coordinate("49.003387","12.095961"));   // endpoint Mensa

        routeLayer3.addRoute(route3);
        myMapBean.addLayer(routeLayer3);


        Layer routeLayer4 = (new Layer().setLabel("Route"));
        Route route4 = new Route();
        route4.addCoordinate(new Coordinate("49.003150","12.096859"));   // endpoint depot
        route4.addCoordinate(new Coordinate("49.003150","12.096730"));   // Kreuzung Leoprechtinger depot
        route4.addCoordinate(new Coordinate("49.003002","12.096730"));
        route4.addCoordinate(new Coordinate("49.002917","12.096728"));
        route4.addCoordinate(new Coordinate("49.002864","12.096712"));
        route4.addCoordinate(new Coordinate("49.002806","12.096669"));   // Kreuzung Leoprechtinger weg
        route4.addCoordinate(new Coordinate("49.002794","12.096704"));
        route4.addCoordinate(new Coordinate("49.002734","12.096725"));
        route4.addCoordinate(new Coordinate("49.002590","12.096755"));
        route4.addCoordinate(new Coordinate("49.002572","12.096859"));   // endpoint infogebaeude

        routeLayer4.addRoute(route4);
        myMapBean.addLayer(routeLayer4);


        Layer routeLayer5 = (new Layer().setLabel("Route"));
        Route route5 = new Route();
        route5.addCoordinate(new Coordinate("49.003150","12.096859"));   // endpoint depot
        route5.addCoordinate(new Coordinate("49.003150","12.096730"));   // Kreuzung Leoprechtinger depot
        route5.addCoordinate(new Coordinate("49.003354","12.096727"));   // Kreuzung Mensa
        route5.addCoordinate(new Coordinate("49.003456","12.096733"));
        route5.addCoordinate(new Coordinate("49.003637","12.096792"));
        route5.addCoordinate(new Coordinate("49.003644","12.097004"));   // endpoint


        routeLayer5.addRoute(route5);
        myMapBean.addLayer(routeLayer5);

    }

    public Map getMap() {
        return myMapBean;
    }
}
