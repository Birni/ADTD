package com.adtd.web.VirtualTransporterManager;

import com.adtd.web.entity.Node;
import com.adtd.web.entity.Transporter;
import com.adtd.web.repository.NodeRepository;
import com.adtd.web.repository.TransporterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

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
            transporter.setPosition(GetRandomNode().GetCoordinate());

            TransporterRepo.save(transporter);
        }
    }

    private Node GetRandomNode(){

        Random r = new Random();

        int number = r.nextInt(32) +1;
        Long LNumber = Long.valueOf(number);

         return NodeRepo.findById(LNumber).get();

    }
}
