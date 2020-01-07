package com.adtd.web.services;

import com.adtd.web.dataAccess.NewTransporterDTO;
import com.adtd.web.entity.Transporter;
import com.adtd.web.repository.TransporterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransporterIF {

    @Autowired
    TransporterRepository TransporterRepo;

    public ErrorType AddTransporterToRepo(NewTransporterDTO transporterDTO) {
        if(!transporterDTO.getLabel().isEmpty()) {
            if (TransporterRepo.findById(transporterDTO.getLabel()).isEmpty()) {

                Transporter transporter = new Transporter(transporterDTO.getLabel(),
                        transporterDTO.getBattery(), transporterDTO.getMaxPayload());

                TransporterRepo.save(transporter);

                return ErrorType.ERROR_NO_ERROR;
            }
            else
            {
                return ErrorType.ERROR_DB;
            }
        }
        else {
            return ErrorType.ERROR_INVALID_DATA;
        }
    }


    public ErrorType DelTransporterFromRepo(NewTransporterDTO transporterDTO) {
        if(!transporterDTO.getLabel().isEmpty()) {
            if (TransporterRepo.findById(transporterDTO.getLabel()).isPresent()) {

                Transporter transporter = new Transporter(transporterDTO.getLabel());
                TransporterRepo.delete(transporter);

                return ErrorType.ERROR_NO_ERROR;
            }
            else
            {
                return ErrorType.ERROR_DB;
            }
        }
        else {
            return ErrorType.ERROR_INVALID_DATA;
        }
    }


    public enum ErrorType {
        ERROR_NO_ERROR,
        ERROR_DB,
        ERROR_INVALID_DATA,
    }


}
