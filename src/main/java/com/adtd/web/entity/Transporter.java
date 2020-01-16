package com.adtd.web.entity;



import javax.persistence.*;

/**
 * Entity Transporter
 *
 * @author  Matthias Birnthaler
 */
@Entity
public class Transporter
{
    @Id
    private String Label;
    private float maxPayload;
    private float battery;
    private float payload;
    private boolean hasJob = false;

    @OneToOne(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    private Node Position;

    @Embedded
    private Job job = new Job();


    public Transporter()
    {

    }

    public Transporter(String label)
    {
        this.Label = label;
    }

    public Transporter(String label, Node positon)
    {
        this.Label = label;
        this.Position = positon;
    }

    public Transporter(String label, float battery, float maxPayload)
    {
        this.Label = label;
        this.battery = battery;
        this.maxPayload = maxPayload;
    }


    public String getLabel(){
        return Label;
    }

    public void setLabel(String label){
        this.Label = label;
    }

    public float getMaxPayload(){
        return maxPayload;
    }

    public void setMaxPayload(float maxPayload){
        this.maxPayload = maxPayload;
    }

    public void setBattery(float battery)
    {
        this.battery = battery;
    }

    public float getBattery()
    {
        return this.battery;
    }

    public void setPayload(float payload)
    {
        this.payload = payload;
    }

    public void setPosition(Node position){
        this.Position = position;
    }

    public float getPayload()
    {
        return this.payload;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Job getJob() {
        return job;
    }

    public boolean isHasJob()
    {
        return this.hasJob;
    }

    public Node GetPosition()
    {
        return this.Position;
    }

    public void setHasJob( boolean isHasJob){
        this.hasJob = isHasJob;
    }

}
