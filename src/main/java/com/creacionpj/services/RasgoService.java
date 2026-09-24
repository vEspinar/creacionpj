package com.creacionpj.services;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.creacionpj.exceptions.BadRequestException;
import com.creacionpj.exceptions.ResourceNotFoundException;
import com.creacionpj.model.Rasgo;
import com.creacionpj.repositories.RasgoRepository;
import com.creacionpj.utils.Constants;

@Service 
@Transactional (readOnly = true)
public class RasgoService {
    private final RasgoRepository rr;
    public RasgoService(RasgoRepository rr){this.rr=rr;}

    public Rasgo findById(Long id){
        if(id==null){
            throw new BadRequestException(Constants.ENTRADA_VACIA);
        }else if(id<=0){throw new BadRequestException(Constants.ID_FUERA_RANGO);}
        return rr.findById(id).orElseThrow(()-> new ResourceNotFoundException(Constants.RASGO_NO_ENCONTRADO));
    }
    public List<Rasgo> findAll(){
        return rr.findAll();
    }

    public Rasgo findByNombre(String r){
        if(r==null || r.isBlank()){throw new BadRequestException(Constants.ENTRADA_VACIA);}
        Rasgo rasgo = rr.findByNombreIgnoreCase(r);
        if(rasgo==null){throw new ResourceNotFoundException(Constants.RASGO_NO_ENCONTRADO + Constants.DOS_PUNTOS + r);}
        return rasgo;
    }
}
