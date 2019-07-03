package services.service;

import services.entity.Node;


import java.util.*;


public class RouteProvider
{

    public RouteProvider()
    {

    }

    public Route GetRoute(Node startingNode, Node endNode )
    {
        Map<Long, Node> tempNodes = NodeCollection.getInstance().getCollectionOfNodes();
        Map<Long, Node> checkedNodes = new HashMap<>();
        List<Long> CrossNodeId = new ArrayList<>();
        List<Node> RouteNodes = new ArrayList<>();

        Node currentNode = startingNode;
        boolean foundRoute = false;

        // repeat until endNode reached
        int numIteration = tempNodes.size();
        for (int i = 0; i < numIteration; i++) {
            if (!checkedNodes.containsKey(currentNode.getId()))
            {
                if (currentNode != endNode)
                {
                    if (1 == currentNode.getLinkList().size())
                    {
                        if (currentNode != startingNode)
                        {

                            Node CrossNode = new Node();
                            for (int l = 0; l < CrossNodeId.size(); l++)
                            {
                                CrossNode = NodeCollection.getInstance().GetNodeById(CrossNodeId.get(CrossNodeId.size() - 1));
                                boolean hasuncheckedNodes = false;
                                for (int j = 0; j < CrossNode.getLinkList().size(); j++)
                                {
                                    if (!checkedNodes.containsKey(CrossNode.getLinkList().get(j).getId())) {
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

                            Node node = NodeCollection.getInstance().GetNodeById(CrossNodeId.get(CrossNodeId.size() - 1));
                            tempNodes.putIfAbsent(node.getId(), node);
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
        Route route = new Route();
        route.addNodes(RouteNodes);

        return  route;
    }


    public List<Route> GetFullsRoadNetwork()
    {
        List<Route> routes = new ArrayList<Route>();
        Map<Long, Node> tempNodes = NodeCollection.getInstance().getCollectionOfNodes();
        List<Long> doneNodes = new ArrayList<Long>();

        for (Map.Entry<Long,Node> entry : tempNodes.entrySet())
        {
            for (int i = 0; i < entry.getValue().getLinkList().size(); i ++)
            {
                if(!doneNodes.contains(entry.getValue().getLinkList().get(i).GetLinkId()))
                {
                    Route route = new Route();
                    route.addNode(entry.getValue());
                    route.addNode(tempNodes.get(entry.getValue().getLinkList().get(i).GetLinkId()));

                    routes.add(route);
                }
                doneNodes.add(entry.getKey());

            }
        }
        return routes;
    }

}

