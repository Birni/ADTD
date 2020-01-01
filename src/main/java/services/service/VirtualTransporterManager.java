package services.service;

import services.entity.Node;
import services.entity.Transporter;

import javax.ejb.Schedule;
import javax.ejb.Startup;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;

@Singleton
@Startup




public class VirtualTransporterManager {

    @PersistenceContext(unitName="adtd_db")
    private EntityManager em;

    private static VirtualTransporterManager instance;

    static private List<Transporter> TransporterCollection = new ArrayList<Transporter>();

    private VirtualTransporterManager() {

    }

    public static VirtualTransporterManager getInstance() {
        if (null == VirtualTransporterManager.instance) {
            VirtualTransporterManager.instance = new VirtualTransporterManager();
        }
        return VirtualTransporterManager.instance;
    }

    public void AddJob(Node target) {
        RouteProvider RoutService = new RouteProvider();
        Route route = RoutService.GetRoute(NodeCollection.getInstance().GetNodeById(1L), NodeCollection.getInstance().GetNodeById(23L));

        TransporterCollection.get(0).AddJob(target, route);

    }


    public void AddTransporterList(List<Transporter> transporter) {
        this.TransporterCollection = transporter;

        AddJob(NodeCollection.getInstance().GetNodeById(23L));
    }

    public List<Transporter> GetAllTransporter(){
        return this.TransporterCollection;
    }

    public void UpdateTransporter() {
        for (Transporter transporter : TransporterCollection) {
            transporter.PropagateNewPostion(1);
        }

    }

    public List<Transporter> GetTransporterWithJob() {
        List<Transporter> TransporterWithJob = new ArrayList<>();

        for (Transporter transporter : TransporterCollection) {
            if (transporter.isHasJob()) {
                TransporterWithJob.add(transporter);
            }

        }
        return TransporterWithJob;
    }

    @Schedule(second ="*/1" ,minute = "*", hour = "*", persistent = false)
      public void atSchedule(){
        UpdateTransporter();

    //   String refreshpage = FacesContext.getCurrentInstance().getViewRoot().getViewId();
    //   ViewHandler handler = FacesContext.getCurrentInstance().getApplication().getViewHandler();
    //   UIViewRoot root = handler.createView(FacesContext.getCurrentInstance(), refreshpage);
    //   root.setViewId(refreshpage);
    //   FacesContext.getCurrentInstance().setViewRoot(root);

    //   FacesContext.getCurrentInstance().getViewRoot().setViewId("map");
    //   FacesContext.getCurrentInstance().renderResponse();

     }



    public void AddNewTransporter(float battery )
    {
        Transporter transporter= new Transporter();

        transporter.setBattery(battery);


        TransporterCollection.add(transporter);

      //  em.persist(transporter);

    }

    public void SendTransporter(String NameOfLocation )
    {

        Node target = NodeCollection.getInstance().GetSpecialNodeByName(NameOfLocation);

        if (null != target)
        {
            AddJob(target);
        }
    }

    public int getNumOfTransporter(boolean WithJobsOnly)
    {
        if(WithJobsOnly)
        {
            int count =0;
            for(Transporter transporter : TransporterCollection)
            {
                if(transporter.isHasJob())
                {
                    count++;
                }
            }
            return count;

        }
        else
        {
            return TransporterCollection.size();
        }
    }
}