package com.adtd.web.VirtualTransporterManager;

import com.adtd.web.entity.Node;
import com.adtd.web.entity.Route;
import com.adtd.web.entity.Transporter;
import com.adtd.web.repository.NodeRepository;
import com.adtd.web.repository.TransporterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@EnableScheduling
public class VirtualTransporterManager {


    @Autowired
    private TransporterRepository TransporterRepo;

    @Autowired
    private NodeRepository NodeRepo;

    @Scheduled(fixedDelay = 1000)
    public void scheduleTransporterPositon() {

        for(Transporter transporter : TransporterRepo.findAll())
        {
            List<Node> routeNodes = transporter.getRoute().getRouteNodes();

            if(!routeNodes.isEmpty()) {
                //TODO: rework mabey
                transporter.setPosition(routeNodes.get(0));
                routeNodes.remove(0);
                transporter.getRoute().setRouteNodes(routeNodes);


                //looks like the target is reached
                if (transporter.GetPosition().getId() == transporter.getRoute().getTargetNode()) {
                    transporter.setHasJob(false);
                }

                TransporterRepo.save(transporter);
            }
        }

    }

    private Node GetRandomNode(){

        Random r = new Random();

        int number = r.nextInt(32) +1;
        Long LNumber = Long.valueOf(number);

         return NodeRepo.findById(LNumber).get();

    }
}
