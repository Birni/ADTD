package com.adtd.web.entity;


import javax.persistence.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Node
{
    @Id
    private long id;
    @OneToOne(cascade = {CascadeType.ALL})
    private Coordinate Coordinate;
    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    private List<NodeLink> LinkList = new ArrayList<>();
    private String IdentifierLocation ="default";

    public Node()
    {

    }

    public long getId(){
        return this.id;
    }


    public Node(Long id, Coordinate Coordinate)
    {
        this.id = id;
        this.Coordinate = Coordinate;
    }

    public Node(long id, float Latitude, float Longitude)
    {
        this.id  = id;
        Coordinate coordinate = new Coordinate( Latitude,Longitude );
        this.Coordinate = coordinate;
    }

    public long GetNodeId()
    {
        return this.id;
    }

    public Coordinate GetCoordinate()
    {
        return Coordinate;
    }


    public void addLink(Node node)
    {
        NodeLink link = new NodeLink(node);
        this.LinkList.add(link);
    }

    public List<NodeLink> getLinkList()
    {
        return LinkList;
    }

    public String GetIdentifierLocation()
    {
        return IdentifierLocation;
    }

    public int GetNumOfLinks()
    {
        return LinkList.size();
    }

    public void SetIdentifierLocation(String LocationId)
    {
        this.IdentifierLocation = LocationId;
    }

}
