package com.creacionpj.DTO;

import java.util.List;

import com.creacionpj.model.Equipo;
import com.creacionpj.model.TipoCategoriaEquipo;
import com.creacionpj.model.TipoEquipo;
import com.creacionpj.model.TipoGrupoEquipo;

public record EquipoDTO(Long id, TipoEquipo tipo,String nombre, String dano, int precio, List<ModificadorDTO> mods, 
    int peso, String efecto, List<RasgoDTO> rasgos, TipoCategoriaEquipo categoria, TipoGrupoEquipo grupo) {
    
    public static EquipoDTO from(Equipo eq){
        return new EquipoDTO(eq.getId(),eq.getTipo(), eq.getNombre(), eq.getDano(), eq.getPrecio(), eq.getMods().stream().map(ModificadorDTO::from).toList(), eq.getPeso(),
            eq.getDescripcion(), eq.getRasgos().stream().map(RasgoDTO::from).toList(), eq.getCategoria(), eq.getGrupo());
    }
}
