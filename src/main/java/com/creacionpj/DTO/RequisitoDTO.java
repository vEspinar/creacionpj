package com.creacionpj.DTO;

import com.creacionpj.model.Requisito;
import com.creacionpj.model.TipoClase;
import com.creacionpj.model.TipoEquipo;
import com.creacionpj.model.TipoEstadistica;
import com.creacionpj.model.TipoHabilidad;
import com.creacionpj.model.TipoAscendencia;
import com.creacionpj.model.TipoRequisito;

public record RequisitoDTO(Long id, TipoRequisito tipo, int valor, TipoClase clase, TipoAscendencia ascendencia, String dote, TipoEstadistica stat,
    TipoHabilidad hab, TipoEquipo equipo) {
    
    public static RequisitoDTO from(Requisito r){
        return new RequisitoDTO(r.getId(), r.getRequisito(), r.getValor(), r.getClase(),r.getAscendencia(), r.getDote() !=null ? r.getDote().getNombre():null,
            r.getStat(), r.getHab(), r.getEquipo());
    }
}
