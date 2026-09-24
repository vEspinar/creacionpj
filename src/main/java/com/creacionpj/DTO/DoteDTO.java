package com.creacionpj.DTO;

import java.util.List;

import com.creacionpj.model.Dote;
import com.creacionpj.model.TipoDote;

public record DoteDTO(Long id, TipoDote tipo, String nombre, List<RequisitoDTO> requisitos, String descripcion, 
    List<RasgoDTO> rasgos, List<ModificadorDTO> mods) {
    
    public static DoteDTO from(Dote d){
        return new DoteDTO(d.getId(),d.getTipoDote(), d.getNombre(), d.getRequisitos().stream().map(RequisitoDTO::from).toList(), d.getDescripcion(), d.getRasgos().stream().map(RasgoDTO::from).toList(),
            d.getMods().stream().map(ModificadorDTO::from).toList());
    }
}
