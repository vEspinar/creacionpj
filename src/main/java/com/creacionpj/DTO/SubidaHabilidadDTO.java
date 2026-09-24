package com.creacionpj.DTO;

import com.creacionpj.model.SubidaHabilidad;
import com.creacionpj.model.TipoHabilidad;

public record SubidaHabilidadDTO(Long id, TipoHabilidad hab, int valor) {

    public static SubidaHabilidadDTO from(SubidaHabilidad sh){
        return new SubidaHabilidadDTO(sh.getId(),sh.getHab(), sh.getValor());
    }
}