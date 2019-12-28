package services.service;

import services.entity.*;
import services.service.LocationCollection;


import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;


@ApplicationScoped
public class InitService
{

    @PersistenceContext(unitName="adtd_db")
    private EntityManager em;

    @Transactional
    public void init()
    {

        //////////////////////////////////////////////////////////////////////////
        ///                Begin Initialization Locations                      ///
        //////////////////////////////////////////////////////////////////////////

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

        //////////////////////////////////////////////////////////////////////////
        ///                End Initialization Locations                        ///
        //////////////////////////////////////////////////////////////////////////

        //////////////////////////////////////////////////////////////////////////
        ///                Begin Initialization Nodes                          ///
        //////////////////////////////////////////////////////////////////////////

        TypedQuery<Node> query = em.createQuery("SELECT node FROM Node AS node", Node.class);
        List<Node> nodeCollection =  query.getResultList();

        if(nodeCollection.isEmpty())
        {
            Node node1  = new Node(1L, (new Coordinate(49.003150f ,12.096859f))); // Endpoint Garage
            Node node2  = new Node(2L, (new Coordinate(49.003150f ,12.096730f))); // Kreuzung vor Maschienenbau
            Node node3  = new Node(3L, (new Coordinate(49.003002f ,12.096730f)));
            Node node4  = new Node(4L, (new Coordinate(49.002917f ,12.096728f)));
            Node node5  = new Node(5L, (new Coordinate(49.002864f ,12.096712f)));
            Node node6  = new Node(6L, (new Coordinate(49.002806f ,12.096669f)));
            Node node7  = new Node(7L, (new Coordinate(49.002806f ,12.096669f))); // Kreuzung Leoprechtinger zu IM
            Node node8  = new Node(8L, (new Coordinate(49.002771f ,12.096637f)));
            Node node9  = new Node(9L, (new Coordinate(49.002724f ,12.096578f)));
            Node node10 = new Node(10L,(new Coordinate(49.002680f ,12.096481f)));
            Node node11 = new Node(11L,(new Coordinate(49.002653f ,12.096387f)));
            Node node12 = new Node(12L,(new Coordinate(49.002636f ,12.096181f)));
            Node node13 = new Node(13L,(new Coordinate(49.002636f ,12.096041f)));
            Node node14 = new Node(14L,(new Coordinate(49.002622f ,12.095682f))); // Kreuzung StudiHaus - Musikpavillon
            Node node15 = new Node(15L,(new Coordinate(49.002576f ,12.095684f)));
            Node node16 = new Node(16L,(new Coordinate(49.002581f ,12.095553f))); // Endpoint StudiHaus

            Node node17 = new Node(17L,(new Coordinate(49.002666f ,12.095682f))); // startet bei Kreuzung StudiHaus - Musikpavillon
            Node node18 = new Node(18L,(new Coordinate(49.002666f ,12.095440f)));
            Node node19 = new Node(19L,(new Coordinate(49.002743f ,12.095338f)));
            Node node20 = new Node(20L,(new Coordinate(49.002778f ,12.095443f)));
            Node node21 = new Node(21L,(new Coordinate(49.002960f ,12.095440f)));
            Node node22 = new Node(22L,(new Coordinate(49.002967f ,12.095540f)));
            Node node23 = new Node(23L,(new Coordinate(49.003012f ,12.095537f))); // Endpoint Musikpavillon

            Node node24 = new Node(24L,(new Coordinate(49.003354f ,12.096727f))); // startet bei Kreuzung vor Maschienenbau, Kreuzung vor Mensa
            Node node25 = new Node(25L,(new Coordinate(49.003360f ,12.095963f)));
            Node node26 = new Node(26L,(new Coordinate(49.003387f ,12.095961f))); // Endpoint Mensa

            Node node27 = new Node(27L,(new Coordinate(49.002794f ,12.096704f))); // startet Kreuzung Leoprechtinger zu IM
            Node node28 = new Node(28L,(new Coordinate(49.002734f ,12.096725f)));
            Node node29 = new Node(29L,(new Coordinate(49.002590f ,12.096755f)));
            Node node30 = new Node(30L,(new Coordinate(49.002572f ,12.096859f))); // Endpoint IM

            Node node31 = new Node(31L,(new Coordinate(49.003456f ,12.096733f))); // startet Kreuzung vor Mensa
            Node node32 = new Node(32L,(new Coordinate(49.003637f ,12.096792f)));
            Node node33 = new Node(33L,(new Coordinate(49.003644f ,12.097004f))); // Endpoint Technik

            node1.SetIdentifierLocation("Garage");
            node16.SetIdentifierLocation("Studierendenhaus");
            node23.SetIdentifierLocation("Musikpavillon");
            node26.SetIdentifierLocation("Mensa");
            node33.SetIdentifierLocation("Technik");

            node1.addLink(node2);

            node2.addLink(node1);
            node2.addLink(node3);
            node2.addLink(node24);

            node3.addLink(node2);
            node3.addLink(node4);

            node4.addLink(node3);
            node4.addLink(node5);

            node5.addLink(node4);
            node5.addLink(node6);

            node6.addLink(node5);
            node6.addLink(node7);

            node7.addLink(node6);
            node7.addLink(node8);
            node7.addLink(node27);

            node8.addLink(node7);
            node8.addLink(node9);

            node9.addLink(node8);
            node9.addLink(node10);

            node10.addLink(node9);
            node10.addLink(node11);

            node11.addLink(node10);
            node11.addLink(node12);

            node12.addLink(node11);
            node12.addLink(node13);

            node13.addLink(node12);
            node13.addLink(node14);

            node14.addLink(node13);
            node14.addLink(node15);
            node14.addLink(node17);

            node15.addLink(node14);
            node15.addLink(node16);

            node16.addLink(node15);

            node17.addLink(node14);
            node17.addLink(node18);

            node18.addLink(node17);
            node18.addLink(node19);

            node19.addLink(node18);
            node19.addLink(node20);

            node20.addLink(node19);
            node20.addLink(node21);

            node21.addLink(node20);
            node21.addLink(node22);

            node22.addLink(node21);
            node22.addLink(node23);

            node23.addLink(node22);

            node24.addLink(node2);
            node24.addLink(node25);
            node24.addLink(node31);

            node25.addLink(node24);
            node25.addLink(node26);

            node26.addLink(node25);

            node27.addLink(node7);
            node27.addLink(node28);

            node28.addLink(node27);
            node28.addLink(node29);

            node29.addLink(node28);
            node29.addLink(node30);

            node30.addLink(node29);

            node31.addLink(node24);
            node31.addLink(node32);

            node32.addLink(node31);
            node32.addLink(node33);

            node33.addLink(node32);

            em.persist(node1);
            em.persist(node2);
            em.persist(node3);
            em.persist(node4);
            em.persist(node5);
            em.persist(node6);
            em.persist(node7);
            em.persist(node8);
            em.persist(node9);
            em.persist(node10);
            em.persist(node11);
            em.persist(node12);
            em.persist(node13);
            em.persist(node14);
            em.persist(node15);
            em.persist(node16);
            em.persist(node17);
            em.persist(node18);
            em.persist(node19);
            em.persist(node20);
            em.persist(node21);
            em.persist(node22);
            em.persist(node23);
            em.persist(node24);
            em.persist(node25);
            em.persist(node26);
            em.persist(node27);
            em.persist(node28);
            em.persist(node29);
            em.persist(node30);
            em.persist(node31);
            em.persist(node32);
            em.persist(node33);

            nodeCollection =  query.getResultList();
        }

        NodeCollection.getInstance().addNodeCollection(nodeCollection);

        //////////////////////////////////////////////////////////////////////////
        ///                End Initialization Nodes                            ///
        //////////////////////////////////////////////////////////////////////////

        //////////////////////////////////////////////////////////////////////////
        ///               Begin Initialization Transporter                     ///
        //////////////////////////////////////////////////////////////////////////

        TypedQuery<Transporter> queryt = em.createQuery("SELECT transporter FROM Transporter AS transporter", Transporter.class);
        List<Transporter> transporterCollection =  queryt.getResultList();

        if(transporterCollection.isEmpty())
        {
            for(int i=1; i < 11; i++)
            {
                Transporter transporter = new Transporter("R-OTH-"+i, (new Coordinate(49.003150f ,12.096859f)));
                transporter.setBattery(100);

                Random r = new Random();
                transporter.setMaxPayload(r.nextInt(40) + 10);



                em.persist(transporter);

                transporterCollection =  queryt.getResultList();
            }

        }

        VirtualTransporterManager.getInstance().AddTransporterList(transporterCollection);

        //////////////////////////////////////////////////////////////////////////
        ///              End Initialization Transporter                        ///
        //////////////////////////////////////////////////////////////////////////


    }

}
