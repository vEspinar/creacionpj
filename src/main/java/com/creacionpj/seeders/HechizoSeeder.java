package com.creacionpj.seeders;

import java.util.List;

import org.springframework.stereotype.Component;

import com.creacionpj.model.Hechizo;
import com.creacionpj.model.Modificador;
import com.creacionpj.model.Rasgo;
import com.creacionpj.model.TipoAccion;
import com.creacionpj.model.TipoCompetenciaCombate;
import com.creacionpj.model.TipoTradicion;
import com.creacionpj.repositories.HechizoRepository;

@Component 
public class HechizoSeeder {
    private final HechizoRepository hr;
    private final RasgoSeeder rs;

    public HechizoSeeder(HechizoRepository hr, RasgoSeeder rs){
        this.hr=hr;
        this.rs=rs;
    }

        public Hechizo crearHechizo(int lvl, String nombre, String descripcion, String dano, String potLvl, String potEfecto, List<Rasgo> rasgos,
        List<TipoTradicion> tradiciones, List<TipoAccion> acciones, TipoCompetenciaCombate salvacion, String alcance, String area, String objetivo,
        String duracion, List<Modificador> mods){
        return new Hechizo(lvl, nombre, descripcion, dano, potLvl, potEfecto, rasgos, tradiciones, acciones, salvacion, alcance, area,
             objetivo, duracion, mods);
    }

    public void cargarHechizo(Hechizo hechizo){
        if(!hr.existsByNombreIgnoreCase(hechizo.getNombre())){
            hr.save(hechizo);
        }
    }

    public void cargaInicialHechizo(){
        Hechizo bolaDeFuego = crearHechizo(3, "Bola de Fuego", "Una rugiente explosión de fuego aparece en un lugar designado por ti, infligiendo 6d6 daño por fuego.",
            "6d6", "+1", "+2d6", List.of(rs.getRasgo("Evocación")), List.of(TipoTradicion.ARCANA, TipoTradicion.PRIMIGENIA),
            List.of(TipoAccion.DOS_ACCIONES), TipoCompetenciaCombate.REFLEJOS, "500p", "20p explosion", "area", null, null);
        cargarHechizo(bolaDeFuego);
    }
}
