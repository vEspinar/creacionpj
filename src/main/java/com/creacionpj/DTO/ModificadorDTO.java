package com.creacionpj.DTO;

import com.creacionpj.model.Modificador;
import com.creacionpj.model.TipoModificador;

public record ModificadorDTO(Long id, TipoModificador tipo, String objetivo, int valor){

    public static ModificadorDTO from(Modificador mod){
        return new ModificadorDTO(mod.getId(),mod.getTipo(), mod.getObjetivo(), mod.getValor());
    }
    
}
