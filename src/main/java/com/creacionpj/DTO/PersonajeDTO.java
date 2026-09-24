package com.creacionpj.DTO;

import com.creacionpj.model.Estadistica;
import com.creacionpj.model.Habilidad;
import com.creacionpj.model.Personaje;

public record PersonajeDTO(Long id, String nombre, int lvl, int vida, String clase, String raza, String subraza,
    String bagaje, Estadistica stats, Habilidad habs, int habLibres, int statsLibres){
    
    public static PersonajeDTO from(Personaje pj){
        return new PersonajeDTO(pj.getId(), pj.getNombre(), pj.getLvl(), pj.getVida(), pj.getClase().getClase().name(), 
        pj.getRaza().getRaza().name(), pj.getSubraza().getNombre().name(), pj.getBaga().getNombre(), 
        pj.getStats(), pj.getHab(), pj.getLibre().getTotalOpcionesHab(), pj.getLibre().getTotalOpcionesStats());
    }
}
