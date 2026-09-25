package com.creacionpj.seeders;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.creacionpj.model.Dote;
import com.creacionpj.model.Rasgo;
import com.creacionpj.model.Ascendencia;
import com.creacionpj.model.SubidaEstadistica;
import com.creacionpj.model.TipoEstadistica;
import com.creacionpj.model.TipoAscendencia;
import com.creacionpj.model.TipoHerencia;
import com.creacionpj.repositories.AscendenciaRepository;

@Component 
public class AscendenciaSeeder {
    private final AscendenciaRepository ar;
    private final RasgoSeeder rs;

    public AscendenciaSeeder(AscendenciaRepository ar, RasgoSeeder rs){
        this.ar=ar;
        this.rs=rs;
    }
    
    public Ascendencia crearAscendencia(TipoAscendencia tipoAscendencia, List<TipoHerencia> herencias, int vida, int tamano, TipoEstadistica stat1,TipoEstadistica stat2,
        TipoEstadistica statnegativo, int statsLibres, int velocidad, String idiomas, List<Rasgo> rasgos, List<Dote> dotes){
            List<SubidaEstadistica> stats = new ArrayList<>();
            if(stat1!=null){
                stats.add(new SubidaEstadistica(stat1,1));
            }
            if(stat2!=null){
                stats.add(new SubidaEstadistica(stat2, 1));
            }
            if(statnegativo!=null){
                stats.add(new SubidaEstadistica(statnegativo,(-1)));
            }
            return new Ascendencia(tipoAscendencia, herencias, vida, tamano, stats, statsLibres, velocidad, idiomas, rasgos,dotes);
    }
    
    public List<TipoHerencia> llenarHerenciaList(TipoHerencia... ts){
        List<TipoHerencia> herencias = new ArrayList<>();
        for(TipoHerencia t : ts){
            herencias.add(t);
        }
        return herencias;
    }

    public void cargarAscendencia(Ascendencia ascendencia){
        if(!ar.existsByAscendencia(ascendencia.getAscendencia())){
            ar.save(ascendencia);
        }
    }

    public void cargaInicialAscendencia(){
        List<TipoHerencia> herenciasElfo = llenarHerenciaList(TipoHerencia.ELFO_ARTICO,TipoHerencia.ELFO_BOSQUE,TipoHerencia.ELFO_CAVERNAS, TipoHerencia.ELFO_SILVANO,
        TipoHerencia.ELFO_SUSURROS, TipoHerencia.ELFO_VIDENTE);
        Ascendencia elfo = crearAscendencia(TipoAscendencia.ELFO, herenciasElfo, 6, 2, TipoEstadistica.DESTREZA, TipoEstadistica.INTELIGENCIA, 
            TipoEstadistica.CONSTITUCION, 1, 30, "Común, élfico y tantos como inteligencia", 
            List.of(rs.getRasgo("elfo"), rs.getRasgo("humanoide")), null);
        cargarAscendencia(elfo);
    }
}
