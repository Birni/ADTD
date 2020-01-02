package com.adtd.web.entity;


import javax.persistence.*;

@Entity
public class NodeLink
{

    @Id
    private long NodeId;

    public NodeLink()
    {

    }

    public NodeLink(Node node)
    {
        NodeId = node.GetNodeId();
    }

    public long GetLinkId()
    {
        return NodeId;
    }


}
