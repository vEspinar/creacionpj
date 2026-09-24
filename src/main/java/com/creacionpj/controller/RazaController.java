package com.creacionpj.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creacionpj.DTO.RazaDTO;
import com.creacionpj.services.RazaService;

@RestController
@RequestMapping("/api/razas")
public class RazaController {
    private final RazaService razaService;
    public RazaController(RazaService rs){
        this.razaService=rs;
    }

    @GetMapping
    public ResponseEntity<List<RazaDTO>> findAll(){
        return ResponseEntity.ok(razaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RazaDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(razaService.findByIdDTO(id));
    }
    
}
