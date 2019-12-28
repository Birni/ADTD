package Beans;

import services.entity.Transporter;
import services.service.VirtualTransporterManager;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name="beanTransporterDetails")
@SessionScoped
public class TransporterDetailsBean{

    private List<ITransporter> iTransporters = new ArrayList<ITransporter>();





    public TransporterDetailsBean()
    {
        List<Transporter> transporters =  VirtualTransporterManager.getInstance().GetAllTransporter();

        for(int i =0; i <transporters.size(); i++)
        {
            SetBeanAttributes(transporters.get(i));
        }

    }


    public void NextAction() {

    }

    public  List<ITransporter> getiTransporters(){
        return this.iTransporters;
    }

    private void SetBeanAttributes(Transporter transporter) {

        ITransporter iTransporter = new ITransporter();

        iTransporter.setLabel(transporter.getLabel());
        iTransporter.setBattery(transporter.getBattery());
        iTransporter.setIsExecuteJob(transporter.isHasJob());
        iTransporter.setMaxPayload(transporter.getMaxPayload());
        iTransporter.setPayload(transporter.getPayload());


        if (transporter.isHasJob())
        {
            iTransporter.setTargetToDrive(transporter.getTarget().GetIdentifierLocation());
        } else {
            iTransporter.setTargetToDrive("none");
        }

        iTransporters.add(iTransporter);

    }

    public class ITransporter{

        private String label;
        private float payload;
        private float battery;
        private float maxPayload;
        private boolean isExecuteJob;
        private String targetToDrive;

        public String getLabel() {
            return label;
        }

        public void setLabel(String label){
            this.label = label;
        }

        public float getMaxPayload() {
            return maxPayload;
        }

        public void setMaxPayload(float maxPayload){
            this.maxPayload = maxPayload;
        }

        public boolean getIsExecuteJob(){
            return isExecuteJob;
        }

        public void setIsExecuteJob (boolean isExecuteJob){
            this.isExecuteJob = isExecuteJob;
        }

        public String getTargetToDrive() {
            return targetToDrive;
        }

        public void setTargetToDrive(String targetToDrive){
            this.targetToDrive =targetToDrive;
        }

        public float getBattery() {
            return battery;
        }

        public void setBattery(float battery) {
            this.battery = battery;
        }

        public float getPayload() {
            return payload;
        }

        public void setPayload(float payload){
            this.payload =payload;
        }

    }

}