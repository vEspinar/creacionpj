package com.creacionpj.DTO;

import com.creacionpj.model.Herencia;
import com.creacionpj.model.TipoHerencia;

public record HerenciaDTO(Long id, TipoHerencia tipo, String descripcion, RequisitoDTO requisito) {
    public static HerenciaDTO from(Herencia he){
        return new HerenciaDTO(he.getId(),he.getNombre(), he.getDesc(), he.getReq() !=null ? RequisitoDTO.from(he.getReq()):null);
    }
}
