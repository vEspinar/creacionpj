package com.creacionpj.services;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.creacionpj.DTO.HechizoDTO;
import com.creacionpj.exceptions.BadRequestException;
import com.creacionpj.exceptions.ResourceNotFoundException;
import com.creacionpj.model.Hechizo;
import com.creacionpj.model.TipoCompetenciaCombate;
import com.creacionpj.model.TipoTradicion;
import com.creacionpj.repositories.HechizoRepository;
import com.creacionpj.utils.Constants;

@Service
@Transactional (readOnly = true)
public class HechizoService {
    private final HechizoRepository hr;
    public HechizoService(HechizoRepository hr){
        this.hr=hr;
    }
    public List<HechizoDTO> findAll(){
        return hr.findAll().stream().map(HechizoDTO::from).toList();
    }
    public Hechizo findByNombre(String nombre){
        if(nombre==null||nombre.isBlank()){throw new BadRequestException(Constants.ENTRADA_VACIA);}
        return hr.findByNombreIgnoreCase(nombre).orElseThrow(()-> new ResourceNotFoundException(Constants.HECHIZO_NO_ENCONTRADO));
    }
    public List<HechizoDTO> findByTradicion(TipoTradicion tradicion){
        if(tradicion==null){throw new BadRequestException(Constants.ENTRADA_VACIA);}
        return hr.findByTradicion(tradicion).stream().map(HechizoDTO::from).toList();
    }
    public List<HechizoDTO> findBySalvacion(TipoCompetenciaCombate salvacion){
        if(salvacion==null){throw new BadRequestException(Constants.ENTRADA_VACIA);}
        return hr.findBySalvacion(salvacion).stream().map(HechizoDTO::from).toList();
    }
    public List<HechizoDTO> findByTradicionAndSalvacion(TipoTradicion tra, TipoCompetenciaCombate sal){
        if(tra==null||sal==null){throw new BadRequestException(Constants.ENTRADA_VACIA);}
        return hr.findByTradicionAndSalvacion(tra, sal).stream().map(HechizoDTO::from).toList();
    }
    public HechizoDTO findByIdDTO(Long id){
        if(id==null){
            throw new BadRequestException(Constants.ENTRADA_VACIA);
        }else if(id<=0){throw new BadRequestException(Constants.ID_FUERA_RANGO);}
        return HechizoDTO.from(hr.findById(id).orElseThrow(()->new ResourceNotFoundException(Constants.HECHIZO_NO_ENCONTRADO)));
    
    }
}
