package com.creacionpj.model;

import jakarta.persistence.*;

import java.util.List;

import com.creacionpj.utils.*;

@Entity
@Table(name=Constants.LIBRE_TABLE_NOM)
public class Libre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name=Constants.ESTADISTICAS_LIBRE)
    private List<SubidaEstadistica> stats;
    @ElementCollection
    @CollectionTable(name=Constants.LIBRE_OPCIONES_STATS, joinColumns = @JoinColumn(name=Constants.LIBRE_FK))
    @Enumerated(EnumType.STRING)
    @Column(name=Constants.TIPO_ESTADISTICA)
    private List<TipoEstadistica> opcionesStats;
    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name=Constants.HABILIDADES_LIBRE)
    private List<SubidaHabilidad> skills;
    @ElementCollection
    @CollectionTable(name=Constants.LIBRE_OPCIONES_HABS, joinColumns = @JoinColumn(name=Constants.LIBRE_FK))
    @Enumerated(EnumType.STRING)
    @Column(name=Constants.TIPO_HABILIDAD)
    private List<TipoHabilidad> opcionesHabs;
    @Column(name=Constants.IDIOMAS)
    private String idiomas;
    @Column(name=Constants.TOTAL_HABILIDAD)
    private int totalOpcionesHab;
    @Column(name=Constants.TOTAL_ESTADISTICAS)
    private int totalOpcionesStats;

    public Libre(){}
    public Libre(List<SubidaEstadistica> s, List<SubidaHabilidad> h){
        setStats(s);
        setSkills(h);
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getIdiomas() {
        return idiomas;
    }
    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }
    public List<SubidaHabilidad> getSkills() {
        return skills;
    }
    public void setSkills(List<SubidaHabilidad> skills) {
        this.skills = skills;
    }
    public List<SubidaEstadistica> getStats() {
        return stats;
    }
    public void setStats(List<SubidaEstadistica> stats) {
        this.stats = stats;
    }
    public void setTotalOpcionesHab(int totalOpcionesHab) {
        this.totalOpcionesHab = totalOpcionesHab;
    }
    public int getTotalOpcionesHab() {
        return totalOpcionesHab;
    }
    public void setTotalOpcionesStats(int totalOpcionesStats) {
        this.totalOpcionesStats = totalOpcionesStats;
    }
    public int getTotalOpcionesStats() {
        return totalOpcionesStats;
    }
    public void setOpcionesStats(List<TipoEstadistica> opcionesStats) {
        this.opcionesStats = opcionesStats;
    }
    public List<TipoEstadistica> getOpcionesStats() {
        return opcionesStats;
    }
    public void setOpcionesHabs(List<TipoHabilidad> opcionesHabs) {
        this.opcionesHabs = opcionesHabs;
    }
    public List<TipoHabilidad> getOpcionesHabs() {
        return opcionesHabs;
    }
}
