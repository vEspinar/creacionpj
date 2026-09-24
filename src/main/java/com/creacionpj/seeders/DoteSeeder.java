package com.creacionpj.seeders;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.creacionpj.model.Dote;
import com.creacionpj.model.Modificador;
import com.creacionpj.model.Rasgo;
import com.creacionpj.model.Requisito;
import com.creacionpj.model.TipoClase;
import com.creacionpj.model.TipoDote;
import com.creacionpj.model.TipoHabilidad;
import com.creacionpj.model.TipoRequisito;
import com.creacionpj.repositories.DoteRepository;
import com.creacionpj.utils.ConstantsDotes;

@Component 
public class DoteSeeder {
    private final DoteRepository dr;
    private final RasgoSeeder rs;

    public DoteSeeder(DoteRepository dr, RasgoSeeder rs){
        this.dr=dr;
        this.rs=rs;
    }
    
    public Dote crearDote(TipoDote td, String nombre, List<Requisito> requisitos, String descripcion, List<Rasgo> rasgos, List<Modificador> mods){
        return new Dote(td,nombre, requisitos, descripcion, rasgos, mods != null ? mods : List.of());
    }
    
    public void cargarDote(Dote dote){
        if(!dr.existsByNombreIgnoreCase(dote.getNombre())){
            dr.save(dote);
        }
    }

    public void cargaInicialDote(){
        Dote impresionDeGrupo = crearDote(TipoDote.HABILIDAD, "Impresión de Grupo", List.of(new Requisito(TipoHabilidad.DIPLOMACIA,1)), "Puedes causar Impresión a dos objetivos en lugar de 1",
        List.of(rs.getRasgo("GENERAL"), rs.getRasgo ("HABILIDAD")), null);
    Dote intimidacionRapida = crearDote(TipoDote.HABILIDAD, "Intimidación Rápida", List.of(new Requisito(TipoHabilidad.INTIMIDACION,1)), "Intimidas en un asalto en lugar de en 1 minuto",
        List.of(rs.getRasgo("GENERAL"), rs.getRasgo ("HABILIDAD")), null);
    Dote ataqueImprevisto = crearDote(TipoDote.CLASE, ConstantsDotes.ATAQUE_IMPREVISTO_NOM, List.of(new Requisito(TipoClase.GUERRERO), 
        new Requisito(TipoRequisito.NIVEL, 1)), ConstantsDotes.ATAQUE_IMPREVISTO_DESC, List.of(rs.getRasgo("Guerrero"), rs.getRasgo("Ataque")), new ArrayList<>());
        cargarDote(ataqueImprevisto);
        cargarDote(impresionDeGrupo);
        cargarDote(intimidacionRapida);
    }

}
