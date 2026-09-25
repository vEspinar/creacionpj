package com.creacionpj.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.creacionpj.DTO.DoteDTO;
import com.creacionpj.exceptions.BadRequestException;
import com.creacionpj.exceptions.ResourceNotFoundException;
import com.creacionpj.model.Dote;
import com.creacionpj.model.HuecoDote;
import com.creacionpj.model.Personaje;
import com.creacionpj.model.Requisito;
import com.creacionpj.model.TipoDote;
import com.creacionpj.model.TipoEstadistica;
import com.creacionpj.model.TipoHabilidad;
import com.creacionpj.repositories.DoteRepository;
import com.creacionpj.utils.Constants;

@Service
@Transactional(readOnly = true)
public class DoteService {
    private final DoteRepository doteRepository;

    public DoteService(DoteRepository dr){
        this.doteRepository=dr;
    }

    public List<DoteDTO> findAll(){
        return doteRepository.findAll().stream().map(DoteDTO::from).toList();
    }

    public List<Dote> findByTipo(TipoDote tipo){
        if(tipo==null){throw new BadRequestException(Constants.ENTRADA_VACIA);}
        return doteRepository.findByTipoDote(tipo);
    }

    public List<Dote> findByRequisito(Requisito requisito){
        if(requisito==null){throw new BadRequestException(Constants.ENTRADA_VACIA);}
        return doteRepository.findByRequisitos(requisito);
    }

    public Dote findById(Long id){
        if(id==null){
            throw new BadRequestException(Constants.ENTRADA_VACIA);
        }else if(id<=0){throw new BadRequestException(Constants.ID_FUERA_RANGO);}
        return doteRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(Constants.DOTE_NO_ENCONTRADA));
    }

        public DoteDTO findByIdDTO(Long id){
        if(id==null){
            throw new BadRequestException(Constants.ENTRADA_VACIA);
        }else if(id<=0){throw new BadRequestException(Constants.ID_FUERA_RANGO);}
        return DoteDTO.from(doteRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(Constants.DOTE_NO_ENCONTRADA)));
    }

    public List<Dote> findDisponible(TipoDote tipo, Personaje pj){
        if(tipo==null || pj==null){throw new BadRequestException(Constants.ENTRADA_VACIA);}
        List<Dote> t = findByTipo(tipo);
        if(t==null){throw new ResourceNotFoundException(Constants.DOTE_NO_ENCONTRADA);}
        List<Dote> result = new ArrayList<Dote>();
        for(Dote d:t){
            if(cumpleRequisitos(d, pj)){
                result.add(d);
            }
        } 
        return result;
    }

    public boolean cumpleRequisitos(Dote d, Personaje pj){
        if(d==null || pj==null){throw new BadRequestException(Constants.ENTRADA_VACIA);}
        if(d.getRequisitos()!=null){
            for(Requisito r: d.getRequisitos()){
                if(!cumpleRequisito(r, pj)){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean cumpleRequisito(Requisito r, Personaje pj){
        if(r==null || pj==null){throw new BadRequestException(Constants.ENTRADA_VACIA);}
        if(r.getRequisito()==null){return true;}
    switch (r.getRequisito()) {
        case NIVEL:
            return pj.getLvl() >= r.getValor();
        case CLASE:
            return pj.getClase().getClase().equals(r.getClase());
        case ASCENDENCIA:
            return pj.getAscendencia().getAscendencia().equals(r.getAscendencia());
        case HABILIDAD:
            return getHabilidadValor(pj, r.getHab()) >= r.getValor();
        case STAT:
            return getStatValor(pj, r.getStat()) >= r.getValor();
        case DOTE_PREVIA:
            List<HuecoDote> dot= pj.getHuecosDotes();
            if(dot==null){ return false;}
            for(HuecoDote hd:dot){
                if(hd.getDote()!= null && hd.getDote().equals(r.getDote())){
                    return true;
                }
            }
            return false;
        case EQUIPO:
            return pj.getEquip().stream()
                .anyMatch(e -> e.getTipo().equals(r.getEquipo()));
        default:
            return false;
    }
}

private int getStatValor(Personaje pj, TipoEstadistica stat){
    if(pj==null || stat==null){throw new BadRequestException(Constants.ENTRADA_VACIA);}
    switch(stat){
        case FUERZA: return pj.getStats().getFuerza();
        case DESTREZA: return pj.getStats().getDestreza();
        case CONSTITUCION: return pj.getStats().getConstitucion();
        case INTELIGENCIA: return pj.getStats().getInteligencia();
        case SABIDURIA: return pj.getStats().getSabiduria();
        case CARISMA: return pj.getStats().getCarisma();
        default: return 0;
    }
}

private int getHabilidadValor(Personaje pj, TipoHabilidad hab){
    if(pj==null || hab==null){throw new BadRequestException(Constants.ENTRADA_VACIA);}
    switch(hab){
        case ARCANO: return pj.getHab().getArcanoComp();
        case ACROBACIAS: return pj.getHab().getAcrobaciasComp();
        case ARTESANIA: return pj.getHab().getArtesaniaComp();
        case ATLETISMO: return pj.getHab().getAtletismoComp();
        case DIPLOMACIA: return pj.getHab().getDiplomaciaComp();
        case ENGANO: return pj.getHab().getEnganoComp();
        case INTERPRETACION: return pj.getHab().getInterpretacionComp();
        case INTIMIDACION: return pj.getHab().getIntimidacionComp();
        case LATROCINIO: return pj.getHab().getLatrocinioComp();
        case MEDICINA: return pj.getHab().getMedicinaComp();
        case NATURALEZA: return pj.getHab().getNaturalezaComp();
        case OCULTISMO: return pj.getHab().getOcultismoComp();
        case RELIGION: return pj.getHab().getReligionComp();
        case SABER: return pj.getHab().getSaberComp();
        case SIGILO: return pj.getHab().getSigiloComp();
        case SOCIEDAD: return pj.getHab().getSociedadComp();
        case SUPERVIVENCIA: return pj.getHab().getSupervivenciaComp();
        default: return 0;
    }
}
}