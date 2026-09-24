package com.creacionpj.seeders;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.creacionpj.model.Dote;
import com.creacionpj.model.Rasgo;
import com.creacionpj.model.Raza;
import com.creacionpj.model.SubidaEstadistica;
import com.creacionpj.model.TipoEstadistica;
import com.creacionpj.model.TipoRaza;
import com.creacionpj.model.TipoSubraza;
import com.creacionpj.repositories.RazaRepository;

@Component 
public class RazaSeeder {
    private final RazaRepository rr;
    private final RasgoSeeder rs;

    public RazaSeeder(RazaRepository rr, RasgoSeeder rs){
        this.rr=rr;
        this.rs=rs;
    }
    
    public Raza crearRaza(TipoRaza tiporaza, List<TipoSubraza> subrazas, int vida, int tamano, TipoEstadistica stat1,TipoEstadistica stat2,
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
            return new Raza(tiporaza, subrazas, vida, tamano, stats, statsLibres, velocidad, idiomas, rasgos,dotes);
    }
    
    public List<TipoSubraza> llenarSubrazaList(TipoSubraza... ts){
        List<TipoSubraza> subrazas = new ArrayList<>();
        for(TipoSubraza t : ts){
            subrazas.add(t);
        }
        return subrazas;
    }

    public void cargarRaza(Raza raza){
        if(!rr.existsByRaza(raza.getRaza())){
            rr.save(raza);
        }
    }

    public void cargaInicialRaza(){
        List<TipoSubraza> subrazasElfo = llenarSubrazaList(TipoSubraza.ELFO_ARTICO,TipoSubraza.ELFO_BOSQUE,TipoSubraza.ELFO_CAVERNAS, TipoSubraza.ELFO_SILVANO,
        TipoSubraza.ELFO_SUSURROS, TipoSubraza.ELFO_VIDENTE);
        Raza elfo = crearRaza(TipoRaza.ELFO, subrazasElfo, 6, 2, TipoEstadistica.DESTREZA, TipoEstadistica.INTELIGENCIA, 
            TipoEstadistica.CONSTITUCION, 1, 30, "Común, élfico y tantos como inteligencia", 
            List.of(rs.getRasgo("elfo"), rs.getRasgo("humanoide")), null);
        cargarRaza(elfo);
    }
}
