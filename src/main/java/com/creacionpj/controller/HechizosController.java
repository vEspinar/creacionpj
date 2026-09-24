package com.creacionpj.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creacionpj.DTO.HechizoDTO;
import com.creacionpj.model.TipoCompetenciaCombate;
import com.creacionpj.model.TipoTradicion;
import com.creacionpj.services.HechizoService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/Hechizos")
public class HechizosController {
    private final HechizoService hechizosService;

    public HechizosController(HechizoService hs){
        this.hechizosService=hs;
    }

    @GetMapping
    public ResponseEntity<List<HechizoDTO>> findAll() {
        return ResponseEntity.ok(hechizosService.findAll());
    }
    @GetMapping("/tradicion/{tradicion}")
    public ResponseEntity<List<HechizoDTO>> findByTradicion(@PathVariable TipoTradicion tradicion){
        return ResponseEntity.ok(hechizosService.findByTradicion(tradicion));
    }
    @GetMapping("/tradicion/{tra}/{sal}")
    public ResponseEntity<List<HechizoDTO>> findByTradicionAndSalvacion(@PathVariable TipoTradicion tra, @PathVariable TipoCompetenciaCombate sal) {
        return ResponseEntity.ok(hechizosService.findByTradicionAndSalvacion(tra, sal));
    }
    @GetMapping("/{id}")
    public ResponseEntity<HechizoDTO> findById(@PathVariable  Long id){
        return ResponseEntity.ok(hechizosService.findByIdDTO(id));
    }
}
