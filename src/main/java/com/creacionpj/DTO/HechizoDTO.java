package com.creacionpj.DTO;

import java.util.List;

import com.creacionpj.model.Hechizo;
import com.creacionpj.model.TipoAccion;
import com.creacionpj.model.TipoCompetenciaCombate;
import com.creacionpj.model.TipoTradicion;

public record HechizoDTO(Long id, int lvl,String nombre, String descripcion, String dano, String potLvl, 
    String potenciarEfecto, List<RasgoDTO> rasgos, List<TipoTradicion> tradicion, List<TipoAccion> acciones, 
    TipoCompetenciaCombate salvacion, String alcance, String area, String objetivo, String duracion, 
    List<ModificadorDTO> mods) {
    
        public static HechizoDTO from(Hechizo h){
        return new HechizoDTO(h.getId(),h.getNivel(), h.getNombre(), h.getDescripcion(), h.getDano(), h.getPotenciadoLvl(),
        h.getPotenciadoEfect(), h.getRasgos().stream().map(RasgoDTO::from).toList(), List.copyOf(h.getTradicion()), List.copyOf(h.getAcciones()), h.getSalvacion(),
        h.getAlcance(), h.getArea(), h.getObjetivo(), h.getDuracion(),h.getMods().stream().map(ModificadorDTO::from).toList());
    }
}
