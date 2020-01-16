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

                //simulate battery consumption
                Random r = new Random();
                float random = 0.5F + r.nextFloat() * (1.2F - 0.5F);
                transporter.setBattery(transporter.getBattery() -random);

                //looks like the start is reached
                if(transporter.GetPosition().getId() == transporter.getRoute().getNodeStartID()) {
                    transporter.setPayload(transporter.getRoute().getJobPayload());
                }

                //looks like the target is reached
                if (transporter.GetPosition().getId() == transporter.getRoute().getTargetNode()) {
                    transporter.setHasJob(false);
                    transporter.setPayload(0);
                }

                TransporterRepo.save(transporter);
            }
            else{
                if (transporter.GetPosition().GetIdentifierLocation().equals("Garage")){
                    //simulate battery loading
                    if(transporter.getBattery() < 100){
                        Random r = new Random();
                        float random = 0.5F + r.nextFloat() * (1.2F - 0.5F);
                        transporter.setBattery(transporter.getBattery() +random);
                        if(transporter.getBattery() > 100 ){
                            transporter.setBattery(100);
                        }
                        TransporterRepo.save(transporter);
                    }
                }
            }
        }
    }

}
