package com.creacionpj.DTO;

import com.creacionpj.model.SubRaza;
import com.creacionpj.model.TipoSubraza;

public record SubRazaDTO(Long id, TipoSubraza tipo, String descripcion, RequisitoDTO requisito) {
    public static SubRazaDTO from(SubRaza sr){
        return new SubRazaDTO(sr.getId(),sr.getNombre(), sr.getDesc(), sr.getReq() !=null ? RequisitoDTO.from(sr.getReq()):null);
    }
}
