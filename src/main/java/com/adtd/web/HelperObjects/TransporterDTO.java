package com.adtd.web.HelperObjects;

/**
 * Class for the Transporter information
 *
 * @author  Matthias Birnthaler
 */
public class TransporterDTO {

    private String Label;
    private float maxPayload;
    private float battery;
    private float payload;
    private boolean hasJob;
    private String startDestination;
    private String targetDestination;

    public void setLabel(String label) {
        Label = label;
    }

    public void setMaxPayload(float maxPayload) {
        this.maxPayload = maxPayload;
    }

    public void setBattery(float battery) {
        //round to two decimal
        battery = battery * 100;
        battery = Math.round(battery);
        battery = battery / 100;
        this.battery = battery;
    }

    public void setPayload(float payload) {
        this.payload = payload;
    }

    public void setHasJob(boolean hasJob) {
        this.hasJob = hasJob;
    }

    public void setStartDestination(String startDestination) {
        this.startDestination = startDestination;
    }

    public void setTargetDestination(String targetDestination) {
        this.targetDestination = targetDestination;
    }

    public String getLabel() {
        return Label;
    }

    public float getPayload() {
        return payload;
    }

    public float getBattery() {
        return battery;
    }

    public boolean isHasJob() {
        return hasJob;
    }

    public float getMaxPayload() {
        return maxPayload;
    }

    public String getDestination() {
        return startDestination;
    }

    public String getStartDestination() {
        return startDestination;
    }

    public String getTargetDestination() {
        return targetDestination;
    }
}
