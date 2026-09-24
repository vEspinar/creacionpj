package com.creacionpj.model;

import com.creacionpj.utils.RangoEstadistica;
import jakarta.persistence.*;
import com.creacionpj.utils.Constants;
@Entity
@Table(name=Constants.STATS_NOM)
public class Estadistica {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(name=Constants.FUERZA_NOM)
@RangoEstadistica
private int fuerza;
@Column(name=Constants.DESTREZA_NOM)
@RangoEstadistica
private int destreza;
@Column(name=Constants.CONSTITUCION_NOM)
@RangoEstadistica
private int constitucion;
@Column(name=Constants.INTELIGENCIA_NOM)
@RangoEstadistica
private int inteligencia;
@Column(name=Constants.SABIDURIA_NOM)
@RangoEstadistica
private int sabiduria;
@Column(name=Constants.CARISMA_NOM)
@RangoEstadistica
private int carisma;

    public Estadistica(){}
    public Estadistica(int f, int d, int co, int i, int s, int ca){
        setFuerza(f);
        setDestreza(d);
        setConstitucion(co);
        setInteligencia(i);
        setSabiduria(s);
        setCarisma(ca);
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getCarisma() {
        return carisma;
    }
    public void setCarisma(int car) {
        this.carisma = car;
    }
    public int getConstitucion() {
        return constitucion;
    }
    public void setConstitucion(int con) {
        this.constitucion = con;
    }
    public int getDestreza() {
        return destreza;
    }
    public void setDestreza(int des) {
        this.destreza = des;
    }
    public int getFuerza() {
        return fuerza;
    }
    public void setFuerza(int fue) {
        this.fuerza = fue;
    }
    public int getInteligencia() {
        return inteligencia;
    }
    public void setInteligencia(int inte) {
        this.inteligencia = inte;
    }
    public int getSabiduria() {
        return sabiduria;
    }
    public void setSabiduria(int sab) {
        this.sabiduria = sab;
    }


}
