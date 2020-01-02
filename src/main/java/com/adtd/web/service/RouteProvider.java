package com.adtd.web.service;




import com.adtd.web.entity.Location;
import com.adtd.web.entity.Node;
import com.adtd.web.entity.NodeLink;
import com.adtd.web.repository.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;


public class RouteProvider
{
    @Autowired
    private NodeRepository NodeRepo;


    public RouteProvider()
    {

    }

    public Route GetRoute(Node startingNode, Node endNode )
    {
        Iterable<Node> tempNodes = NodeRepo.findAll();

        Map<Long, Node> checkedNodes = new HashMap<>();
        List<Long> CrossNodeId = new ArrayList<>();
        List<Node> RouteNodes = new ArrayList<>();

        Node currentNode = startingNode;
        boolean foundRoute = false;

        // repeat until endNode reached
        long numIteration =  NodeRepo.count();
        for (int i = 0; i < numIteration; i++) {
            if (!checkedNodes.containsKey(currentNode.getId()))
            {
                if (currentNode != endNode)
                {
                    if (1 == currentNode.getLinkList().size())
                    {
                        if (currentNode != startingNode)
                        {
                            Optional<Node> CrossNode;
                            for (int l = 0; l < CrossNodeId.size(); l++)
                            {
                                CrossNode = NodeRepo.findById(CrossNodeId.get(CrossNodeId.size() - 1));
                                boolean hasuncheckedNodes = false;
                                for (int j = 0; j < CrossNode.get().getLinkList().size(); j++)
                                {
                                    if (!checkedNodes.containsKey(CrossNode.get().getLinkList().get(j).GetLinkId())) {
                                        hasuncheckedNodes = true;
                                        break;
                                    }
                                }
                                if (true == hasuncheckedNodes) {
                                    break;
                                } else
                                    {
                                    CrossNodeId.remove(CrossNodeId.size() - 1);
                                }

                            }


                            while (CrossNodeId.get(CrossNodeId.size() - 1) != (RouteNodes.get(RouteNodes.size() - 1).getId())) {
                                RouteNodes.remove(RouteNodes.size() - 1);
                            }
                            RouteNodes.remove(RouteNodes.size() - 1);

                            Node node = NodeRepo.findById(CrossNodeId.get(CrossNodeId.size() - 1)).get();
                            //tempNodes.putIfAbsent(node.getId(), node);
                            currentNode = node;

                        }

                    }


                    for (int k = 0; k < currentNode.getLinkList().size(); k++)
                    {
                        if (!checkedNodes.containsKey(currentNode.getLinkList().get(k).GetLinkId()))
                        {
                            Long foundlink = currentNode.getLinkList().get(k).GetLinkId();

                            if(foundlink != currentNode.GetNodeId())
                            {
                                RouteNodes.add(currentNode);

                                if (2 < currentNode.getLinkList().size()) {
                                    CrossNodeId.add(currentNode.getId());
                                }
                                checkedNodes.putIfAbsent(currentNode.getId(), currentNode);
                                //currentNode = tempNodes.get(foundlink);
                                break;
                            }
                        }
                    }
                } else {
                    RouteNodes.add(currentNode);
                    foundRoute = true;
                    break;
                }
            }

        }
        if (!foundRoute)
        {
            RouteNodes.clear();
        }
        Route route = new Route();
        route.addNodes(RouteNodes);

        return  route;
    }


    public List<Route> GetFullsRoadNetwork()
    {
        List<Route> routes = new ArrayList<Route>();
        Iterable<Node> allNodes = NodeRepo.findAll();
        List<Long> doneNodes = new ArrayList<Long>();

        for (Node node : allNodes) {
            for (NodeLink link : node.getLinkList())
            {
                if(!doneNodes.contains(link.GetLinkId()))
                {
                    Route route = new Route();
                    route.addNode(node);
                    route.addNode(NodeRepo.findById(link.GetLinkId()).get());

                    routes.add(route);
                }
                doneNodes.add(node.GetNodeId());

            }
        }
        return routes;
    }


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



}
