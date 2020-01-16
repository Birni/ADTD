package com.adtd.web.services;


import com.adtd.web.dataAccess.TransporterDTO;
import com.adtd.web.entity.Location;
import com.adtd.web.entity.Node;
import com.adtd.web.entity.Transporter;
import com.adtd.web.repository.LocationRepository;
import com.adtd.web.repository.NodeRepository;
import com.adtd.web.repository.TransporterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * Interface for transporter
 * adds transporter, delete transporter select transporter information
 *
 * @author  Matthias Birnthaler
 */
@Service
public class TransporterIF {

    @Autowired
    TransporterRepository TransporterRepo;

    @Autowired
    TransporterRepository Transporter;

    @Autowired
    NodeRepository NodeRepo;

    @Autowired
    LocationRepository LocationRepo;


    /**
     * returns a list with all transporter information
     */
    public List<TransporterDTO> getListAllTransporter()
    {
        List<TransporterDTO> list = new ArrayList<>();
        for(Transporter transporter : Transporter.findAll())
        {
            TransporterDTO dto = new TransporterDTO();

            dto.setLabel(transporter.getLabel());
            dto.setBattery(transporter.getBattery());
            dto.setMaxPayload(transporter.getMaxPayload());
            dto.setPayload(transporter.getPayload());
            dto.setHasJob(transporter.isHasJob());

            if(transporter.isHasJob()) {
                Optional<Node> startNode = NodeRepo.findById(transporter.getJob().getNodeStartID());
                Optional<Node> targetNode = NodeRepo.findById(transporter.getJob().getNodeTargetID());
                if((targetNode.isPresent()) && (startNode.isPresent()))
                {
                    dto.setStartDestination(startNode.get().GetIdentifierLocation());
                    dto.setTargetDestination(targetNode.get().GetIdentifierLocation());
                }
            }
            else
            {
                dto.setStartDestination("none");
                dto.setTargetDestination("none");
            }
            list.add(dto);
        }
        return list;
    }


    /**
     * adds a new transporter to the Repository
     * @param transporterDTO attributes of the transporter
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public ErrorTypeTransporterIf AddTransporterToRepo(TransporterDTO transporterDTO) {
        if(!transporterDTO.getLabel().isEmpty()) {
            if (TransporterRepo.findById(transporterDTO.getLabel()).isEmpty()) {

                Transporter transporter = new Transporter(transporterDTO.getLabel(),
                        transporterDTO.getBattery(), transporterDTO.getMaxPayload());

                Optional<Location> location = LocationRepo.findById("Garage");
                if (location.isPresent()) {
                    Optional<Node> garage = NodeRepo.findById(location.get().getRoadConnection());
                    if(garage.isPresent()){
                        transporter.setPosition(garage.get());
                    }
                }

                TransporterRepo.save(transporter);

                return ErrorTypeTransporterIf.ERROR_NO_ERROR;
            }
            else
            {
                return ErrorTypeTransporterIf.ERROR_DB;
            }
        }
        else {
            return ErrorTypeTransporterIf.ERROR_INVALID_DATA;
        }
    }


    /**
     * deletes a new transporter to the Repository
     * @param transporterDTO attributes of the transporter
     */
    public ErrorTypeTransporterIf DelTransporterFromRepo(TransporterDTO transporterDTO) {
        if(!transporterDTO.getLabel().isEmpty()) {
            if (TransporterRepo.findById(transporterDTO.getLabel()).isPresent()) {

                Transporter transporter = new Transporter(transporterDTO.getLabel());
                TransporterRepo.delete(transporter);

                return ErrorTypeTransporterIf.ERROR_NO_ERROR;
            }
            else
            {
                return ErrorTypeTransporterIf.ERROR_DB;
            }
        }
        else {
            return ErrorTypeTransporterIf.ERROR_INVALID_DATA;
        }
    }


    /**
     * enum with error types
     */
    public enum ErrorTypeTransporterIf {
        ERROR_NO_ERROR,
        ERROR_DB,
        ERROR_INVALID_DATA,
    }
}
