package com.creacionpj.model;

import jakarta.persistence.*;
import java.util.List;
import com.creacionpj.utils.*;

@Entity
@Table (name=Constants.SUBIDA_NIVEL_NOM)
public class SubidaNivel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name=Constants.LVL_NOM)
    @RangoNivel
    private int lvl;

    @ManyToOne
    @JoinColumn(name=Constants.CLASES_FK)
    private Clase clase;

    @Column(name=Constants.CANTIDAD_HABILIDADES)
    private int cantidadHabilidades;
    @Column(name=Constants.CANTIDAD_DOTES_CLASE)
    private int cantidadDotesC;
    @Column(name=Constants.CANTIDAD_DOTES_HABILIDAD)
    private int cantidadDotesH;
    @Column(name=Constants.CANTIDAD_DOTES_GENERAL)
    private int cantidadDotesG;
    @Column(name=Constants.CANTIDAD_DOTES_ASCENDENCIA)
    private int cantidadDotesR;
    @Column(name=Constants.CANTIDAD_ESTADISTICAS)
    private int cantidadStats;
    @Column(name=Constants.CANTIDAD_COMPETENCIAS)
    private int cantidadComp;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name=Constants.RASGOS_FK)
    private List<Rasgo> rasgos;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name= Constants.SUBIDA_FK)
    private List<SubidaCompetenciaCombate> subidasComp;
    @ElementCollection 
    @CollectionTable (name=Constants.SUBIDA_OTROS_TABLA, joinColumns = @JoinColumn(name=Constants.SUBIDA_NIVEL_FK))
    @Column(name=Constants.SUBIDA_OTROS, columnDefinition = "Text")
    private List<String> otros;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name=Constants.MODIFICADOR_NIVEL, joinColumns = @JoinColumn(name=Constants.SUBIDA_FK), inverseJoinColumns = @JoinColumn(name=Constants.MODIFICADOR_FK))
    private List<Modificador> mods;

    public SubidaNivel(){}
    public SubidaNivel(int lvl, Clase clase){
        setClase(clase);
        setLvl(lvl);
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }
    public Clase getClase() {
        return clase;
    }
    public void setLvl(int lvl) {
        this.lvl = lvl;
    }
    public int getLvl() {
        return lvl;
    }
    public int getCantidadComp() {
        return cantidadComp;
    }
    public void setMods(List<Modificador> mods) {
        this.mods = mods;
    }
    public List<Modificador> getMods() {
        return mods;
    }
    public void setCantidadComp(int cantidadComp) {
        this.cantidadComp = cantidadComp;
    }
    public int getCantidadDotesC() {
        return cantidadDotesC;
    }
    public void setCantidadDotesC(int cantidadDotesC) {
        this.cantidadDotesC = cantidadDotesC;
    }
    public int getCantidadDotesG() {
        return cantidadDotesG;
    }
    public void setCantidadDotesG(int cantidadDotesG) {
        this.cantidadDotesG = cantidadDotesG;
    }
    public int getCantidadDotesH() {
        return cantidadDotesH;
    }
    public void setCantidadDotesH(int cantidadDotesH) {
        this.cantidadDotesH = cantidadDotesH;
    }
    public int getCantidadDotesR() {
        return cantidadDotesR;
    }
    public void setCantidadDotesR(int cantidadDotesR) {
        this.cantidadDotesR = cantidadDotesR;
    }
    public int getCantidadHabilidades() {
        return cantidadHabilidades;
    }
    public void setCantidadHabilidades(int cantidadHabilidades) {
        this.cantidadHabilidades = cantidadHabilidades;
    }
    public int getCantidadStats() {
        return cantidadStats;
    }
    public void setCantidadStats(int cantidadStats) {
        this.cantidadStats = cantidadStats;
    }
    public List<Rasgo> getRasgos() {
        return rasgos;
    }
    public void setRasgos(List<Rasgo> rasgos) {
        this.rasgos = rasgos;
    }
    public List<SubidaCompetenciaCombate> getSubidasComp() {
        return subidasComp;
    }
    public void setSubidasComp(List<SubidaCompetenciaCombate> subidasComp) {
        this.subidasComp = subidasComp;
    }
    public void setOtros(List<String> otros) {
        this.otros = otros;
    }
    public List<String> getOtros() {
        return otros;
    }
}
