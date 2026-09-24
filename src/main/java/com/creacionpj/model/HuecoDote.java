package com.creacionpj.model;
import jakarta.persistence.*;
import com.creacionpj.utils.*;

@Entity
@Table(name=Constants.HUECOS_DOTE_NOM_TABLA)
public class HuecoDote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name=Constants.HUECO_PERSONAJE)
    private Personaje pj;
    @Column(name=Constants.HUECO_NIVEL_DOTE)
    private int nivel;
    @Enumerated(EnumType.STRING)
    @Column(name=Constants.HUECO_TIPO_DOTE)
    private TipoDote tipo;
    @ManyToOne
    @JoinColumn(name=Constants.HUECO_DOTE)
    private Dote dote;

    public HuecoDote(){}
    public HuecoDote(Personaje pj, int lvl, TipoDote tipo){
        setPj(pj);
        setNivel(lvl);
        setTipo(tipo);
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public void setDote(Dote dote) {
        this.dote = dote;
    }
    public Dote getDote() {
        return dote;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public int getNivel() {
        return nivel;
    }
    public void setPj(Personaje pj) {
        this.pj = pj;
    }
    public Personaje getPj() {
        return pj;
    }
    public void setTipo(TipoDote tipo) {
        this.tipo = tipo;
    }
    public TipoDote getTipo() {
        return tipo;
    }
    
}
