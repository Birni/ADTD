package com.adtd.web.VirtualTransporterManager;

import com.adtd.web.entity.Node;
import com.adtd.web.entity.Transporter;
import com.adtd.web.repository.TransporterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.faces.bean.ApplicationScoped;
import java.util.List;
import java.util.Random;

/**
 * Virtual transporter manager
 * simulates the transporter, movement, loading battery, loading payload
 *
 * @author  Matthias Birnthaler
 */
@EnableScheduling
@Service
@ApplicationScoped
public class VirtualTransporterManager {


    @Autowired
    private TransporterRepository TransporterRepo;


    @Scheduled(fixedDelay = 1000)
    @Transactional(propagation = Propagation.REQUIRED)
    public void scheduleTransporterPositon() {

        for(Transporter transporter : TransporterRepo.findAll())
        {
            List<Node> routeNodes = transporter.getJob().getRouteNodes();

            if(!routeNodes.isEmpty()) {
                transporter.setPosition(routeNodes.get(0));
                routeNodes.remove(0);
                transporter.getJob().setRouteNodes(routeNodes);

                //simulate battery consumption
                Random r = new Random();
                float random = 0.5F + r.nextFloat() * (1.2F - 0.5F);
                transporter.setBattery(transporter.getBattery() -random);

                //looks like the start is reached
                if(transporter.GetPosition().getId() == transporter.getJob().getNodeStartID()) {
                    transporter.setPayload(transporter.getJob().getJobPayload());
                }

                //looks like the target is reached
                if (transporter.GetPosition().getId() == transporter.getJob().getTargetNode()) {
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
