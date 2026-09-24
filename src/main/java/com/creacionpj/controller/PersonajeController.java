package com.creacionpj.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.creacionpj.DTO.PersonajeDTO;
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
    public ResponseEntity<PersonajeDTO> crearPersonaje(@RequestParam Long claseId, @RequestParam Long razaId,
            @RequestParam Long bagajeId, @RequestParam Long subRazaId){
                return ResponseEntity.ok(personajeService.crearPersonaje(claseId, bagajeId, razaId, subRazaId)); 
            }
    @PutMapping("/{id}/subir-nivel")
    public ResponseEntity<PersonajeDTO> subirNivel(@PathVariable Long id){
        return ResponseEntity.ok(personajeService.subidaNivel(id));
    }
}
