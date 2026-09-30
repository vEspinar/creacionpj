package com.creacionpj.model;

import jakarta.persistence.*;
import com.creacionpj.utils.Constants;

@Entity 
@Table (name=Constants.ELECCION_ESTADISTICAS)
public class EleccionStats {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name=Constants.TIPO_ESTADISTICA)
    private TipoEstadistica stat;
    @Column(name=Constants.LVL_NOM)
    private int lvl;
    @ManyToOne
    @JoinColumn(name=Constants.LIBRE_FK)
    private Libre libre;

    public EleccionStats(){}
    public EleccionStats(TipoEstadistica stat, int lvl){
        setStat(stat);
        setLvl(lvl);
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Libre getLibre() {
        return libre;
    }
    public void setLibre(Libre libre) {
        this.libre = libre;
    }
    public int getLvl() {
        return lvl;
    }
    public void setLvl(int lvl) {
        this.lvl = lvl;
    }
    public TipoEstadistica getStat() {
        return stat;
    }
    public void setStat(TipoEstadistica stat) {
        this.stat = stat;
    }
}
