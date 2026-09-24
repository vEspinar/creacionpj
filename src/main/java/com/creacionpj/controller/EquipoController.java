package com.creacionpj.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creacionpj.DTO.EquipoDTO;
import com.creacionpj.services.EquipoService;

@RestController
@RequestMapping("/api/equipo")
public class EquipoController {
    private final EquipoService equipoService;

    public EquipoController(EquipoService es){
        this.equipoService=es;
    }

    @GetMapping
    public ResponseEntity<List<EquipoDTO>> findAll(){
        return ResponseEntity.ok(equipoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipoDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(equipoService.findByIdDTO(id));
    }
}
