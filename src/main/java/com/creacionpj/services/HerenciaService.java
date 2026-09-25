package com.creacionpj.services;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.creacionpj.model.Ascendencia;
import com.creacionpj.model.Herencia;
import com.creacionpj.DTO.HerenciaDTO;
import com.creacionpj.exceptions.BadRequestException;
import com.creacionpj.exceptions.ResourceNotFoundException;
import com.creacionpj.repositories.AscendenciaRepository;
import com.creacionpj.repositories.HerenciaRepository;
import com.creacionpj.utils.Constants;

@Service
@Transactional (readOnly = true)
public class HerenciaService {
    private final HerenciaRepository herenciaRepository;
    private final AscendenciaRepository AscendenciaRepository;

    public HerenciaService(HerenciaRepository hr, AscendenciaRepository ar){
        this.herenciaRepository=hr;
        this.AscendenciaRepository=ar;
    }

    public List<HerenciaDTO> findByAscendencia(Long id){
        Ascendencia as = AscendenciaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Constants.ASCENDENCIA_NO_ENCONTRADA));
        return herenciaRepository.findByReqAscendencia(as.getAscendencia()).stream().map(HerenciaDTO::from).toList();
    }

    public Herencia findById(Long id){
        if(id==null){
            throw new BadRequestException(Constants.ENTRADA_VACIA);
        }else if(id<=0){throw new BadRequestException(Constants.ID_FUERA_RANGO);}
        return herenciaRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(Constants.HERENCIA_NO_ENCONTRADA));
    }

    public HerenciaDTO findByIdDTO(Long ascendenciaId, Long id){
        Ascendencia as = AscendenciaRepository.findById(ascendenciaId).orElseThrow(() -> new ResourceNotFoundException(Constants.ASCENDENCIA_NO_ENCONTRADA));
        Herencia he = findById(id);
        if(he.getReq() == null||he.getReq().getAscendencia() != as.getAscendencia()){
            throw new ResourceNotFoundException(Constants.HERENCIA_NO_ENCONTRADA);
        }
        return HerenciaDTO.from(he);
    }
}
