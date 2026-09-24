package com.creacionpj.model;

import jakarta.persistence.*;

import java.util.List;

import com.creacionpj.utils.*;
@Entity
@Table(name=Constants.HECHIZOS_NOM_TABLE)

public class Hechizo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
    @Column(name=Constants.HECHIZOS_NIVEL)
    private int nivel;
    @Column(name=Constants.HECHIZOS_NOM)
    private String nombre;
    @Column(name=Constants.HECHIZOS_DESCRIPCION, columnDefinition = "TEXT")
    private String descripcion;
    @Column(name=Constants.HECHIZOS_DANO)
    private String dano;
    @Column(name=Constants.HECHIZOS_POTENCIA_LVL)
    private String potenciadoLvl;
    @Column(name=Constants.HECHIZOS_POTENCIA_EFECTO)
    private String potenciadoEfect;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    @JoinTable(name=Constants.RASGOS_HECHIZO, joinColumns = @JoinColumn(name=Constants.HECHIZO_FK), inverseJoinColumns = @JoinColumn(name=Constants.RASGOS_ID))
    private List<Rasgo> rasgos;
    @ElementCollection
    @CollectionTable(name=Constants.HECHIZOS_TRADICION, joinColumns = @JoinColumn(name=Constants.HECHIZO_FK))
    @Enumerated(EnumType.STRING)
    @Column(name=Constants.TRADICION_NOM)
    private List<TipoTradicion> tradicion;
    @ElementCollection
    @CollectionTable(name=Constants.HECHIZOS_ACCIONES, joinColumns = @JoinColumn(name=Constants.HECHIZO_FK))
    @Enumerated(EnumType.STRING)
    @Column(name=Constants.ACCIONES_NOM)
    private List<TipoAccion> acciones;
    @Enumerated(EnumType.STRING)
    @Column(name=Constants.HECHIZOS_SALVACION)
    private TipoCompetenciaCombate salvacion;
    @Column(name=Constants.HECHIZOS_ALCANCE)
    private String alcance;
    @Column(name=Constants.HECHIZOS_AREA)
    private String area;
    @Column(name=Constants.HECHIZOS_OBJETIVOS)
    private String objetivo;    
    @Column(name=Constants.HECHIZOS_DURACION)
    private String duracion;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name=Constants.MODIFICADOR_HECHIZO, joinColumns = @JoinColumn(name=Constants.HECHIZO_FK), inverseJoinColumns = @JoinColumn(name=Constants.MODIFICADOR_FK))
    private List<Modificador> mods;

    public Hechizo(){}
    public Hechizo(int lvl,String nombre, String descripcion, String dano, String potLvl, String potEf, List<Rasgo> rasgos, List<TipoTradicion> tradicion,
        List<TipoAccion> acciones, TipoCompetenciaCombate salvacion, String alcance, String area, String objetivo, String duracion, List<Modificador> mods){
            setNivel(lvl);
            setNombre(nombre);
            setDescripcion(descripcion);
            setDano(dano);
            setPotenciadoLvl(potLvl);
            setPotenciadoEfect(potEf);
            setRasgos(rasgos);
            setTradicion(tradicion);
            setAcciones(acciones);
            setSalvacion(salvacion);
            setAlcance(alcance);
            setArea(area);
            setObjetivo(objetivo);
            setDuracion(duracion);      
            setMods(mods);
        }

    public long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public List<TipoAccion> getAcciones() {
        return acciones;
    }
    public void setAcciones(List<TipoAccion> acciones) {
        this.acciones = acciones;
    }
    public String getAlcance() {
        return alcance;
    }
    public void setAlcance(String alcance) {
        this.alcance = alcance;
    }
    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }
    public String getDano() {
        return dano;
    }
    public void setDano(String dano) {
        this.dano = dano;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getDuracion() {
        return duracion;
    }
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
    public void setMods(List<Modificador> mods) {
        this.mods = mods;
    }
    public List<Modificador> getMods() {
        return mods;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public String getObjetivo() {
        return objetivo;
    }
    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }
    public String getPotenciadoEfect() {
        return potenciadoEfect;
    }
    public void setPotenciadoEfect(String potenciadoEfect) {
        this.potenciadoEfect = potenciadoEfect;
    }
    public String getPotenciadoLvl() {
        return potenciadoLvl;
    }
    public void setPotenciadoLvl(String potenciadoLvl) {
        this.potenciadoLvl = potenciadoLvl;
    }public List<Rasgo> getRasgos() {
        return rasgos;
    }
    public void setRasgos(List<Rasgo> rasgos) {
        this.rasgos = rasgos;
    }
    public TipoCompetenciaCombate getSalvacion() {
        return salvacion;
    }
    public void setSalvacion(TipoCompetenciaCombate salvacion) {
        this.salvacion = salvacion;
    }
    public List<TipoTradicion> getTradicion() {
        return tradicion;
    }
    public void setTradicion(List<TipoTradicion> tradicion) {
        this.tradicion = tradicion;
    }
}
