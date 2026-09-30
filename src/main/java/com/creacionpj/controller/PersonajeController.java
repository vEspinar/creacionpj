package com.creacionpj.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.creacionpj.DTO.LibreDTO;
import com.creacionpj.DTO.PersonajeDTO;
import com.creacionpj.DTO.SeleccionEstadisticasDTO;
import com.creacionpj.DTO.SeleccionHabilidadesDTO;
import com.creacionpj.services.*;


@RestController
@RequestMapping("/api/personajes")
public class PersonajeController {
    private final PersonajeService personajeService;

    public PersonajeController(PersonajeService pj){
        this.personajeService=pj;
    }

    @GetMapping
    public ResponseEntity<List<PersonajeDTO>> findAll(){
        return ResponseEntity.ok(personajeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonajeDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok((personajeService.findByIdDTO(id)));
    }

    @PostMapping
    public ResponseEntity<PersonajeDTO> crearPersonaje(@RequestParam Long claseId, @RequestParam Long ascendenciaId,
        @RequestParam Long bagajeId, @RequestParam Long herenciaId){
            return ResponseEntity.ok(personajeService.crearPersonaje(claseId, bagajeId, ascendenciaId, herenciaId)); 
        }
    
    @GetMapping("/{id}/opciones")
    public ResponseEntity<LibreDTO> showLibre(@PathVariable Long id) {
        return ResponseEntity.ok(personajeService.showLibre(id));
    }
    
    @PostMapping("/{id}/estadisticas")
    public ResponseEntity<PersonajeDTO> selectStats(@PathVariable Long id, @RequestBody SeleccionEstadisticasDTO stats) {
        return ResponseEntity.ok(personajeService.selectStatsLibre(id,stats));
    }
    
    @PostMapping("/{id}/habilidades")
    public ResponseEntity<PersonajeDTO> selectHabs(@PathVariable Long id, @RequestBody SeleccionHabilidadesDTO habs) {
        return ResponseEntity.ok(personajeService.selectHabsLibre(id,habs));
    }    

    @PutMapping("/{id}/subir-nivel")
    public ResponseEntity<PersonajeDTO> subirNivel(@PathVariable Long id){
        return ResponseEntity.ok(personajeService.subidaNivel(id));
    }
    @PutMapping("/{id}/bajar-nivel")
    public ResponseEntity<PersonajeDTO> bajarNivel(@PathVariable Long id){
        return ResponseEntity.ok(personajeService.bajadaNivel(id));
    }
    @PostMapping("/{id}/dotes")
    public ResponseEntity<PersonajeDTO> selectDotes(@PathVariable Long id, @RequestParam Long huecoId, @RequestParam Long doteId){
        return ResponseEntity.ok(personajeService.selectDote(id, huecoId,doteId));
    }
}
