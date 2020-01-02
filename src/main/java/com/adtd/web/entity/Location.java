package com.adtd.web.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Location
{
    @Id
    private String id;
    private String Name;
    private LocatonType Type;
    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    private List<Coordinate> CoordinateList = new ArrayList<>();


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
            for(Coordinate coordinate : list)
            {
                this.CoordinateList.add(coordinate);
            }
        }
    }

    public Location (String name, LocatonType type)
    {
        this.Name = name;
        this.Type = type;
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

}