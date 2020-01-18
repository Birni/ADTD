package com.adtd.web.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity Location
 *
 * @author  Matthias Birnthaler
 */
@Entity
public class Location
{
    @Id
    private String id;
    private String Name;
    private LocatonType Type;
    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL}, orphanRemoval=true)
    private List<Coordinate> CoordinateList = new ArrayList<>();
    private long RoadConnection;


    public Location()
    {
    }


    public Location(String id, String name, LocatonType type, List<Coordinate> list )
    {
        this.id = id;
        this.Name = name;
        this.Type = type;

        if(null != list)
        {
            this.CoordinateList.addAll(list);
        }
    }

    public Location (String name, LocatonType type)
    {
        this.Name = name;
        this.Type = type;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String GetName()
    {
        return Name;
    }

    public LocatonType GetLocatonType()
    {
        return Type;
    }

    public List<Coordinate> GetCoordinateList()
    {
        return CoordinateList;
    }

    public void addCoordinatList(List<Coordinate> list)
    {
        this.CoordinateList = list;
    }

    public void setRoadConnection(long nodeId){
        this.RoadConnection = nodeId;
    }

    public long getRoadConnection() {
        return RoadConnection;
    }
}
