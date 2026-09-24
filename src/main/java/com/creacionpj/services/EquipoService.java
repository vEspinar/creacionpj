package com.creacionpj.services;

import java.util.ArrayList;
import java.util.List;

import com.creacionpj.DTO.EquipoDTO;
import com.creacionpj.exceptions.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.creacionpj.model.Equipo;
import com.creacionpj.model.Rasgo;
import com.creacionpj.repositories.EquipoRepository;
import com.creacionpj.utils.Constants;

@Service
@Transactional (readOnly = true)
public class EquipoService {
    private final EquipoRepository er;

    public EquipoService(EquipoRepository er){
        this.er=er;
    }

    public List<EquipoDTO> findAll(){
        return er.findAll().stream().map(EquipoDTO::from).toList();
    }

    public Equipo findById(Long id){
        if(id==null){
            throw new BadRequestException(Constants.ENTRADA_VACIA);
        }else if(id<=0){throw new BadRequestException(Constants.ID_FUERA_RANGO);}
        return er.findById(id).orElseThrow(()->new ResourceNotFoundException(Constants.EQUIPO_NO_ENCONTRADO));
    }

    public EquipoDTO findByIdDTO(Long id){
        if(id==null){
            throw new BadRequestException(Constants.ENTRADA_VACIA);
        }else if(id<=0){throw new BadRequestException(Constants.ID_FUERA_RANGO);}
        return EquipoDTO.from(er.findById(id).orElseThrow(()->new ResourceNotFoundException(Constants.EQUIPO_NO_ENCONTRADO)));
    }

    public List<Equipo> findByRasgo(Rasgo ras){
        if(ras==null){throw new BadRequestException(Constants.ENTRADA_VACIA);}
        return er.findByRasgos(ras);
    }

    public List<Equipo> findByTodosRasgos(List<Rasgo> rasgos){
        if(rasgos==null||rasgos.isEmpty()){throw new BadRequestException(Constants.ENTRADA_VACIA);}
        List<Rasgo> rasgosUnicos = new ArrayList<>();
        for(Rasgo r: rasgos){
            if(r !=null && r.getNombre()!=null){
                boolean existe = false;
                for(Rasgo rr: rasgosUnicos){
                    if(r.getNombre().equalsIgnoreCase(rr.getNombre())){
                        existe = true;
                        break;
                    }
                }
                if(!existe){
                    rasgosUnicos.add(r);
                }
            }
        }
        return er.findByTodosRasgos(rasgosUnicos, rasgosUnicos.size());
    }
}
