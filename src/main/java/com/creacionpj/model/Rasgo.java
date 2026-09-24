package com.creacionpj.model;

import com.creacionpj.utils.Constants;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
@Table(name=Constants.RASGOS)
public class Rasgo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty ("Nombre")
    @Column(name=Constants.RASGOS_NOMBRE)
    private String nombre;
    @JsonProperty ("Descripción")
    @Column(name=Constants.RASGOS_DESC, columnDefinition = "TEXT")
    private String descripcion;

    public Rasgo(){}
    public Rasgo(String nombre, String descripcion){
        setNombre(nombre);
        setDescripcion(descripcion);
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
}
