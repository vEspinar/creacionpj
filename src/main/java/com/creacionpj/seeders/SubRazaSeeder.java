package com.creacionpj.seeders;

import org.springframework.stereotype.Component;

import com.creacionpj.model.Requisito;
import com.creacionpj.model.SubRaza;
import com.creacionpj.model.TipoRaza;
import com.creacionpj.model.TipoSubraza;
import com.creacionpj.repositories.RazaRepository;
import com.creacionpj.repositories.SubRazaRepository;

@Component 
public class SubRazaSeeder {
    private final SubRazaRepository sr;
    public SubRazaSeeder(SubRazaRepository sr, RazaRepository rr){this.sr=sr;}

    public SubRaza crearSubRaza(TipoSubraza nombre, String descripcion, TipoRaza raza){
        return new SubRaza(nombre, descripcion, new Requisito(raza));
    }

    public void cargarSubRaza(SubRaza subraza){
        if(!sr.existsByNombre(subraza.getNombre())){
            sr.save(subraza);
        }
    }

    public void cargaInicialSubRaza(){
        SubRaza elfoArtico = crearSubRaza(TipoSubraza.ELFO_ARTICO, "", TipoRaza.ELFO);
        cargarSubRaza(elfoArtico);
    }
}
