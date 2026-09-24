package com.creacionpj.model;

import jakarta.persistence.*;
import java.util.List;
import com.creacionpj.utils.*;

@Entity
@Table(name=Constants.SUBIDA_COMPETENCIA_NOM)

public class SubidaCompetenciaCombate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    @CollectionTable(name=Constants.COMPETENCIAS_OPCIONES, joinColumns = @JoinColumn(name= Constants.SUBIDA_FK))
    @Enumerated(EnumType.STRING)
    @Column(name=Constants.COMPETENCIAS_TABLA_NOM)
    private List<TipoCompetenciaCombate> comps;

    @Column(name=Constants.VALOR_NOM)
    private int valor;    

    public SubidaCompetenciaCombate(){}
    public SubidaCompetenciaCombate(List<TipoCompetenciaCombate> comps, int valor){
        setComps(comps);
        setValor(valor);
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public void setComps(List<TipoCompetenciaCombate> comps) {
        this.comps = comps;
    }
    public List<TipoCompetenciaCombate> getComps() {
        return comps;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public int getValor() {
        return valor;
    }
}
