package com.adtd.web.services;

import com.adtd.web.dataAccess.TransporterJob;
import com.adtd.web.entity.Node;
import com.adtd.web.entity.Route;
import com.adtd.web.entity.Transporter;
import com.adtd.web.repository.NodeRepository;
import com.adtd.web.repository.TransporterRepository;
import com.adtd.web.route.RouteProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobIF {

    @Autowired
    RouteProvider routeProvider;

    @Autowired
    TransporterRepository TransporterRepo;

    @Autowired
    NodeRepository NodeRepo;


    public ErrorTypeJobIF startJob(TransporterJob job) {
        if(job.getNodeStartID() == 0 || job.getNodeTargetID() ==0){
            return ErrorTypeJobIF.ERROR_INVALID_DATA;
        }
        else {

            for (Transporter transporter : TransporterRepo.findAll()) {
                if ((!transporter.isHasJob()) && (transporter.getBattery() > 20) && (transporter.getMaxPayload() >= job.getPayload())) {

                    Optional<Node> StartNode = NodeRepo.findById(job.getNodeStartID());
                    Optional<Node> TargetNode = NodeRepo.findById(job.getNodeTargetID());

                    if(StartNode.isPresent() && TargetNode.isPresent())
                    {
                        Route route = routeProvider.GetRoute(transporter.GetPosition(), StartNode.get(),TargetNode.get());

                        transporter.setRoute(route);
                        transporter.setHasJob(true);
                        TransporterRepo.save(transporter);

                        return ErrorTypeJobIF.ERROR_NO_ERROR;
                    }
                }
            }
            return ErrorTypeJobIF.ERROR_NO_TRANSPORTER_AVAILABLE;
        }
    }




    public enum ErrorTypeJobIF {
        ERROR_NO_ERROR,
        ERROR_INVALID_DATA,
        ERROR_NO_TRANSPORTER_AVAILABLE,
        ERROR_UNKNOWN
    }

}
