package com.creacionpj.model;

import java.util.List;
import com.creacionpj.utils.Constants;
import jakarta.persistence.*;

/**
 * @author User
 * @version 1.0
 * @see Clase
 */ 

@Entity
@Table (name = Constants.CLASES_TABLA_NOM)

public class Clase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name=Constants.CLASE_NOMBRE, unique = true)
    private TipoClase clase;
    @Column(name=Constants.IDIOMAS)
    private String idiomas;
    @Column(name=Constants.ESPECIAL)
    private String especial;
    @Column(name=Constants.VIDA_NOM)
    private int vida;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = Constants.COMPETENCIAS_BASE)
    private CompetenciaCombate compBase;
    @OneToMany
    @JoinTable(name=Constants.DOTES, joinColumns = @JoinColumn(name=Constants.CLASE_ID), inverseJoinColumns = @JoinColumn(name=Constants.DOTE_ID))
    private List<Dote> dotes;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name=Constants.CLASES_FK)
    private List<SubidaNivel> progresion;
    @ElementCollection
    @CollectionTable(name = Constants.OPCIONES_STATS_CLASE, joinColumns = @JoinColumn(name = Constants.CLASES_FK))
    @Enumerated(EnumType.STRING)
    @Column(name=Constants.TIPO_ESTADISTICA)
    private List<TipoEstadistica> opcionesEstadisticas;
    @ElementCollection
    @CollectionTable(name = Constants.OPCIONES_HABILIDAD, joinColumns = @JoinColumn(name = Constants.CLASES_FK))
    @Enumerated(EnumType.STRING)
    @Column(name=Constants.TIPO_HABILIDAD)
    private List<TipoHabilidad> opcionesHabilidad;
    @Column(name=Constants.HABILIDADES_LIBRE)
    private int libreHabilidad;
    @Enumerated(EnumType.STRING)
    @Column(name=Constants.CLASE_TRADICION)
    private TipoTradicion tradicion;

    public Clase(){}
    public Clase(TipoClase clase, List<TipoEstadistica> tipoStats, CompetenciaCombate compBase, 
     List<TipoHabilidad> habi, int lHab, String idiom, String especial, 
        List<Dote> dotes, int vida, TipoTradicion tradicion){
        setClase(clase);
        setCompBase(compBase);
        setOpcionesEstadisticas(tipoStats);
        setOpcionesHabilidad(habi);
        setLibreHabilidad(lHab);
        setIdiomas(idiom);
        setEspecial(especial);
        setDotes(dotes);
        setVida(vida);
        setTradicion(tradicion);
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public CompetenciaCombate getCompBase() {
        return compBase;
    }
    public void setCompBase(CompetenciaCombate compBase) {
        this.compBase = compBase;
    }
    public void setClase(TipoClase clase) {
        this.clase = clase;
    }
    public TipoClase getClase() {
        return clase;
    }
    public void setDotes(List<Dote> dotes) {
        this.dotes = dotes;
    }
    public List<Dote> getDotes() {
        return dotes;
    }
    public void setEspecial(String especial) {
        this.especial = especial;
    }
    public String getEspecial() {
        return especial;
    }
    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }
    public String getIdiomas() {
        return idiomas;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }
    public int getVida() {
        return vida;
    }
    public List<SubidaNivel> getProgresion() {
        return progresion;
    }
    public void setProgresion(List<SubidaNivel> progresion) {
        this.progresion = progresion;
    }
    public void setOpcionesEstadisticas(List<TipoEstadistica> opcionesEstadisticas) {
        this.opcionesEstadisticas = opcionesEstadisticas;
    }
    public List<TipoEstadistica> getOpcionesEstadisticas() {
        return opcionesEstadisticas;
    }
    public void setOpcionesHabilidad(List<TipoHabilidad> opcionesHabilidad) {
        this.opcionesHabilidad = opcionesHabilidad;
    }
    public List<TipoHabilidad> getOpcionesHabilidad() {
        return opcionesHabilidad;
    }
    public void setLibreHabilidad(int libreHabilidad) {
        this.libreHabilidad = libreHabilidad;
    }
    public int getLibreHabilidad() {
        return libreHabilidad;
    }
    public void setTradicion(TipoTradicion tradicion) {
        this.tradicion = tradicion;
    }
    public TipoTradicion getTradicion() {
        return tradicion;
    }
}

