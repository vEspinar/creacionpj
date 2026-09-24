package com.creacionpj.model;

import java.util.List;

import com.creacionpj.utils.*;
import jakarta.persistence.*;

@Entity
@Table(name=Constants.DOTE_TABLE_NOM)
public class Dote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name=Constants.DOTE_NOM)
    private String nombre;
    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn (name= Constants.REQUISITOS_FK)
    private List<Requisito> requisitos;
    @Column(name=Constants.DOTE_DESCRIPCION, columnDefinition = "TEXT")
    private String descripcion;
    @Enumerated(EnumType.STRING)
    @Column(name=Constants.DOTE_TIPO)
    private TipoDote tipoDote;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    @JoinTable(name=Constants.RASGOS_DOTE, joinColumns = @JoinColumn(name=Constants.DOTES_FK), inverseJoinColumns = @JoinColumn(name=Constants.RASGOS_ID))
    private List<Rasgo> rasgos;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name=Constants.MODIFICADOR_DOTE, joinColumns = @JoinColumn(name=Constants.DOTES_FK), inverseJoinColumns = @JoinColumn(name=Constants.MODIFICADOR_FK))
    private List<Modificador> mods;

    public Dote(){}
    public Dote(TipoDote tipo, String nombre, List<Requisito> requisitos, String descripcion, List<Rasgo> rasgos, List<Modificador> mods){
        setTipoDote(tipo);
        setNombre(nombre);
        setRequisitos(requisitos);
        setDescripcion(descripcion);
        setRasgos(rasgos);
        setMods(mods);
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
    public void setMods(List<Modificador> mods) {
        this.mods = mods;
    }
    public List<Modificador> getMods() {
        return mods;
    }
    public void setTipoDote(TipoDote dote) {
        this.tipoDote = dote;
    }
    public TipoDote getTipoDote() {
        return tipoDote;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void setRequisitos(List<Requisito> requisitos) {
        this.requisitos = requisitos;
    }
    public List<Requisito> getRequisitos() {
        return requisitos;
    }
    public void setRasgos(List<Rasgo> rasgos) {
        this.rasgos = rasgos;
    }
    public List<Rasgo> getRasgos() {
        return rasgos;
    }
}
