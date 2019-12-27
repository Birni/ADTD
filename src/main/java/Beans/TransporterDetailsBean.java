package Beans;

import services.VO.ITransporter;
import services.entity.Transporter;
import services.service.VirtualTransporterManager;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="beanTransporterDetails")
@SessionScoped
public class TransporterDetailsBean{

    public long ID;
    public float payload;

    public float battery;

    private int lastindex;

    public long getID() {
        return ID;
    }

    public float getBattery() {
        return battery;
    }

    public float getPayload() {
        return payload;
    }

    public TransporterDetailsBean()
    {
        ITransporter transporter = VirtualTransporterManager.getInstance().GetTransporterFromTransporterList(0);
        SetBeanAttributes(transporter);
    }


    public void NextAction() {

        ITransporter transporter = VirtualTransporterManager.getInstance().GetTransporterFromTransporterList(lastindex);
        SetBeanAttributes(transporter);

    }

    private void SetBeanAttributes(ITransporter transporter)
    {
        if(null != transporter)
        {
            ID = ((Transporter) transporter.object).getId();
            payload = ((Transporter)transporter.object).getPayload();
            battery = ((Transporter)transporter.object).getBattery();

            lastindex = transporter.index;
        }
        else
        {
            // TODO: Handle no transporter at all
        }

    }

}