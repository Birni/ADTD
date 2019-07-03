package services.entity;

import org.hibernate.metamodel.relational.Identifier;
import services.entity.util.GeneratedIdEntity;
import services.entity.util.LongIdEntity;
import javax.persistence.Entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Node extends LongIdEntity
{

    @OneToOne(cascade = {CascadeType.ALL})
    private Coordinate Coordinate;
    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    private List<NodeLink> LinkList = new ArrayList<>();
    private String IdentifierLocation ="default";

    public Node()
    {

    }

    public Node(Long Id)
    {
        super(Id);
    }


    public Node(Long id, Coordinate Coordinate)
    {
        super(id);
        this.Coordinate = Coordinate;
    }

    public Node(Long id, float Latitude, float Longitude)
    {
        super(id);
        Coordinate coordinate = new Coordinate( Latitude,Longitude );
        this.Coordinate = coordinate;
    }

    public Long GetNodeId()
    {
        return getId();
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
