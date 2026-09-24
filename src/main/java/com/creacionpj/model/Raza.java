package com.creacionpj.model;

import java.util.List;

import com.creacionpj.utils.Constants;
import jakarta.persistence.*;
@Entity
@Table(name=Constants.RAZA_TABLE_NOM)
public class Raza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name=Constants.RAZA_NOM)
    private TipoRaza raza;
    @ElementCollection
    @CollectionTable(name=Constants.RAZA_SUBRAZA, joinColumns = @JoinColumn(name=Constants.RAZA_FK))
    @Enumerated(EnumType.STRING)
    @Column(name=Constants.SUBRAZA_NOM)
    private List<TipoSubraza> subRaza;
    @Column(name=Constants.VIDA_NOM)
    private int vida;
    @Column(name=Constants.TAMANO_NOM)
    private int size;
    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name=Constants.ESTADISTICAS_RAZA)
    private List<SubidaEstadistica> stats;
    @Column(name=Constants.VELOCIDAD_NOM)
    private int speed;
    @Column(name=Constants.IDIOMAS)
    private String idiomas;
    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name=Constants.DOTES_RAZA)
    private List<Dote> dote;
    @Column(name=Constants.CANTIDAD_ESTADISTICAS)
    private int statsLibres;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    @JoinTable(name=Constants.RASGOS_RAZA, joinColumns = @JoinColumn(name=Constants.RAZA_FK), inverseJoinColumns = @JoinColumn(name=Constants.RASGOS_ID))
    private List<Rasgo> rasgos;

    public Raza(){}
    public Raza(TipoRaza raza, List<TipoSubraza> sub, int vida, int size, List<SubidaEstadistica> stats, int statsLibres, int speed, String idiomas, 
        List<Rasgo> rasgos, List<Dote> dote){
            setRaza(raza);
            setSubRaza(sub);
            setVida(vida);
            setSize(size);
            setStats(stats);
            setStatsLibres(statsLibres);
            setSpeed(speed);
            setIdiomas(idiomas);
            setRasgos(rasgos);
            setDote(dote);
        }

        public void setId(Long id) {
            this.id = id;
        }
        public Long getId() {
            return id;
        }
        public void setRaza(TipoRaza raza) {
            this.raza = raza;
        }
        public TipoRaza getRaza() {
            return raza;
        }
        public void setSubRaza(List<TipoSubraza> subRaza) {
            this.subRaza = subRaza;
        }
        public List<TipoSubraza> getSubRaza() {
            return subRaza;
        }
        public void setDote(List<Dote> dote) {
            this.dote = dote;
        }
        public List<Dote> getDote() {
            return dote;
        }
        public int getStatsLibres() {
            return statsLibres;
        }
        public void setStatsLibres(int statsLibres) {
            this.statsLibres = statsLibres;
        }
        public void setIdiomas(String idiomas) {
            this.idiomas = idiomas;
        }
        public String getIdiomas() {
            return idiomas;
        }
        public void setRasgos(List<Rasgo> rasgos) {
            this.rasgos = rasgos;
        }
        public List<Rasgo> getRasgos() {
            return rasgos;
        }
        public void setSize(int size) {
            this.size = size;
        }
        public int getSize() {
            return size;
        }
        public void setSpeed(int speed) {
            this.speed = speed;
        }
        public int getSpeed() {
            return speed;
        }
        public void setStats(List<SubidaEstadistica> stats) {
            this.stats = stats;
        }
        public List<SubidaEstadistica> getStats() {
            return stats;
        }
        public void setVida(int vida) {
            this.vida = vida;
        }
        public int getVida() {
            return vida;
        }
}
