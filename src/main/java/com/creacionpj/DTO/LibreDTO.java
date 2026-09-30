package com.creacionpj.DTO;

import java.util.List;

import com.creacionpj.model.Libre;
import com.creacionpj.model.TipoEstadistica;
import com.creacionpj.model.TipoHabilidad;

public record LibreDTO(Long id, List<TipoHabilidad> opcionesHab, List<TipoEstadistica> opcionesStats, int totalOpcionesHab, int totalOpcionesStats) {
    public static LibreDTO from(Libre l){
        return new LibreDTO(l.getId(),l.getOpcionesHabs(),l.getOpcionesStats(), l.getTotalOpcionesHab(),l.getTotalOpcionesStats());
    }
}
