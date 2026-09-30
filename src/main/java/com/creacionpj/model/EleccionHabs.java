package com.creacionpj.model;

import com.creacionpj.utils.Constants;
import jakarta.persistence.*;

@Entity 
@Table (name=Constants.ELECCION_HABILIDADES)
public class EleccionHabs {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name=Constants.TIPO_HABILIDAD)
    private TipoHabilidad hab;
    @Column(name=Constants.LVL_NOM)
    private int lvl;
    @ManyToOne
    @JoinColumn(name=Constants.LIBRE_FK)
    private Libre libre;

    public EleccionHabs(){}
    public EleccionHabs(TipoHabilidad hab, int lvl){
        setHab(hab);
        setLvl(lvl);
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public void setLibre(Libre libre) {
        this.libre = libre;
    }
    public Libre getLibre() {
        return libre;
    }
    public void setHab(TipoHabilidad hab) {
        this.hab = hab;
    }
    public TipoHabilidad getHab() {
        return hab;
    }
    public void setLvl(int lvl) {
        this.lvl = lvl;
    }
    public int getLvl() {
        return lvl;
    }
}
