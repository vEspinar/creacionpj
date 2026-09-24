package com.creacionpj.seeders;

import java.util.List;
import org.springframework.stereotype.Component;
import com.creacionpj.model.Bagaje;
import com.creacionpj.model.Dote;
import com.creacionpj.model.SubidaHabilidad;
import com.creacionpj.model.TipoEstadistica;
import com.creacionpj.model.TipoHabilidad;
import com.creacionpj.repositories.BagajeRepository;
import com.creacionpj.repositories.DoteRepository;

@Component 
public class BagajeSeeder {
    private final BagajeRepository br;
    private final DoteRepository dr;

    public BagajeSeeder(BagajeRepository br, DoteRepository dr){
        this.br = br;
        this.dr=dr;
    }

    public Bagaje crearBagaje(String nombre, String descripcion, TipoEstadistica te1, TipoEstadistica te2, TipoHabilidad th1, TipoHabilidad th2,
        List<Dote> dotes){
            SubidaHabilidad sh1 = new SubidaHabilidad(th1, 1);
            SubidaHabilidad sh2= new SubidaHabilidad(th2, 1);
        return new Bagaje(nombre, descripcion, List.of(te1, te2), List.of(sh1, sh2), dotes != null ? dotes : List.of());
    }

    public void cargarBagaje(Bagaje bag){
        if(!br.existsByNombreIgnoreCase(bag.getNombre())){
            br.save(bag);
        }
    }
    public void cargaInicialBagaje(){
            Bagaje guardia = crearBagaje("Guardia"," ", TipoEstadistica.FUERZA, TipoEstadistica.CARISMA, TipoHabilidad.ATLETISMO,
        TipoHabilidad.SABER, List.of(dr.findByNombreIgnoreCase("Intimidación Rápida")));

    Bagaje abogado = crearBagaje("Abogado", "Instruido en asuntos legales", TipoEstadistica.INTELIGENCIA, TipoEstadistica.CARISMA, 
        TipoHabilidad.DIPLOMACIA, TipoHabilidad.SABER, List.of(dr.findByNombreIgnoreCase("Impresión de Grupo")));
    cargarBagaje(guardia);
    cargarBagaje(abogado);
    }
}
