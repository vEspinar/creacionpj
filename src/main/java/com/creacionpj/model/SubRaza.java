package com.creacionpj.model;

import jakarta.persistence.*;
import com.creacionpj.utils.*;

@Entity
@Table(name=Constants.SUBRAZA_TABLE_NOM)
public class SubRaza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated (EnumType.STRING)
    @Column(name=Constants.SUBRAZA_NOM)
    private TipoSubraza nombre;
    @Column(name=Constants.SUBRAZA_DESCRIPCION, columnDefinition = "TEXT")
    private String desc;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name=Constants.SUBRAZA_REQUISITO)
    private Requisito req;

    public SubRaza(){}
    public SubRaza(TipoSubraza nombre, String desc, Requisito req){
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
    public void setNombre(TipoSubraza nombre) {
        this.nombre = nombre;
    }
    public TipoSubraza getNombre() {
        return nombre;
    }
    public void setReq(Requisito req) {
        this.req = req;
    }
    public Requisito getReq() {
        return req;
    }

}
