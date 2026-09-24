package com.creacionpj.services;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.creacionpj.model.Raza;
import com.creacionpj.model.SubRaza;
import com.creacionpj.DTO.SubRazaDTO;
import com.creacionpj.exceptions.BadRequestException;
import com.creacionpj.exceptions.ResourceNotFoundException;
import com.creacionpj.repositories.RazaRepository;
import com.creacionpj.repositories.SubRazaRepository;
import com.creacionpj.utils.Constants;

@Service
@Transactional (readOnly = true)
public class SubRazaService {
    private final SubRazaRepository subRazaRepository;
    private final RazaRepository razaRepository;

    public SubRazaService(SubRazaRepository sr, RazaRepository rr){
        this.subRazaRepository=sr;
        this.razaRepository=rr;
    }

    public List<SubRazaDTO> findByRaza(Long id){
        Raza rz = razaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Constants.RAZA_NO_ENCONTRADA));
        return subRazaRepository.findByReqRaza(rz.getRaza()).stream().map(SubRazaDTO::from).toList();
    }

    public SubRaza findById(Long id){
        if(id==null){
            throw new BadRequestException(Constants.ENTRADA_VACIA);
        }else if(id<=0){throw new BadRequestException(Constants.ID_FUERA_RANGO);}
        return subRazaRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(Constants.SUBRAZA_NO_ENCONTRADA));
    }

    public SubRazaDTO findByIdDTO(Long razaId, Long id){
        Raza rz = razaRepository.findById(razaId).orElseThrow(() -> new ResourceNotFoundException(Constants.RAZA_NO_ENCONTRADA));
        SubRaza sr = findById(id);
        if(sr.getReq() == null||sr.getReq().getRaza() != rz.getRaza()){
            throw new ResourceNotFoundException(Constants.SUBRAZA_NO_ENCONTRADA);
        }
        return SubRazaDTO.from(sr);
    }
}
