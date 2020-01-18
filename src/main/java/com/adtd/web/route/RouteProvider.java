package com.adtd.web.route;


import com.adtd.web.entity.Location;
import com.adtd.web.entity.Node;
import com.adtd.web.entity.NodeLink;
import com.adtd.web.entity.Job;
import com.adtd.web.repository.LocationRepository;
import com.adtd.web.repository.NodeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


import java.util.*;

/**
 * Routing
 * Calculates routes
 *
 * @author  Matthias Birnthaler
 */
@Service
@Scope("application")
public class RouteProvider
{
    @Autowired
    private NodeRepository NodeRepo;

    @Autowired
    private LocationRepository LocationRepo;


    public RouteProvider()
    {

    }


    /**
     * Calculates a route
     * @param NodeTransporterPos current position of the transporter
     * @param StartNode start location
     * @param TargetNope target location
     */
    public Job GetRoute(Node NodeTransporterPos, Node StartNode, Node TargetNope)
    {
        Job job = new Job();

        job.setNodeStartID(StartNode.getId());
        job.setNodeTargetID(TargetNope.getId());

        job.setRouteNodes(GetRoutePiece(NodeTransporterPos, StartNode));
        job.addRouteNodes(GetRoutePiece(StartNode, TargetNope));

        Optional<Location> location = LocationRepo.findById("Garage");
        if (location.isPresent()) {
            Optional<Node> garage = NodeRepo.findById(location.get().getRoadConnection());
            if(garage.isPresent()){
                job.addRouteNodes(GetRoutePiece(TargetNope, garage.get()));
            }
        }

        Logger logger = LoggerFactory.getLogger(RouteProvider.class);
        //TODO: only for debugging
        for(Node node : job.getRouteNodes()){
            logger.info(String.valueOf(node.getId()));
        }


        return job;
    }


    /**
     * Calculates a sub route
     * @param startingNode start location/node
     * @param endNode end location/node
     */
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


    /**
     * Calculates all sub route/ streets
     *
     */
    public List<Job> GetFullsRoadNetwork()
    {
        List<Job> jobs = new ArrayList<Job>();
        Iterable<Node> allNodes = NodeRepo.findAll();
        List<Long> doneNodes = new ArrayList<Long>();

        for (Node node : allNodes) {
            for (NodeLink link : node.getLinkList())
            {
                if(!doneNodes.contains(link.GetLinkedNode()))
                {
                    Job job = new Job();
                    job.setSingleNode(node);
                    Optional<Node> temp = NodeRepo.findById(link.GetLinkedNode());
                    if(temp.isPresent()){
                        job.setSingleNode(temp.get());
                    }

                    jobs.add(job);
                }
                doneNodes.add(node.GetNodeId());

            }
        }
        return jobs;
    }
}

