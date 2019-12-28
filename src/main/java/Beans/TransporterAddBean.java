package Beans;

import services.service.VirtualTransporterManager;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="beanTransporterAdd")
@SessionScoped
public class TransporterAddBean {

    private String label;
    private float battery;

    public void setLabel(String label) {
        this.label = label;
    }

    public void setBattery(float battery)
    {
        this.battery = battery;
    }

    public String getLabel() {
        return label;
    }

    public float getBattery() {
        return battery;
    }



    public void AddAction() {

        VirtualTransporterManager.getInstance().AddNewTransporter(battery);
    }




}