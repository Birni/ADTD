package services.entity;

import services.entity.util.GeneratedIdEntity;
import services.entity.util.LongIdEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Node extends LongIdEntity
{

    @OneToOne
    private Coordinate Coordinate;
    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    private List<Node> LinkList = new ArrayList<Node>();

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
        this.LinkList.add(node);
    }

    public List<Node> getLinkList()
    {
        return LinkList;
    }
}
