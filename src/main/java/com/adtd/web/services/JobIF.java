package com.adtd.web.services;

import com.adtd.web.dataAccess.JobDTO;
import com.adtd.web.entity.Location;
import com.adtd.web.entity.Node;
import com.adtd.web.entity.Route;
import com.adtd.web.entity.Transporter;
import com.adtd.web.repository.LocationRepository;
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

    @Autowired
    LocationRepository LocationRepo;


    public ErrorTypeJobIF startJob(JobDTO job) {
        if (job.getNodeStartID().equals("--") || job.getNodeTargetID().equals("--")) {
            return ErrorTypeJobIF.ERROR_INVALID_DATA;
        }
        else {

        }
        Optional<Location> StartLocation = LocationRepo.findById(job.getNodeStartID());
        Optional<Location> TargetLocation = LocationRepo.findById(job.getNodeTargetID());

        if (StartLocation.isPresent() && TargetLocation.isPresent()) {

            Optional<Node> StartNode = NodeRepo.findById(StartLocation.get().getRoadConnection());
            Optional<Node> TargetNode = NodeRepo.findById(TargetLocation.get().getRoadConnection());

            if (StartNode.isPresent() && TargetNode.isPresent()) {

                for (Transporter transporter : TransporterRepo.findAll()) {
                    if ((!transporter.isHasJob()) && (transporter.getBattery() > 50) && (transporter.getMaxPayload() >= job.getJobPayload())) {

                        Route route = routeProvider.GetRoute(transporter.GetPosition(), StartNode.get(), TargetNode.get());

                        if(!route.getRouteNodes().isEmpty()) {
                            route.setJobPayload(job.getJobPayload());

                            transporter.setRoute(route);
                            transporter.setHasJob(true);
                            TransporterRepo.save(transporter);

                            return ErrorTypeJobIF.ERROR_NO_ERROR;
                        }
                        return ErrorTypeJobIF.ERROR_UNKNOWN;
                    }
                }
                return ErrorTypeJobIF.ERROR_NO_TRANSPORTER_AVAILABLE;
            }
            return ErrorTypeJobIF.ERROR_INVALID_DATA;
        }
        return ErrorTypeJobIF.ERROR_INVALID_DATA;
    }






    public enum ErrorTypeJobIF {
        ERROR_NO_ERROR,
        ERROR_INVALID_DATA,
        ERROR_NO_TRANSPORTER_AVAILABLE,
        ERROR_UNKNOWN
    }

}
