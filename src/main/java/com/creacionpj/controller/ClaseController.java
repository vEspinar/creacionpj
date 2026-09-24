package com.creacionpj.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creacionpj.DTO.ClaseDTO;
import com.creacionpj.services.ClaseService;

@RestController
@RequestMapping("/api/clases")
public class ClaseController {
    private final ClaseService claseService;
    
    public ClaseController(ClaseService cs){
        this.claseService = cs;
    }

    @GetMapping
    public ResponseEntity<List<ClaseDTO>> findAll(){
        return ResponseEntity.ok(claseService.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ClaseDTO> findByIdDTO(@PathVariable Long id){
        return ResponseEntity.ok(claseService.findByIdDTO(id));
    }

}
