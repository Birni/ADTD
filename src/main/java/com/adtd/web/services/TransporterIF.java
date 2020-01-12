package com.adtd.web.services;

import com.adtd.web.dataAccess.NewTransporterDTO;
import com.adtd.web.dataAccess.TransporterDTO;
import com.adtd.web.entity.Node;
import com.adtd.web.entity.Transporter;
import com.adtd.web.repository.NodeRepository;
import com.adtd.web.repository.TransporterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransporterIF {

    @Autowired
    TransporterRepository TransporterRepo;

    @Autowired
    TransporterRepository Transporter;

    @Autowired
    NodeRepository NodeRepo;



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
                Optional<Node> startNode = NodeRepo.findById(transporter.getRoute().getNodeStartID());
                Optional<Node> targetNode = NodeRepo.findById(transporter.getRoute().getNodeTargetID());
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

    public ErrorTypeTransporterIf AddTransporterToRepo(NewTransporterDTO transporterDTO) {
        if(!transporterDTO.getLabel().isEmpty()) {
            if (TransporterRepo.findById(transporterDTO.getLabel()).isEmpty()) {

                Transporter transporter = new Transporter(transporterDTO.getLabel(),
                        transporterDTO.getBattery(), transporterDTO.getMaxPayload());

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


    public ErrorTypeTransporterIf DelTransporterFromRepo(NewTransporterDTO transporterDTO) {
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


    public enum ErrorTypeTransporterIf {
        ERROR_NO_ERROR,
        ERROR_DB,
        ERROR_INVALID_DATA,
    }


}
