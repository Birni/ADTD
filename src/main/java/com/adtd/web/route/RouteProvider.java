package com.adtd.web.route;


import com.adtd.web.entity.Location;
import com.adtd.web.entity.Node;
import com.adtd.web.entity.NodeLink;
import com.adtd.web.entity.Route;
import com.adtd.web.repository.LocationRepository;
import com.adtd.web.repository.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RouteProvider
{
    @Autowired
    private NodeRepository NodeRepo;

    @Autowired
    private LocationRepository LocationRepo;


    public RouteProvider()
    {

    }

    public Route GetRoute(Node NodeTransporterPos, Node StartNode, Node TargetNope)
    {
        Route route = new Route();

        route.setNodeStartID(StartNode.getId());
        route.setNodeTargetID(TargetNope.getId());

        route.setRouteNodes(GetRoutePiece(NodeTransporterPos, StartNode));
        route.addRouteNodes(GetRoutePiece(StartNode, TargetNope));

        Optional<Location> location = LocationRepo.findById("Garage");
        if (location.isPresent()) {
            Optional<Node> garage = NodeRepo.findById(location.get().getRoadConnection());
            if(garage.isPresent()){
                route.addRouteNodes(GetRoutePiece(TargetNope, garage.get()));
            }
        }

        return route;
    }

    public List<Node> GetRoutePiece(Node startingNode, Node endNode )
    {
        Map<Long, Node> tempNodes =  new HashMap<>();
        for(Node node : NodeRepo.findAll()) {
            tempNodes.putIfAbsent(node.getId(), node);
        }

        Map<Long, Node> checkedNodes = new HashMap<>();
        List<Long> CrossNodeId = new ArrayList<>();
        List<Node> RouteNodes = new ArrayList<>();

        Node currentNode = startingNode;
        boolean foundRoute = false;

        // repeat until endNode reached
        long numIteration =  tempNodes.size();
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
                                    if (!checkedNodes.containsKey(CrossNode.get().getLinkList().get(j).GetLinkedNode())) {
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
                            tempNodes.putIfAbsent(node.getId(), node);
                            currentNode = node;

                        }

                    }


                    for (int k = 0; k < currentNode.getLinkList().size(); k++)
                    {
                        if (!checkedNodes.containsKey(currentNode.getLinkList().get(k).GetLinkedNode()))
                        {
                            Long foundlink = currentNode.getLinkList().get(k).GetLinkedNode();

                            if(foundlink != currentNode.GetNodeId())
                            {
                                RouteNodes.add(currentNode);

                                if (2 < currentNode.getLinkList().size()) {
                                    CrossNodeId.add(currentNode.getId());
                                }
                                checkedNodes.putIfAbsent(currentNode.getId(), currentNode);
                                currentNode = tempNodes.get(foundlink);
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

        return  RouteNodes;
    }


    public List<Route> GetFullsRoadNetwork()
    {
        List<Route> routes = new ArrayList<Route>();
        Iterable<Node> allNodes = NodeRepo.findAll();
        List<Long> doneNodes = new ArrayList<Long>();

        for (Node node : allNodes) {
            for (NodeLink link : node.getLinkList())
            {
                if(!doneNodes.contains(link.GetLinkedNode()))
                {
                    Route route = new Route();
                    route.setSingleNode(node);
                    Optional<Node> temp = NodeRepo.findById(link.GetLinkedNode());
                    if(temp.isPresent()){
                        route.setSingleNode(temp.get());
                    }

                    routes.add(route);
                }
                doneNodes.add(node.GetNodeId());

            }
        }
        return routes;
    }

}

