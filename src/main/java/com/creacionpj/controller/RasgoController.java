package com.creacionpj.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.creacionpj.model.Rasgo;
import com.creacionpj.services.RasgoService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController 
@RequestMapping ("/api/Rasgos") 
public class RasgoController {
    private final RasgoService rs;

    public RasgoController(RasgoService rs){this.rs=rs;}

    @GetMapping()
    public ResponseEntity<List<Rasgo>> findAll() {
        return ResponseEntity.ok(rs.findAll());
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<Rasgo> findByNombre(@PathVariable String nombre){
        return ResponseEntity.ok(rs.findByNombre(nombre));
    }
}
