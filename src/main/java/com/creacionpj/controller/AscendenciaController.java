package com.creacionpj.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creacionpj.DTO.AscendenciaDTO;
import com.creacionpj.services.AscendenciaService;

@RestController
@RequestMapping("/api/ascendencias")
public class AscendenciaController {
    private final AscendenciaService ascendenciaService;
    public AscendenciaController(AscendenciaService as){
        this.ascendenciaService=as;
    }

    @GetMapping
    public ResponseEntity<List<AscendenciaDTO>> findAll(){
        return ResponseEntity.ok(ascendenciaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AscendenciaDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(ascendenciaService.findByIdDTO(id));
    }
    
}
