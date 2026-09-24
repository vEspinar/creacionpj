package com.creacionpj.model;
import jakarta.persistence.*;
import com.creacionpj.utils.*;

@Entity
@Table(name=Constants.HUECO_HECHIZO_NOM_TABLA)
public class HuecoHechizo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name=Constants.HUECO_PERSONAJE)
    private Personaje pj;
    @Column(name=Constants.HUECO_NIVEL_HECHIZO)
    private int nivel;
    @Enumerated(EnumType.STRING)
    @Column(name=Constants.HECHIZOS_TRADICION)
    private TipoTradicion tipo;
    @ManyToOne
    @JoinColumn(name=Constants.HUECO_HECHIZO)
    private Hechizo hechizo;

    public HuecoHechizo(){};
    public HuecoHechizo(Personaje pj, int lvl, TipoTradicion tipo){
        setPj(pj);
        setNivel(lvl);
        setTipo(tipo);
    }

    public void setHechizo(Hechizo hechizo) {
        this.hechizo = hechizo;
    }
    public Hechizo getHechizo() {
        return hechizo;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return id;
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
    public void setTipo(TipoTradicion tipo) {
        this.tipo = tipo;
    }
    public TipoTradicion getTipo() {
        return tipo;
    }
}
