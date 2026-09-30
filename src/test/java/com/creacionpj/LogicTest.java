package com.creacionpj;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.creacionpj.DTO.SeleccionEstadisticasDTO;
import com.creacionpj.DTO.SeleccionHabilidadesDTO;
import com.creacionpj.exceptions.BadRequestException;
import com.creacionpj.model.Ascendencia;
import com.creacionpj.model.Bagaje;
import com.creacionpj.model.Clase;
import com.creacionpj.model.CompetenciaCombate;
import com.creacionpj.model.Dote;
import com.creacionpj.model.Estadistica;
import com.creacionpj.model.Habilidad;
import com.creacionpj.model.Herencia;
import com.creacionpj.model.HuecoDote;
import com.creacionpj.model.Libre;
import com.creacionpj.model.Personaje;
import com.creacionpj.model.Requisito;
import com.creacionpj.model.SubidaEstadistica;
import com.creacionpj.model.SubidaHabilidad;
import com.creacionpj.model.TipoAscendencia;
import com.creacionpj.model.TipoClase;
import com.creacionpj.model.TipoDote;
import com.creacionpj.model.TipoEstadistica;
import com.creacionpj.model.TipoHabilidad;
import com.creacionpj.model.TipoHerencia;
import com.creacionpj.services.DoteService;
import com.creacionpj.services.PersonajeService;
import com.creacionpj.utils.Constants;

@DisplayName ("Tests de Lógica")
public class LogicTest {
    private final DoteService ds = new DoteService(null);
    private final PersonajeService ps = new PersonajeService(null, null, null, null, null, null,ds);

    Personaje crearPj(){
        Estadistica stats = new Estadistica(10, 10, 10, 10, 10, 10);
        Ascendencia as = new Ascendencia(TipoAscendencia.ELFO, new ArrayList<>(), 10, 2, new ArrayList<>(), 0, 25, null, null, null);
        Herencia he= new Herencia(TipoHerencia.ELFO_ARTICO, null, new Requisito(TipoAscendencia.ELFO));
        as.getHerencia().add(he.getNombre());
        Bagaje ba = new Bagaje(null, null, List.of(TipoEstadistica.CARISMA), List.of(new SubidaHabilidad(TipoHabilidad.ACROBACIAS, 1)), null);
        Clase cl = new Clase(TipoClase.ALQUIMISTA, List.of(TipoEstadistica.CONSTITUCION), new CompetenciaCombate(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
        List.of(TipoHabilidad.ARCANO), 0, null, null, null, 5, null);
        CompetenciaCombate comp = new CompetenciaCombate(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        Habilidad hab = new Habilidad(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        Libre l = new Libre(List.of(new SubidaEstadistica(TipoEstadistica.DESTREZA,1)), List.of(new SubidaHabilidad(TipoHabilidad.INTERPRETACION,1)));
        Personaje pj = new Personaje(null, cl, ba, null, as, he, l, hab, stats, comp, new ArrayList<>());
        pj.setHuecosDotes(List.of(new HuecoDote(pj,0,null), new HuecoDote(pj, 0, TipoDote.GENERAL)));
        pj.setId(88L);
        return pj;
    }

    @Test void entrenadaSeAplicaANivel1(){
        Libre lib = new Libre();
        Habilidad h1 = new Habilidad(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        Habilidad h2 = ps.subirHabilidades(h1, List.of(new SubidaHabilidad(TipoHabilidad.ATLETISMO, 1)), 1, lib);
        assertEquals(1, h2.getAtletismoComp());
        assertEquals(0, lib.getTotalOpcionesHab());
    }

    @Test void expertoNoPermitidoANivel1(){
        Libre lib = new Libre();
        Habilidad h1 = new Habilidad(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        Habilidad h2 = ps.subirHabilidades(h1,List.of(new SubidaHabilidad(TipoHabilidad.ATLETISMO, 2)), 1, lib);
        assertEquals(0, h2.getAtletismoComp());
        assertEquals(1, lib.getTotalOpcionesHab());
    }
    @Test void calculoVida(){
        Personaje pj = new Personaje();
        pj.setLvl(1);
        pj.setAscendencia(new Ascendencia(TipoAscendencia.ELFO, List.of(TipoHerencia.ELFO_ARTICO), 5, 2, null, 0, 0, null, null, null));
        pj.setHerencia(new Herencia(TipoHerencia.ELFO_ARTICO, null, null));
        pj.setClase(new Clase(TipoClase.GUERRERO, null, null, null, 0, null, null, null, 0, null));
        pj.setStats(new Estadistica(10, 10, 20, 10, 10, 10));
        pj.setVida(ps.cambioVida(pj));
        assertEquals(10, pj.getVida());
        pj.getClase().setVida(5);
        pj.setVida(ps.cambioVida(pj));
        assertEquals(15, pj.getVida());
        pj.setStats(new Estadistica(10, 10, 13, 10, 10, 10));
        pj.setVida(ps.cambioVida(pj));
        assertEquals(11, pj.getVida());
        pj.setStats(new Estadistica(10, 10, 4, 10, 10, 10));
        pj.setVida(ps.cambioVida(pj));
        assertEquals(7, pj.getVida());
        pj.setStats(new Estadistica(10, 10, 7, 10, 10, 10));
        pj.setVida(ps.cambioVida(pj));
        assertEquals(8, pj.getVida());
    }

    @Test void mejoraSumaDos()   { assertEquals(12, ps.calculoEstadistica(10, 1)); }
    @Test void defectoRestaDos() { assertEquals(8,  ps.calculoEstadistica(10, -1)); }

    @Test void subidaSobreDieciocho()   {
        assertEquals(19, ps.calculoEstadistica(18, 1)); 
        assertEquals(18, ps.calculoEstadistica(16, 1));
    }
    
    @Test void bajadaSobreDieciocho()   {
        assertEquals(19, ps.calculoEstadistica(20, -1));
        assertEquals(16, ps.calculoEstadistica(18, -1));
    }

    @Test void requisitosDote(){
        Personaje pj = new Personaje();
        Dote dote1 = new Dote(TipoDote.CLASE, "a", List.of(new Requisito(TipoClase.BARBARO)), null, null, null);
        Dote dote2 = new Dote(TipoDote.CLASE, "b", List.of(new Requisito(TipoClase.ALQUIMISTA)), null, null, null);
        Dote dote3 = new Dote(TipoDote.ASCENDENCIA, "c", List.of(new Requisito(TipoAscendencia.ELFO)),null,null,null);
        Dote dote4 = new Dote(TipoDote.ASCENDENCIA, "d", List.of(new Requisito(TipoAscendencia.ELFO), new Requisito(TipoClase.GUERRERO)),null,null,null);
        Dote dote5 = new Dote(TipoDote.ASCENDENCIA, "e", List.of(new Requisito(TipoAscendencia.ELFO), new Requisito(TipoClase.ALQUIMISTA)),null,null,null);
        Clase cl = new Clase(TipoClase.ALQUIMISTA, null, null, null, 0, null, null, null, 0, null);
        Ascendencia as = new Ascendencia(TipoAscendencia.ELFO, null, 0, 0, null, 0, 0, null, null, null);
        pj.setClase(cl);
        pj.setAscendencia(as);
        assertEquals(false, ds.cumpleRequisitos(dote1, pj));
        assertEquals(true, ds.cumpleRequisitos(dote2, pj));
        assertEquals(true, ds.cumpleRequisitos(dote3, pj));
        assertEquals(false, ds.cumpleRequisitos(dote4, pj));
        assertEquals(true, ds.cumpleRequisitos(dote5, pj));
    }
    //Test SelectDote, Hab y Stats
    @Test void selecDote(){
        Personaje pj = crearPj();
        Dote dote1 = new Dote(TipoDote.GENERAL, "a", null, null, null, null);
        HuecoDote h1= new HuecoDote(pj, 1, TipoDote.GENERAL);
        HuecoDote h2= new HuecoDote(pj,1,TipoDote.HABILIDAD);
        h1.setId(88L);
        h2.setId(99L);
        pj.setHuecosDotes(List.of(h1, h2));
        ps.aplicarDoteSelect(pj, 88L, dote1);
        assertEquals(dote1,pj.getHuecosDotes().getFirst().getDote());
    }
    @Test void selectHab(){
        Personaje pj = crearPj();
        pj.getLibre().setTotalOpcionesHab(10);
        SeleccionHabilidadesDTO sh = new SeleccionHabilidadesDTO(List.of(TipoHabilidad.ACROBACIAS));
        SeleccionHabilidadesDTO sh2 = new SeleccionHabilidadesDTO(List.of(TipoHabilidad.ACROBACIAS, TipoHabilidad.INTIMIDACION));
        SeleccionHabilidadesDTO sh3 = new SeleccionHabilidadesDTO(List.of(TipoHabilidad.ACROBACIAS,TipoHabilidad.ACROBACIAS));
        ps.seleccionaHabs(pj, sh);
        ps.seleccionaHabs(pj, sh2);
        String error = "";
        try{ps.seleccionaHabs(pj, sh3);}catch(BadRequestException e){error = e.getMessage();}        
        assertEquals(1, pj.getHab().getAcrobaciasComp());
        assertEquals(1, pj.getHab().getIntimidacionComp());
        assertEquals(Constants.HABILIDADES_REPETIDAS, error);
        pj.setLvl(3);
        ps.seleccionaHabs(pj, sh);
        assertEquals(2, pj.getHab().getAcrobaciasComp());
    }

    @Test void selectStats(){
        Personaje pj = crearPj();
        String error="";
        pj.getLibre().setTotalOpcionesStats(10);
        SeleccionEstadisticasDTO ss = new SeleccionEstadisticasDTO(List.of(TipoEstadistica.SABIDURIA));
        SeleccionEstadisticasDTO ss2 = new SeleccionEstadisticasDTO(List.of(TipoEstadistica.SABIDURIA, TipoEstadistica.INTELIGENCIA));
        SeleccionEstadisticasDTO ss3= new SeleccionEstadisticasDTO(List.of(TipoEstadistica.FUERZA, TipoEstadistica.FUERZA));
        ps.seleccionaStats(pj, ss);
        assertEquals(12,pj.getStats().getSabiduria());
        ps.seleccionaStats(pj, ss2);
        try{ps.seleccionaStats(pj, ss3);}catch(BadRequestException e){error=e.getMessage();}
        assertEquals(14,pj.getStats().getSabiduria());
        assertEquals(12,pj.getStats().getInteligencia());
        assertEquals(Constants.ESTADISTICAS_REPETIDAS, error);
    }
}

