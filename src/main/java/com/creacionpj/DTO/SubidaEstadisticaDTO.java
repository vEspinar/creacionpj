package com.creacionpj.DTO;

import java.util.List;

import com.creacionpj.model.SubidaEstadistica;
import com.creacionpj.model.TipoEstadistica;

public record SubidaEstadisticaDTO(Long id, boolean fijo, TipoEstadistica stat, List<TipoEstadistica> stats, int valor) {
    
    public static SubidaEstadisticaDTO from(SubidaEstadistica se){
        if(se.isEsFijo()){
            return new SubidaEstadisticaDTO(se.getId(),true, se.getStatFijo(), List.of(), se.getValor());
        }else{
            return new SubidaEstadisticaDTO(se.getId(),false, null, List.copyOf(se.getOpcionesDisponibles()), se.getValor());
        }
    }
}
