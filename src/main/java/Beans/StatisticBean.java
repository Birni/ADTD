package Beans;

import services.service.VirtualTransporterManager;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="beanStatistic")
@SessionScoped
public class StatisticBean {

    private int NumTransporter;
    private int NumTransporterWithJobs;
    private int AvailableTransporter;



    public StatisticBean()
    {
        NumTransporter = VirtualTransporterManager.getInstance().getNumOfTransporter(false);
        NumTransporterWithJobs = VirtualTransporterManager.getInstance().getNumOfTransporter(true);
        AvailableTransporter = NumTransporter+ NumTransporterWithJobs;

    }

    public int GetNumTransporter()
    {
        return NumTransporter;
    }

    public int GetNumTransporterWithJobs()
    {
        return NumTransporterWithJobs;
    }

    public int GetAvailableTransporter()
    {
        return AvailableTransporter;
    }

}
