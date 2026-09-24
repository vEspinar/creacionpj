package com.creacionpj.model;

import jakarta.persistence.*;
import java.util.List;
import com.creacionpj.utils.*;

@Entity
@Table(name=Constants.SUBIDA_STATS_NOM)
public class SubidaEstadistica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name=Constants.PREDETERMINADO_NOM)
    private boolean esFijo;

    @Enumerated(EnumType.STRING)
    @Column(name=Constants.STATS_FIJO)
    private TipoEstadistica statFijo;

    @ElementCollection
    @CollectionTable(name=Constants.STATS_OPCIONES, joinColumns = @JoinColumn(name= Constants.SUBIDA_FK))
    @Enumerated(EnumType.STRING)
    @Column(name=Constants.STATS_NOM)
    private List<TipoEstadistica> opcionesDisponibles;

    @Column(name=Constants.VALOR_NOM)
    private int valor;

    public SubidaEstadistica(){}
    public SubidaEstadistica(TipoEstadistica stat, int valor){
        setEsFijo(true);
        setStatFijo(stat);
        setValor(valor);
    }
    public SubidaEstadistica(List<TipoEstadistica> stats, int valor){
        setEsFijo(false);
        setOpcionesDisponibles(stats);
        setValor(valor);
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public boolean isEsFijo() {
        return esFijo;
    }
    public void setEsFijo(boolean esFijo) {
        this.esFijo = esFijo;
    }
    public TipoEstadistica getStatFijo() {
        return statFijo;
    }
    public void setStatFijo(TipoEstadistica statFijo) {
        this.statFijo = statFijo;
    }
    public List<TipoEstadistica> getOpcionesDisponibles() {
        return opcionesDisponibles;
    }
    public void setOpcionesDisponibles(List<TipoEstadistica> opcionesDisponibles) {
        this.opcionesDisponibles = opcionesDisponibles;
    }
}
