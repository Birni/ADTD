package Beans;

import services.VO.ITransporter;
import services.entity.Transporter;
import services.service.VirtualTransporterManager;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="beanTransporterDetails")
@SessionScoped
public class TransporterDetailsBean{


    private float payload;
    private String label;
    private float battery;
    private float maxPayload;
    private boolean isExecuteJob;
    private String targetToDrive;

    private int lastindex;

    public String getLabel() {
        return label;
    }

    public float getMaxpayload() {
        return maxPayload;
    }

    public boolean getIsExecuteJob(){
        return isExecuteJob;
    }

    public String getTargetToDrive() {
        return targetToDrive;
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
            label = ((Transporter) transporter.object).getLabel();
            payload = ((Transporter)transporter.object).getPayload();
            battery = ((Transporter)transporter.object).getBattery();
            maxPayload = ((Transporter)transporter.object).getMaxPayload();
            isExecuteJob = ((Transporter)transporter.object).isHasJob();

            if(((Transporter)transporter.object).isHasJob())
            {
                targetToDrive = ((Transporter)transporter.object).getTarget().GetIdentifierLocation();
            }
            else
            {
                targetToDrive = "none";
            }

            lastindex = transporter.index;
        }
        else
        {
            // TODO: Handle no transporter at all
        }

    }

}