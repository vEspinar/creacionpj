package com.creacionpj.services;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.creacionpj.DTO.BagajeDTO;
import com.creacionpj.exceptions.BadRequestException;
import com.creacionpj.exceptions.ResourceNotFoundException;
import com.creacionpj.model.Bagaje;
import com.creacionpj.repositories.BagajeRepository;
import com.creacionpj.utils.Constants;

@Service
@Transactional (readOnly = true)
public class BagajeService {
    private final BagajeRepository bagajeRepository;

    public BagajeService(BagajeRepository bagajeRepository){
        this.bagajeRepository=bagajeRepository;
    }

    public List<BagajeDTO> findAll(){
        return bagajeRepository.findAll().stream().map(BagajeDTO::from).toList();
    }

    public Bagaje findById(Long id){
        if(id==null){
            throw new BadRequestException(Constants.ENTRADA_VACIA);
        }else if(id<=0){throw new BadRequestException(Constants.ID_FUERA_RANGO);}
        return bagajeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(Constants.BAGAJE_NO_ENCONTRADO));
    }

    public BagajeDTO findByIdDTO(Long id){
        if(id==null){
            throw new BadRequestException(Constants.ENTRADA_VACIA);
        }else if(id<=0){throw new BadRequestException(Constants.ID_FUERA_RANGO);}
        return BagajeDTO.from(bagajeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(Constants.BAGAJE_NO_ENCONTRADO)));
    }
}
