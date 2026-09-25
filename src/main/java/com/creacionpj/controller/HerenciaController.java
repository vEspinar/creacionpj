package com.creacionpj.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.creacionpj.DTO.HerenciaDTO;
import com.creacionpj.services.HerenciaService;

@RestController
@RequestMapping("/api/ascendencias/{ascendenciaId}/herencias")
public class HerenciaController {
    private final HerenciaService HerenciaService;
    public HerenciaController(HerenciaService hs){this.HerenciaService=hs;}

    @GetMapping
    public ResponseEntity<List<HerenciaDTO>> findByAscendencia(@PathVariable Long ascendenciaId){
        return ResponseEntity.ok(HerenciaService.findByAscendencia(ascendenciaId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HerenciaDTO> findById(@PathVariable Long ascendenciaId, @PathVariable Long id){
        return ResponseEntity.ok(HerenciaService.findByIdDTO(ascendenciaId,id));
    }
}
