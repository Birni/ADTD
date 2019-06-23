package services.service;

import services.entity.Location;
import services.entity.LocatonType;
import services.entity.Coordinate;
import services.service.LocationCollection;


import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@ApplicationScoped
public class InitService
{

    @PersistenceContext(unitName="adtd_db")
    private EntityManager em;

    @Transactional
    public void init()
    {
        Location location = em.find(Location.class, "garage");
        if(location == null)
        {
           List<Coordinate> CoordsList = new ArrayList<>();
           CoordsList.add(new Coordinate(49.003428f ,12.096859f));
           CoordsList.add(new Coordinate(49.003432f ,12.097264f));
           CoordsList.add(new Coordinate(49.003071f ,12.097276f));
           CoordsList.add(new Coordinate(49.003066f ,12.096873f));
           location = new Location("garage","Garage", LocatonType.GARAGE, CoordsList);
           em.persist(location);
        }
        LocationCollection.addLocation(location);


        location = em.find(Location.class, "IM");
        if(location == null)
        {
            List<Coordinate> CoordsList = new ArrayList<>();
            CoordsList.add(new Coordinate(49.002643f ,12.096865f));
            CoordsList.add(new Coordinate(49.002664f ,12.098222f));
            CoordsList.add(new Coordinate(49.002177f ,12.098243f));
            CoordsList.add(new Coordinate(49.002160f ,12.096892f));
            location = new Location("IM","Fakultät Informatik und Mathematik", LocatonType.PRODUCTION, CoordsList);
            em.persist(location);
        }
        LocationCollection.addLocation(location);


        location = em.find(Location.class, "Studierendenhaus");
        if(location == null)
        {
            List<Coordinate> CoordsList = new ArrayList<>();
            CoordsList.add(new Coordinate(49.002633f ,12.095355f));
            CoordsList.add(new Coordinate(49.002635f ,12.095542f));
            CoordsList.add(new Coordinate(49.002481f ,12.095550f));
            CoordsList.add(new Coordinate(49.002479f ,12.095360f));
            location = new Location("Studierendenhaus","Studierendenhaus", LocatonType.PRODUCTION, CoordsList);
            em.persist(location);
        }
        LocationCollection.addLocation(location);


        location = em.find(Location.class, "Musikpavillon");
        if(location == null)
        {
            List<Coordinate> CoordsList = new ArrayList<>();
            CoordsList.add(new Coordinate(49.003262f ,12.095220f));
            CoordsList.add(new Coordinate(49.003271f ,12.095569f));
            CoordsList.add(new Coordinate(49.003021f ,12.095582f));
            CoordsList.add(new Coordinate(49.003015f ,12.095231f));
            location = new Location("Musikpavillon","Musikpavillon", LocatonType.PRODUCTION, CoordsList);
            em.persist(location);
        }
        LocationCollection.addLocation(location);


        location = em.find(Location.class, "Technik");
        if(location == null)
        {
            List<Coordinate> CoordsList = new ArrayList<>();
            CoordsList.add(new Coordinate(49.003955f ,12.097010f));
            CoordsList.add(new Coordinate(49.003958f ,12.097201f));
            CoordsList.add(new Coordinate(49.003508f ,12.097224f));
            CoordsList.add(new Coordinate(49.003505f ,12.097015f));
            location = new Location("Technik","Haus der Technik", LocatonType.PRODUCTION, CoordsList);
            em.persist(location);
        }
        LocationCollection.addLocation(location);

        location = em.find(Location.class, "Mensa");
        if(location == null)
        {
            List<Coordinate> CoordsList = new ArrayList<>();
            CoordsList.add(new Coordinate(49.003399f ,12.096229f));
            CoordsList.add(new Coordinate(49.003442f ,12.096199f));
            CoordsList.add(new Coordinate(49.003500f ,12.096186f));
            CoordsList.add(new Coordinate(49.003589f ,12.096215f));
            CoordsList.add(new Coordinate(49.003656f ,12.096213f));
            CoordsList.add(new Coordinate(49.003755f ,12.096154f));
            CoordsList.add(new Coordinate(49.003829f ,12.096049f));
            CoordsList.add(new Coordinate(49.003853f ,12.095985f));
            CoordsList.add(new Coordinate(49.003869f ,12.095915f));
            CoordsList.add(new Coordinate(49.003876f ,12.095867f));
            CoordsList.add(new Coordinate(49.003394f ,12.095800f));
            location = new Location("Mensa","Mensa", LocatonType.PRODUCTION, CoordsList);
            em.persist(location);
        }
        LocationCollection.addLocation(location);




    }

}
