package com.creacionpj.model;

import jakarta.persistence.*;
import com.creacionpj.utils.*;

@Entity
@Table(name=Constants.HERENCIA_TABLE_NOM)
public class Herencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated (EnumType.STRING)
    @Column(name=Constants.HERENCIA_NOM)
    private TipoHerencia nombre;
    @Column(name=Constants.HERENCIA_DESCRIPCION, columnDefinition = "TEXT")
    private String desc;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name=Constants.HERENCIA_REQUISITO)
    private Requisito req;

    public Herencia(){}
    public Herencia(TipoHerencia nombre, String desc, Requisito req){
        setNombre(nombre);
        setDesc(desc);
        setReq(req);
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getDesc() {
        return desc;
    }
    public void setNombre(TipoHerencia nombre) {
        this.nombre = nombre;
    }
    public TipoHerencia getNombre() {
        return nombre;
    }
    public void setReq(Requisito req) {
        this.req = req;
    }
    public Requisito getReq() {
        return req;
    }

}
