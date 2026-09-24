package com.creacionpj.model;

import jakarta.persistence.*;
import com.creacionpj.utils.*;

@Entity
@Table(name=Constants.SUBIDA_HABILIDAD_NOM)
public class SubidaHabilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name=Constants.HABS_FIJO)
    private TipoHabilidad hab;

    @Column(name=Constants.VALOR_NOM)
    private int valor;

    public SubidaHabilidad(){}
    public SubidaHabilidad(TipoHabilidad hab, int valor){
        setHab(hab);
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
    
    public TipoHabilidad getHab() {
        return hab;
    }
    public void setHab(TipoHabilidad hab) {
        this.hab = hab;
    }
}
