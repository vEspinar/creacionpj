package com.creacionpj.model;

import jakarta.persistence.*;
import java.util.List;
import com.creacionpj.utils.*;

@Entity
@Table(name=Constants.PJ_TABLE_NOM)
public class Personaje {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name=Constants.LVL_NOM)
    private int lvl;
    @Column(name=Constants.NOMBRE_NOM)
    private String nombre;

    @ManyToOne
    @JoinColumn(name=Constants.CLASES_FK)
    private Clase clase;
    @ManyToOne
    @JoinColumn(name=Constants.BAGAJE_FK)
    private Bagaje baga;
    @ManyToMany
    @JoinTable(name=Constants.EQUIPO_FK, joinColumns = @JoinColumn(name=Constants.PERSONAJE_ID), inverseJoinColumns =
    @JoinColumn(name=Constants.EQUIPO_ID))
    private List<Equipo> equip;
    @ManyToOne
    @JoinColumn(name=Constants.RAZA_FK)
    private Raza raza;
    @ManyToOne
    @JoinColumn(name=Constants.SUBRAZA_FK)
    private SubRaza subraza;
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name=Constants.LIBRE_FK)
    private Libre libre;
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name=Constants.HABILIDADES_FK)
    private Habilidad hab;
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name= Constants.STATS_FK)
    private Estadistica stats;
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name=Constants.COMPETENCIA_FK)
    private CompetenciaCombate comp;
    @OneToMany(mappedBy = "pj", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HuecoDote> dotes;
    @Column(name=Constants.VIDA_NOM)
    private int vida;
    
    
    public Personaje(){}
    public Personaje(String nom, Clase cl, Bagaje ba, List<Equipo> eq, Raza ra, SubRaza subra, Libre lib, Habilidad hab,
        Estadistica stats, CompetenciaCombate comp, List<HuecoDote> dotes){
        setLvl(1);
        setNombre(nom);
        setClase(cl);
        setBaga(ba);
        setEquip(eq);
        setRaza(ra);
        setSubraza(subra);
        setLibre(lib);
        setHab(hab);
        setStats(stats);
        setComp(comp);
        setHuecosDotes(dotes);
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public void setComp(CompetenciaCombate comp) {
        this.comp = comp;
    }
    public CompetenciaCombate getComp() {
        return comp;
    }
    public void setHuecosDotes(List<HuecoDote> dotes) {
        this.dotes = dotes;
    }
    public List<HuecoDote> getHuecosDotes() {
        return dotes;
    }
    public void setHab(Habilidad hab) {
        this.hab = hab;
    }
    public Habilidad getHab() {
        return hab;
    }
    public void setLibre(Libre libre) {
        this.libre = libre;
    }
    public Libre getLibre() {
        return libre;
    }
    public void setStats(Estadistica stats) {
        this.stats = stats;
    }
    public Estadistica getStats() {
        return stats;
    }
    public void setSubraza(SubRaza subraza) {
        this.subraza = subraza;
    }
    public SubRaza getSubraza() {
        return subraza;
    }
    public void setBaga(Bagaje baga) {
        this.baga = baga;
    }
    public Bagaje getBaga() {
        return baga;
    }
    public void setClase(Clase clase) {
        this.clase = clase;
    }
    public Clase getClase() {
        return clase;
    }
    public void setEquip(List<Equipo> equip) {
        this.equip = equip;
    }
    public List<Equipo> getEquip() {
        return equip;
    }
    public void setLvl(int lvl) {
        this.lvl = lvl;
    }
    public int getLvl() {
        return lvl;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void setRaza(Raza raza) {
        this.raza = raza;
    }
    public Raza getRaza() {
        return raza;
    }   
    public void setVida(int vida) {
        this.vida = vida;
    }
    public int getVida() {
        return vida;
    }
}
