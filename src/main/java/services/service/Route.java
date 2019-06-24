package services.service;

import services.entity.Node;


import java.util.ArrayList;
import java.util.List;

public class Route
{
    private List<Node> RouteNodes = new ArrayList<Node>();

    public Route()
    {

    }

    public List<Node> GetRouteNodes()
    {
        return RouteNodes;
    }

    public void addNode(Node node)
    {
        RouteNodes.add(node);
    }
}
