package com.creacionpj.services;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.creacionpj.DTO.ClaseDTO;
import com.creacionpj.exceptions.BadRequestException;
import com.creacionpj.exceptions.ResourceNotFoundException;
import com.creacionpj.model.Clase;
import com.creacionpj.repositories.ClaseRepository;
import com.creacionpj.utils.Constants;

@Service
@Transactional (readOnly = true)
public class ClaseService {
    
    private final ClaseRepository claseRepository;
    
    public ClaseService(ClaseRepository claseRepository){
        this.claseRepository=claseRepository;
    }

    public List<ClaseDTO> findAll(){
        return claseRepository.findAll().stream().map(ClaseDTO::from).toList();
    }

    public Clase findById(Long id){
        if(id==null){
            throw new BadRequestException(Constants.ENTRADA_VACIA);
        }else if(id<=0){throw new BadRequestException(Constants.ID_FUERA_RANGO);}
        return claseRepository.findById(id).orElseThrow(()->
            new ResourceNotFoundException(Constants.CLASE_NO_ENCONTRADA));
    }

    public ClaseDTO findByIdDTO(Long id){
        if(id==null){
            throw new BadRequestException(Constants.ENTRADA_VACIA);
        }else if(id<=0){throw new BadRequestException(Constants.ID_FUERA_RANGO);}
        return ClaseDTO.from(claseRepository.findById(id).orElseThrow(()-> 
            new ResourceNotFoundException(Constants.CLASE_NO_ENCONTRADA)));
    }
}
