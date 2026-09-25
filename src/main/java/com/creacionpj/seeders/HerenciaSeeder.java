package com.creacionpj.seeders;

import org.springframework.stereotype.Component;

import com.creacionpj.model.Requisito;
import com.creacionpj.model.Herencia;
import com.creacionpj.model.TipoAscendencia;
import com.creacionpj.model.TipoHerencia;
import com.creacionpj.repositories.HerenciaRepository;

@Component 
public class HerenciaSeeder {
    private final HerenciaRepository hr;
    public HerenciaSeeder(HerenciaRepository hr){this.hr=hr;}

    public Herencia crearHerencia(TipoHerencia nombre, String descripcion, TipoAscendencia ascendencia){
        return new Herencia(nombre, descripcion, new Requisito(ascendencia));
    }

    public void cargarHerencia(Herencia herencia){
        if(!hr.existsByNombre(herencia.getNombre())){
            hr.save(herencia);
        }
    }

    public void cargaInicialHerencia(){
        Herencia elfoArtico = crearHerencia(TipoHerencia.ELFO_ARTICO, "", TipoAscendencia.ELFO);
        cargarHerencia(elfoArtico);
    }
}
