package services.entity;

import services.entity.util.GeneratedIdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class NodeLink extends GeneratedIdEntity
{
    @Column
    Long NodeId;

    public NodeLink()
    {

    }

    public NodeLink(Node node)
    {
        NodeId = node.getId();
    }

    public Long GetLinkId()
    {
        return NodeId;
    }


}
