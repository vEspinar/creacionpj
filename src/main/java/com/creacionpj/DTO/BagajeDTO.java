package com.creacionpj.DTO;

import java.util.List;

import com.creacionpj.model.Bagaje;
import com.creacionpj.model.TipoEstadistica;

public record BagajeDTO(Long id, String nombre, String descripcion, List<TipoEstadistica> stats, 
    List<SubidaHabilidadDTO> habilidades, List<DoteDTO> dote) {

    public static BagajeDTO from(Bagaje bg){
        return new BagajeDTO(bg.getId(),bg.getNombre(), bg.getDescripcion(), List.copyOf(bg.getOpcionesEstadisticas()), bg.getHabilidades().stream().map(SubidaHabilidadDTO::from).toList(),
            bg.getDotes().stream().map(DoteDTO::from).toList());
    }
}
