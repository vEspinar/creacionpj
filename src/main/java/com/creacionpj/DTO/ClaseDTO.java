package com.creacionpj.DTO;

import java.util.List;

import com.creacionpj.model.Clase;
import com.creacionpj.model.CompetenciaCombate;
import com.creacionpj.model.TipoClase;
import com.creacionpj.model.TipoEstadistica;
import com.creacionpj.model.TipoHabilidad;
import com.creacionpj.model.TipoTradicion;

public record ClaseDTO(Long id, TipoClase clase, List<TipoEstadistica> tipoStats, CompetenciaCombate compBase, 
     List<TipoHabilidad> habi, int lHab, String idiom, String especial, 
        List<DoteDTO> dotes, int vida, TipoTradicion tradicion){
    public static ClaseDTO from(Clase cl){
        return new ClaseDTO(cl.getId(),cl.getClase(), List.copyOf(cl.getOpcionesEstadisticas()), cl.getCompBase(), List.copyOf(cl.getOpcionesHabilidad()),
         cl.getLibreHabilidad(), cl.getIdiomas(), cl.getEspecial(), cl.getDotes().stream().map(DoteDTO::from).toList(), cl.getVida(), cl.getTradicion());
    }
    
}
