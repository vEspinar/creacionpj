package com.creacionpj.model;

import jakarta.persistence.*;
import java.util.List;
import com.creacionpj.utils.Constants;

@Entity
@Table(name=Constants.BAGAJE_TABLE_NOM)

public class Bagaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name=Constants.BAGAJE_NOM)
    private String nombre;
    @Column(name=Constants.BAGAJE_DESCRIPCION, columnDefinition = "TEXT")
    private String descripcion;
    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name=Constants.HABILIDADES_BAGAJE)
    private List<SubidaHabilidad> habilidades;
    @ManyToMany (fetch = FetchType.LAZY)
    @JoinTable(name=Constants.DOTES_BAGAJE, joinColumns = @JoinColumn(name=Constants.BAGAJE_FK), inverseJoinColumns = @JoinColumn(name=Constants.DOTES_FK))
    private List<Dote> dotes;
    @ElementCollection
    @CollectionTable(name = Constants.OPCIONES_STATS_BAGAJE, joinColumns = @JoinColumn(name = Constants.BAGAJE_FK))
    @Enumerated(EnumType.STRING)
    @Column(name=Constants.TIPO_ESTADISTICA)
    private List<TipoEstadistica> opcionesEstadisticas;

    public Bagaje(){}
    public Bagaje(String nombre, String descripcion, List<TipoEstadistica> stats, List<SubidaHabilidad> habilidades, List<Dote> dote){
        setNombre(nombre);
        setDescripcion(descripcion);
        setOpcionesEstadisticas(stats);
        setHabilidades(habilidades);
        setDotes(dote);   
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
    public void setDotes(List<Dote> dote) {
        this.dotes = dote;
    }
    public List<Dote> getDotes() {
        return dotes;
    }
    public void setHabilidades(List<SubidaHabilidad> habilidades) {
        this.habilidades = habilidades;
    }
    public List<SubidaHabilidad> getHabilidades() {
        return habilidades;
    }
    public List<TipoEstadistica> getOpcionesEstadisticas() {
        return opcionesEstadisticas;
    }
    public void setOpcionesEstadisticas(List<TipoEstadistica> opcionesEstadistica) {
        this.opcionesEstadisticas = opcionesEstadistica;
    }
}
