package com.creacionpj.DTO;

import com.creacionpj.model.Rasgo;

public record RasgoDTO(Long id, String nombre, String descripcion){
    
    public static RasgoDTO from(Rasgo rsg){
        return new RasgoDTO(rsg.getId(),rsg.getNombre(), rsg.getDescripcion());
    }
}
