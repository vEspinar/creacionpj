package com.creacionpj.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.creacionpj.exceptions.BadRequestException;
import com.creacionpj.exceptions.ResourceNotFoundException;
import com.creacionpj.model.Clase;
import com.creacionpj.model.SubidaNivel;
import com.creacionpj.repositories.SubidaNivelRepository;
import com.creacionpj.utils.Constants;

@Service 
@Transactional (readOnly = true)
public class SubidaNivelService {
    private final SubidaNivelRepository snr;

    public SubidaNivelService(SubidaNivelRepository snr){this.snr=snr;}

    public boolean existsByClase(Clase c){
        if(c==null){throw new BadRequestException(Constants.ENTRADA_VACIA);}
        return snr.existsByClase(c);
    }
    public SubidaNivel findByClaseAndLvl(Clase c, int lvl){
        if(c==null){throw new BadRequestException(Constants.ENTRADA_VACIA);}
        if(lvl > 20 || lvl< 1){throw new BadRequestException(Constants.NIVEL_FUERA_RANGO);}
        SubidaNivel sn= snr.findByClaseAndLvl(c, lvl);
        if(sn==null){throw new ResourceNotFoundException(Constants.SUBIDA_NIVEL_NO_ENCONTRADA);}
        return sn;
    }
}
