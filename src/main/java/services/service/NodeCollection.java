package services.service;

import services.entity.Node;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NodeCollection
{

    private static NodeCollection instance;

    private Collection<Node> CollectionOfNodes = new ArrayList<Node>();

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

    public void addNodeCollection(Collection collection)
    {
        CollectionOfNodes = collection;
    }
}
