package com.creacionpj;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.creacionpj.model.Habilidad;
import com.creacionpj.model.Libre;
import com.creacionpj.model.SubidaHabilidad;
import com.creacionpj.model.TipoHabilidad;
import com.creacionpj.services.PersonajeService;

@DisplayName ("Tests de Lógica")
public class LogicTest {

    private final PersonajeService ps = new PersonajeService(null, null, null, null, null, null);

    @Test void entrenadaSeAplicaANivel1(){
        Libre lib = new Libre();
        Habilidad h = ps.subirHabilidades(List.of(new SubidaHabilidad(TipoHabilidad.ATLETISMO, 1)), 1, lib);
        assertEquals(1, h.getAtletismoComp());
        assertEquals(0, lib.getTotalOpcionesHab());
    }

    @Test void expertoNoPermitidoANivel1(){
        Libre lib = new Libre();
        Habilidad h = ps.subirHabilidades(List.of(new SubidaHabilidad(TipoHabilidad.ATLETISMO, 2)), 1, lib);
        assertEquals(0, h.getAtletismoComp());
        assertEquals(1, lib.getTotalOpcionesHab());
    }

    @Test void mejoraSumaDos()   { assertEquals(12, ps.calculoEstadistica(10, 1)); }
    @Test void defectoRestaDos() { assertEquals(8,  ps.calculoEstadistica(10, -1)); }
}

