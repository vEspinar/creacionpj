package com.creacionpj.services;

import java.util.List;

import com.creacionpj.DTO.RazaDTO;
import com.creacionpj.exceptions.BadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.creacionpj.exceptions.ResourceNotFoundException;
import com.creacionpj.model.Raza;
import com.creacionpj.repositories.RazaRepository;
import com.creacionpj.utils.Constants;

@Service
@Transactional (readOnly = true)
public class RazaService {
    private final RazaRepository razaRepository;

    public RazaService(RazaRepository rr){this.razaRepository=rr;}

    public List<RazaDTO> findAll(){
        return razaRepository.findAll().stream().map(RazaDTO::from).toList();
    }

    public Raza findById(Long id){
        if(id==null){
            throw new BadRequestException(Constants.ENTRADA_VACIA);
        }else if(id<=0){throw new BadRequestException(Constants.ID_FUERA_RANGO);}
        return razaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(Constants.RAZA_NO_ENCONTRADA));
    }

    public RazaDTO findByIdDTO(Long id){
        if(id==null){
            throw new BadRequestException(Constants.ENTRADA_VACIA);
        }else if(id<=0){throw new BadRequestException(Constants.ID_FUERA_RANGO);}
        return RazaDTO.from(razaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(Constants.RAZA_NO_ENCONTRADA)));
   
    }
}
