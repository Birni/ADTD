package com.adtd.web.entity;


import javax.persistence.*;

@Entity
public class NodeLink
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long LinkId;

    private long NodeId;

    public NodeLink()
    {

    }

    public NodeLink(Node node)
    {
        NodeId = node.GetNodeId();
    }

    public long GetLinkedNode()
    {
        return NodeId;
    }


}
