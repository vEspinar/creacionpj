package com.creacionpj.seeders;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.creacionpj.model.Clase;
import com.creacionpj.model.CompetenciaCombate;
import com.creacionpj.model.Dote;
import com.creacionpj.model.TipoClase;
import com.creacionpj.model.TipoEstadistica;
import com.creacionpj.model.TipoHabilidad;
import com.creacionpj.model.TipoTradicion;
import com.creacionpj.repositories.ClaseRepository;
import com.creacionpj.repositories.DoteRepository;
import com.creacionpj.utils.ConstantsDotes;

@Component 
public class ClaseSeeder {
    private final ClaseRepository cr;
    private final DoteRepository dr;

    public ClaseSeeder(ClaseRepository cr, DoteRepository dr){
        this.cr=cr;
        this.dr=dr;
    }

     public Clase crearClase(TipoClase clase, TipoEstadistica stat1, TipoEstadistica stat2, int sinarmadura, int armaduraLigera, 
        int armaduraMedia, int armaduraPesada, int fortaleza, int reflejos, int voluntad, int sinArmas, int armaSimple, int armaMarcial, 
        int armaAvanzada, int percepcion, int cdClase, int cdConjuro, TipoHabilidad hab1, TipoHabilidad hab2, int habLibres, String idiomas, 
        String especial, List<Dote> dotes, int vida, TipoTradicion tradicion){
            List<TipoEstadistica> stats = new ArrayList<>();
            stats.add(stat1);
            stats.add(stat2);
            CompetenciaCombate cc = new CompetenciaCombate(sinarmadura, armaduraLigera, armaduraMedia, armaduraPesada, fortaleza, reflejos,
                voluntad, sinArmas, armaSimple, armaMarcial, armaAvanzada, percepcion, cdClase, cdConjuro);
            List<TipoHabilidad> habs = new ArrayList<>();
            habs.add(hab1);
            habs.add(hab2);
        return new Clase(clase, stats, cc, habs, habLibres, idiomas, especial, dotes, vida, tradicion);
    }

    public void cargarClase(Clase clase){
        if(!cr.existsByClase(clase.getClase())){
            cr.save(clase);
        }
    }

    public Clase findClaseByNombre(TipoClase nombre){
        return cr.findByClase(nombre);
    }

    public TipoEstadistica claseStats(String stat){
        switch(stat){
            case "f":{return TipoEstadistica.FUERZA;}
            case "d":{return TipoEstadistica.DESTREZA;}
            case "co":{return TipoEstadistica.CONSTITUCION;} 
            case "i":{return TipoEstadistica.INTELIGENCIA;}
            case "s":{return TipoEstadistica.SABIDURIA;}
            case "ca":{return TipoEstadistica.CARISMA;}
            default: return null;
        }
    }

    public void cargaInicialClase(){
        Clase guerrero = crearClase(TipoClase.GUERRERO, claseStats("f"), claseStats("d"), 1, 1, 1, 1,2,
            2, 1, 2, 2, 2, 1, 2, 1, 0, TipoHabilidad.ACROBACIAS, TipoHabilidad.ATLETISMO, 
            3, null, null, List.of(dr.findByNombreIgnoreCase(ConstantsDotes.ATAQUE_IMPREVISTO_NOM)), 10, null);
        cargarClase(guerrero);
    }
}
