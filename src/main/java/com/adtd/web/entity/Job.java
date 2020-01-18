package com.adtd.web.entity;

import com.adtd.web.entity.Node;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.*;


/**
 * Entity NodeLink
 * NodeLinks link Nodes to a street network
 *
 * @author  Matthias Birnthaler
 */
@Embeddable
public class Job
{

    private long NodeStartID;
    private long NodeTargetID;
    private float JobPayload;
    @ManyToMany
    @OrderColumn
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Node> RouteNodes = new ArrayList<Node>();

    public Job()
    {

    }


    public void setNodeTargetID(long nodeTargetID) {
        NodeTargetID = nodeTargetID;
    }

    public void setNodeStartID(long nodeStartID) {
        NodeStartID = nodeStartID;
    }

    public void setRouteNodes(List<Node> routeNodes) {
        RouteNodes = routeNodes;
    }

    public void setSingleNode(Node node){
        this.RouteNodes.add(node);
    }

    public void setJobPayload(float jobPayload) {
        JobPayload = jobPayload;
    }

    public void addRouteNodes(List<Node> routeNodes) {
        this.RouteNodes.addAll(routeNodes);
    }

    public long getNodeTargetID() {
        return NodeTargetID;
    }

    public long getNodeStartID() {
        return NodeStartID;
    }

    public long getTargetNode() {
        return NodeTargetID;
    }

    public List<Node> getRouteNodes() {
        return RouteNodes;
    }

    public float getJobPayload() {
        return JobPayload;
    }
}
