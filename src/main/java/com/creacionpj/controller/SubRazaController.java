package com.creacionpj.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.creacionpj.DTO.SubRazaDTO;
import com.creacionpj.services.SubRazaService;

@RestController
@RequestMapping("/api/razas/{razaId}/subrazas")
public class SubRazaController {
    private final SubRazaService subRazaService;
    public SubRazaController(SubRazaService ss){this.subRazaService=ss;}

    @GetMapping
    public ResponseEntity<List<SubRazaDTO>> findByRaza(@PathVariable Long razaId){
        return ResponseEntity.ok(subRazaService.findByRaza(razaId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubRazaDTO> findById(@PathVariable Long razaId, @PathVariable Long id){
        return ResponseEntity.ok(subRazaService.findByIdDTO(razaId,id));
    }
}
