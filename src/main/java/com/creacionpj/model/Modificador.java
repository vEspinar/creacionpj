package com.creacionpj.model;

import jakarta.persistence.*;
import com.creacionpj.utils.*;

@Entity
@Table(name=Constants.MODIFICADOR_NOM_TABLE)
public class Modificador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name=Constants.MODIFICADOR_TIPO)
    private TipoModificador tipo;
    @Column(name=Constants.MODIFICADOR_VALOR)
    private int valor;
    @Column(name=Constants.MODIFICIADOR_OBJETIVO)
    private String objetivo;

    public Modificador(){}
    public Modificador(TipoModificador tipo, String objetivo, int valor){
        setTipo(tipo);
        setObjetivo(objetivo);
        setValor(valor);
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }
    public String getObjetivo() {
        return objetivo;
    }
    public void setTipo(TipoModificador tipo) {
        this.tipo = tipo;
    }
    public TipoModificador getTipo() {
        return tipo;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public int getValor() {
        return valor;
    }
}
