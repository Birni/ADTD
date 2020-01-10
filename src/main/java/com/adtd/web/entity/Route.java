package com.adtd.web.entity;

import com.adtd.web.entity.Node;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.*;



@Embeddable
public class Route
{

    public long NodeStartID;
    public long NodeTargetID;
    //@OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    @OneToMany(cascade = {CascadeType.ALL})
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Node> RouteNodes = new ArrayList<Node>();

    public Route()
    {

    }


    public void setNodeTargetID(long nodeTargetID) {
        NodeTargetID = nodeTargetID;
    }

    public void setNodeStartID(long nodeStartID) {
        NodeStartID = nodeStartID;
    }

    public long getNodeTargetID() {
        return NodeTargetID;
    }

    public long getNodeStartID() {
        return NodeStartID;
    }

    public void setRouteNodes(List<Node> routeNodes) {
        RouteNodes = routeNodes;
    }

    public long getTargetNode() {
        return NodeTargetID;
    }

    public List<Node> getRouteNodes() {
        return RouteNodes;
    }

    public void setSingleNode(Node node){
        this.RouteNodes.add(node);
    }

    public void addRouteNodes(List<Node> routeNodes) {
        this.RouteNodes.addAll(routeNodes);
    }

}
