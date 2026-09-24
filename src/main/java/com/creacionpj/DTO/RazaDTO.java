package com.creacionpj.DTO;

import java.util.List;

import com.creacionpj.model.Raza;
import com.creacionpj.model.TipoRaza;
import com.creacionpj.model.TipoSubraza;

public record RazaDTO(Long id, TipoRaza raza, List<TipoSubraza> sub, int vida, int size, List<SubidaEstadisticaDTO> stats, int statsLibres, int speed, String idiomas, 
        List<RasgoDTO> rasgos, List<DoteDTO> dote) {
    public static RazaDTO from(Raza rz){
        return new RazaDTO(rz.getId(),rz.getRaza(), List.copyOf(rz.getSubRaza()),rz.getVida(),rz.getSize(),rz.getStats().stream().map(SubidaEstadisticaDTO::from).toList(),rz.getStatsLibres(),
            rz.getSpeed(), rz.getIdiomas(),rz.getRasgos().stream().map(RasgoDTO::from).toList(),rz.getDote().stream().map(DoteDTO::from).toList());
    }
}
