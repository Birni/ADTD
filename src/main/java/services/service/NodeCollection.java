package services.service;

import services.entity.Node;

import javax.ejb.Singleton;
import java.util.*;


public class NodeCollection
{

     static NodeCollection instance;

     private Map<Long, Node> CollectionOfNodes = new HashMap<>();
     private Map<Long, Node> CollectionOfSpecialNodes = new HashMap<>();; // Endpoints to Locations


    private NodeCollection()
    {

    }

    public static NodeCollection getInstance()
    {
        if(null == NodeCollection.instance)
        {
            NodeCollection.instance = new NodeCollection();
        }
        return NodeCollection.instance;
    }

    public void addNodeCollection(List<Node> collection)
    {
        for(int i = 0; i < collection.size(); i++)
        {
            CollectionOfNodes.putIfAbsent( collection.get(i).getId(), collection.get(i));

            if( "default" == collection.get(i).GetIdentifierLocation())
            {
                CollectionOfSpecialNodes.putIfAbsent( collection.get(i).getId(), collection.get(i));
            }
        }
    }

    public Map<Long, Node> getCollectionOfNodes()
    {
        Map<Long, Node> collection =  new HashMap<>();
        collection = CollectionOfNodes;
        return collection;
    }

    public Map<Long, Node> getCollectionOfSpecialNodes()
    {
        Map<Long, Node> collection =  new HashMap<>();
        collection = CollectionOfSpecialNodes;
        return collection;

    }

    public Node GetNodeById(Long id)
    {
        Node node = new Node();
        node = CollectionOfNodes.get(id);
        return node;
    }

}
