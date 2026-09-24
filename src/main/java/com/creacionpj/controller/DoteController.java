package com.creacionpj.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creacionpj.DTO.DoteDTO;
import com.creacionpj.services.DoteService;

@RestController
@RequestMapping("/api/dotes")
public class DoteController {
    private final DoteService doteService;

    public DoteController(DoteService ds){
        this.doteService=ds;
    }
    @GetMapping
    public ResponseEntity<List<DoteDTO>> findAll(){
        return ResponseEntity.ok(doteService.findAll());
    } 

    @GetMapping("/{id}")
    public ResponseEntity<DoteDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(doteService.findByIdDTO(id));
    }
}
