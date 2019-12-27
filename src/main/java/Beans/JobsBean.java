package Beans;



import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import services.entity.Location;
import services.service.LocationCollection;
import services.service.VirtualTransporterManager;

import java.util.List;

@ManagedBean(name="beanJobs")
@SessionScoped
public class JobsBean {


    private String Target;
    private Target[] TargetList;

    public JobsBean()
    {
        List<Location> list = LocationCollection.getInstance().getLocations();

        TargetList = new Target[list.size()];

        for(int i =0; i < list.size(); i++)
        {
            TargetList[i] =new Target(list.get(i).GetName(), list.get(i).getLocationId());

        }


    }

    public void SendTransporter()
    {
        VirtualTransporterManager.getInstance().SendTransporter(Target);
    }

    public String getTarget(){
        return Target;
    }

    public void setTarget(String target){
        this.Target =target;
    }

    public Target[] getTargetList() {
        return  TargetList;
    }


    public  class Target {
        public String TargetLabel;
        public String TargetValue;


        public Target(String targetLabel, String targetValue){
            this.TargetLabel = targetLabel;
            this.TargetValue = targetValue;
        }

        public String getTargetLabel(){
            return TargetLabel;
        }

        public String getTargetValue(){
            return TargetValue;
        }


    }


}