package com.adtd.web.route;

import com.adtd.web.entity.Node;

import java.util.ArrayList;
import java.util.List;



public class Route
{
    private int NextTargetToDrive = 0;
    private List<Node> RouteNodes = new ArrayList<Node>();

    public Route()
    {

    }

    public int GetNextTargetToDrive()
    {
        return this.NextTargetToDrive;
    }
    public void SetNextTargetToDrive(int next)
    {
        this.NextTargetToDrive = next;
    }

    public void IncrementNextTargetToDrive( )
    {
        this.NextTargetToDrive ++;
    }

    public List<Node> GetRouteNodes()
    {
        return RouteNodes;
    }

    public void addNode(Node node)
    {
        RouteNodes.add(node);
    }

    public void addNodes(List<Node> nodes)
    {
        RouteNodes = nodes;
    }
}
