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

    public List<Node> GetRoutePiece(Node startingNode, Node endNode ) {
        Map<Long, Node> tempNodes = new HashMap<>();
        for (Node node : NodeRepo.findAll()) {
            tempNodes.put(node.getId(), node);
        }

        List<Node> ResultNodes = new ArrayList<>();
        List<Node> CrossNode = new ArrayList<>();
        Map<Long, Node> Visited = new HashMap<>();

        Node currentNode = startingNode;

        if(startingNode.getLinkList().size() >=2) {
            CrossNode.add(startingNode);
        }



        // repeat until endNode reached
        while(currentNode != endNode) {
            ResultNodes.add(currentNode);
            Visited.put(currentNode.getId(), currentNode);
            boolean noMoreToVisit = true;
            for(int i=0; i < currentNode.getLinkList().size(); i++) {
                // never visited node
                if (!Visited.containsKey(currentNode.getLinkList().get(i).GetLinkedNode())){
                    // move to this node
                    currentNode = tempNodes.get(currentNode.getLinkList().get(i).GetLinkedNode());
                    Visited.put(currentNode.getId(), currentNode);
                    noMoreToVisit = false;
                    break;
                }
                // TODO mabey do loopbrake
            }

            if(noMoreToVisit && (CrossNode.isEmpty()))
            {
                ResultNodes.clear();
                break;
            }


            // check new node
            //dead end
            if(currentNode.getLinkList().size() == 1){
                if(currentNode.getId() == endNode.getId()) {
                    ResultNodes.add(currentNode);
                    break;
                }
                // move back the last crossroad
                else{
                    if(!CrossNode.isEmpty()) {

                        // crossnode with unchecked side streets
                        boolean breakloop = false;
                        while (!CrossNode.isEmpty() && !breakloop) {

                            while (ResultNodes.get(ResultNodes.size() - 1) != CrossNode.get(CrossNode.size() - 1)) {
                                ResultNodes.remove(ResultNodes.size() - 1);
                            }

                            for (int i = 0; i < CrossNode.get(CrossNode.size() - 1).getLinkList().size(); i++) {
                                if (!Visited.containsKey(CrossNode.get(CrossNode.size() - 1).getLinkList().get(i).GetLinkedNode())) {
                                    currentNode = CrossNode.get(CrossNode.size() - 1);
                                    //ResultNodes.remove(ResultNodes.size() - 1);
                                    //CrossNode.remove(CrossNode.size() - 1);

                                    breakloop = true;
                                    break;
                                }
                            }
                            ResultNodes.remove(ResultNodes.size() - 1);
                            CrossNode.remove(CrossNode.size() - 1);
                        }
                    }
                }
            }

            // is crossroad
            if(currentNode.getLinkList().size() > 2){
                CrossNode.add(currentNode);
            }



        }

        return ResultNodes;
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

