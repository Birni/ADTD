package com.adtd.web.dataAccess;

import com.adtd.web.entity.Node;
import com.adtd.web.entity.Transporter;
import com.adtd.web.repository.NodeRepository;
import com.adtd.web.repository.TransporterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class TransporterDTO {

    @Autowired
    TransporterRepository Transporter;

    @Autowired
    NodeRepository NodeRepo;

    private String Label;
    private float maxPayload;
    private float battery;
    private float payload;
    private boolean hasJob;
    private String destination;

    public void setLabel(String label) {
        Label = label;
    }

    public void setMaxPayload(float maxPayload) {
        this.maxPayload = maxPayload;
    }

    public void setBattery(float battery) {
        this.battery = battery;
    }

    public void setPayload(float payload) {
        this.payload = payload;
    }

    public void setHasJob(boolean hasJob) {
        this.hasJob = hasJob;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getLabel() {
        return Label;
    }

    public float getPayload() {
        return payload;
    }

    public float getBattery() {
        return battery;
    }

    public boolean isHasJob() {
        return hasJob;
    }

    public float getMaxPayload() {
        return maxPayload;
    }

    public String getDestination() {
        return destination;
    }


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
                Optional<Node> targetNode = NodeRepo.findById(transporter.getRoute().getTargetNode());
                if(targetNode.isPresent())
                {
                    dto.setDestination(targetNode.get().GetIdentifierLocation());
                }

            }
            else
            {
                dto.setDestination("none");
            }

            list.add(dto);

        }
        return list;
    }
}