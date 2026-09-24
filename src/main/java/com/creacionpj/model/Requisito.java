package com.creacionpj.model;

import com.creacionpj.utils.Constants;
import jakarta.persistence.*;
@Entity
@Table(name=Constants.REQUISITO_TABLE_NOM)
public class Requisito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name=Constants.REQUISITOS_NOM)
    private TipoRequisito requisito;
    @Column(name=Constants.VALOR_NOM)
    private int valor;
    @Enumerated(EnumType.STRING)
    @Column(name=Constants.REQUISITO_CLASE)
    private TipoClase clase;
    @Enumerated(EnumType.STRING)
    @Column(name=Constants.REQUISITO_RAZA)
    private TipoRaza raza;
    @ManyToOne
    @JoinColumn(name=Constants.REQUISITO_DOTE)
    private Dote dote;
    @Enumerated(EnumType.STRING)
    @Column(name=Constants.REQUISITO_STAT)
    private TipoEstadistica stat;
    @Enumerated(EnumType.STRING)
    @Column(name=Constants.REQUISITO_EQUIPO)
    private TipoEquipo equipo;
    @Enumerated(EnumType.STRING)
    @Column(name=Constants.REQUISITO_HABILIDAD)
    private TipoHabilidad hab;

    public Requisito(){}
    public Requisito(TipoRequisito req, int valor){
        setRequisito(req);
        setValor(valor);
    }
    public Requisito(TipoClase clase){
        setClase(clase);
        setRequisito(TipoRequisito.CLASE);
    }
    public Requisito(TipoRaza raza){
        setRaza(raza);
        setRequisito(TipoRequisito.RAZA);
    }
    public Requisito(Dote dote){
        setDote(dote);
        setRequisito(TipoRequisito.DOTE_PREVIA);
    }
    public Requisito(TipoEstadistica stat, int valor){
        setStat(stat);
        setValor(valor);
        setRequisito(TipoRequisito.STAT);
    }
    public Requisito(TipoEquipo equipo){
        setEquipo(equipo);
        setRequisito(TipoRequisito.EQUIPO);
    }
    public Requisito(TipoHabilidad hab, int valor){
        setHab(hab);
        setValor(valor);
        setRequisito(TipoRequisito.HABILIDAD);
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public void setRequisito(TipoRequisito requisito) {
        this.requisito = requisito;
    }
    public TipoRequisito getRequisito() {
        return requisito;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public int getValor() {
        return valor;
    }
    public void setClase(TipoClase clase) {
        this.clase = clase;
    }
    public TipoClase getClase() {
        return clase;
    }
    public void setDote(Dote dote) {
        this.dote = dote;
    }
    public Dote getDote() {
        return dote;
    }
    public void setEquipo(TipoEquipo equipo) {
        this.equipo = equipo;
    }
    public TipoEquipo getEquipo() {
        return equipo;
    }
    public void setHab(TipoHabilidad hab) {
        this.hab = hab;
    }
    public TipoHabilidad getHab() {
        return hab;
    }
    public void setStat(TipoEstadistica stat) {
        this.stat = stat;
    }
    public TipoEstadistica getStat() {
        return stat;
    }
    public void setRaza(TipoRaza raza) {
        this.raza = raza;
    }
    public TipoRaza getRaza() {
        return raza;
    }
}
