package com.creacionpj.seeders;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.creacionpj.model.Equipo;
import com.creacionpj.model.Modificador;
import com.creacionpj.model.Rasgo;
import com.creacionpj.model.TipoCategoriaEquipo;
import com.creacionpj.model.TipoEquipo;
import com.creacionpj.model.TipoGrupoEquipo;
import com.creacionpj.repositories.EquipoRepository;
import com.creacionpj.utils.ConstantsEquipo;

@Component 
public class EquipoSeeder {
    private final EquipoRepository er;
    private final RasgoSeeder rs;

    public EquipoSeeder(EquipoRepository er, RasgoSeeder rs){
        this.er=er;
        this.rs=rs;
    }

    public Equipo crearEquipo(TipoEquipo tipo, String nombre, String dano, int precio, List<Modificador> mods, int peso, String efecto, List<Rasgo> rasgos, TipoCategoriaEquipo cat, TipoGrupoEquipo grupo){
        return new Equipo(tipo, nombre, dano, precio, mods, peso, efecto, rasgos, cat, grupo);
    }

    public void cargarEquipo(Equipo equipo){
        if(!er.existsByNombreIgnoreCase(equipo.getNombre())){
            er.save(equipo);
        }
    }

    public void cargaInicialEquipo(){
        Equipo espadaCorta = crearEquipo(TipoEquipo.ARMA, "ESPADA_CORTA", "1d6", 90, new ArrayList<>(),1,ConstantsEquipo.ESPADA_CORTA_DESC, 
        List.of(rs.getRasgo("ágil"),rs.getRasgo("Sutil"),rs.getRasgo("Versátil Cortante")), TipoCategoriaEquipo.SIMPLE, TipoGrupoEquipo.ESPADA);
        cargarEquipo(espadaCorta);
    }
}
