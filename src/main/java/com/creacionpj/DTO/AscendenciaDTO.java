package com.creacionpj.DTO;

import java.util.List;

import com.creacionpj.model.Ascendencia;
import com.creacionpj.model.TipoAscendencia;
import com.creacionpj.model.TipoHerencia;

public record AscendenciaDTO(Long id, TipoAscendencia Ascendencia, List<TipoHerencia> Herencia, int vida, int size, List<SubidaEstadisticaDTO> stats, int statsLibres, int speed, String idiomas, 
        List<RasgoDTO> rasgos, List<DoteDTO> dote) {
    public static AscendenciaDTO from(Ascendencia as){
        return new AscendenciaDTO(as.getId(),as.getAscendencia(), List.copyOf(as.getHerencia()),as.getVida(),as.getSize(),as.getStats().stream().map(SubidaEstadisticaDTO::from).toList(),as.getStatsLibres(),
            as.getSpeed(), as.getIdiomas(),as.getRasgos().stream().map(RasgoDTO::from).toList(),as.getDote().stream().map(DoteDTO::from).toList());
    }
}
