package com.adtd.web.dataAccess;

public class NewTransporterDTO {

    private String label;
    private float maxPayload;
    private float battery;

    public void setLabel(String label) {
        this.label = label;
    }

    public void setBattery(float battery) {
        this.battery = battery;
    }

    public void setMaxPayload(float maxPayload) {
        this.maxPayload = maxPayload;
    }

    public String getLabel() {
        return label;
    }

    public float getMaxPayload() {
        return maxPayload;
    }

    public float getBattery() {
        return battery;
    }
}
