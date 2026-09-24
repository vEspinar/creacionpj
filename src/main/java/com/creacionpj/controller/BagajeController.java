package com.creacionpj.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creacionpj.DTO.BagajeDTO;
import com.creacionpj.services.BagajeService;

@RestController
@RequestMapping("/api/bagajes")
public class BagajeController {
    private final BagajeService bagajeService;
    public BagajeController(BagajeService bs){
        this.bagajeService=bs;
    }

    @GetMapping
    public ResponseEntity<List<BagajeDTO>> findAll(){
        return ResponseEntity.ok(bagajeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BagajeDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(bagajeService.findByIdDTO(id));
    }
}
