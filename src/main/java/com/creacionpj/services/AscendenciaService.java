package com.creacionpj.services;

import java.util.List;

import com.creacionpj.DTO.AscendenciaDTO;
import com.creacionpj.exceptions.BadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.creacionpj.exceptions.ResourceNotFoundException;
import com.creacionpj.model.Ascendencia;
import com.creacionpj.repositories.AscendenciaRepository;
import com.creacionpj.utils.Constants;

@Service
@Transactional (readOnly = true)
public class AscendenciaService {
    private final AscendenciaRepository ascendenciaRepository;

    public AscendenciaService(AscendenciaRepository ar){this.ascendenciaRepository=ar;}

    public List<AscendenciaDTO> findAll(){
        return ascendenciaRepository.findAll().stream().map(AscendenciaDTO::from).toList();
    }

    public Ascendencia findById(Long id){
        if(id==null){
            throw new BadRequestException(Constants.ENTRADA_VACIA);
        }else if(id<=0){throw new BadRequestException(Constants.ID_FUERA_RANGO);}
        return ascendenciaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(Constants.ASCENDENCIA_NO_ENCONTRADA));
    }

    public AscendenciaDTO findByIdDTO(Long id){
        if(id==null){
            throw new BadRequestException(Constants.ENTRADA_VACIA);
        }else if(id<=0){throw new BadRequestException(Constants.ID_FUERA_RANGO);}
        return AscendenciaDTO.from(ascendenciaRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(Constants.ASCENDENCIA_NO_ENCONTRADA)));
    }
}
