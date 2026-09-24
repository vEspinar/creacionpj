package com.creacionpj.model;

import com.creacionpj.utils.Constants;
import com.creacionpj.utils.RangoCompetencia;
import jakarta.persistence.*;

/**
 * @author User
 * @version 1.0
 * @see Clase
 */ 

@Entity
@Table (name = Constants.HABILIDADES_TABLA_NOM)
  
public class Habilidad {
    //Anotaciones para la bbdd
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name=Constants.ACROBACIAS_NOM)
    @RangoCompetencia
    private int acrobaciasComp;
    @Column(name=Constants.ARCANO_NOM)
    @RangoCompetencia
    private int arcanoComp;
    @Column(name=Constants.ARTESANIA_NOM)
    @RangoCompetencia
    private int artesaniaComp;
    @Column(name=Constants.ATLETISMO_NOM)
    @RangoCompetencia
    private int atletismoComp;
    @Column(name=Constants.DIPLOMACIA_NOM)
    @RangoCompetencia
    private int diplomaciaComp;
    @Column(name=Constants.ENGANO_NOM)
    @RangoCompetencia
    private int enganoComp;
    @Column(name=Constants.INTERPRETACION_NOM)
    @RangoCompetencia
    private int interpretacionComp;
    @Column(name=Constants.INTIMIDACION_NOM)
    @RangoCompetencia
    private int intimidacionComp;
    @Column(name=Constants.LATROCINIO_NOM)
    @RangoCompetencia
    private int latrocinioComp;
    @Column(name=Constants.MEDICINA_NOM)
    @RangoCompetencia
    private int medicinaComp;
    @Column(name=Constants.NATURALEZA_NOM)
    @RangoCompetencia
    private int naturalezaComp;
    @Column(name=Constants.OCULTISMO_NOM)
    @RangoCompetencia
    private int ocultismoComp;
    @Column(name=Constants.RELIGION_NOM)
    @RangoCompetencia
    private int religionComp;
    @Column(name=Constants.SIGILO_NOM)
    @RangoCompetencia
    private int sigiloComp;
    @Column(name=Constants.SOCIEDAD_NOM)
    @RangoCompetencia
    private int sociedadComp;
    @Column(name=Constants.SUPERVIVENCIA_NOM)
    @RangoCompetencia
    private int supervivenciaComp;
    @Column(name=Constants.SABER_NOM)
    @RangoCompetencia
    private int saberComp;

    public Habilidad(){}
    public Habilidad(int acr, int art, int arc, int atl, int dip, int eng, int inte, int inti, 
        int lat, int med, int nat, int ocu, int rel, int sig, int soc, int sup, int sab){
            setAcrobaciasComp(acr);
            setArtesaniaComp(art);
            setArcanoComp(arc);
            setAtletismoComp(atl);
            setDiplomaciaComp(dip);
            setEnganoComp(eng);
            setInterpretacionComp(inte);
            setIntimidacionComp(inti);
            setLatrocinioComp(lat);
            setMedicinaComp(med);
            setNaturalezaComp(nat);
            setOcultismoComp(ocu);
            setReligionComp(rel);
            setSaberComp(sab);
            setSigiloComp(sig);
            setSociedadComp(soc);
            setSupervivenciaComp(sup);
        }
    //Getters y Setters:
    public int getAcrobaciasComp() {
        return acrobaciasComp;
    }
    public void setAcrobaciasComp(int acrobaciasComp) {
        this.acrobaciasComp = acrobaciasComp;
    }
    public int getArcanoComp() {
        return arcanoComp;
    }
    public void setArcanoComp(int arcanoComp) {
        this.arcanoComp = arcanoComp;
    }
    public int getArtesaniaComp() {
        return artesaniaComp;
    }
    public void setArtesaniaComp(int artesaniaComp) {
        this.artesaniaComp = artesaniaComp;
    }
    public int getAtletismoComp() {
        return atletismoComp;
    }
    public void setAtletismoComp(int atletismoComp) {
        this.atletismoComp = atletismoComp;
    }
    public int getDiplomaciaComp() {
        return diplomaciaComp;
    }
    public void setDiplomaciaComp(int diplomaciaComp) {
        this.diplomaciaComp = diplomaciaComp;
    }
    public int getEnganoComp() {
        return enganoComp;
    }
    public void setEnganoComp(int enganoComp) {
        this.enganoComp = enganoComp;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getInterpretacionComp() {
        return interpretacionComp;
    }
    public void setInterpretacionComp(int interpretacionComp) {
        this.interpretacionComp = interpretacionComp;
    }
    public int getIntimidacionComp() {
        return intimidacionComp;
    }
    public void setIntimidacionComp(int intimidacionComp) {
        this.intimidacionComp = intimidacionComp;
    }
    public int getLatrocinioComp() {
        return latrocinioComp;
    }
    public void setLatrocinioComp(int latrocinioComp) {
        this.latrocinioComp = latrocinioComp;
    }
    public int getMedicinaComp() {
        return medicinaComp;
    }
    public void setMedicinaComp(int medicinaComp) {
        this.medicinaComp = medicinaComp;
    }
    public int getNaturalezaComp() {
        return naturalezaComp;
    }
    public void setNaturalezaComp(int naturalezaComp) {
        this.naturalezaComp = naturalezaComp;
    }
    public int getOcultismoComp() {
        return ocultismoComp;
    }
    public void setOcultismoComp(int ocultismoComp) {
        this.ocultismoComp = ocultismoComp;
    }
    public int getReligionComp() {
        return religionComp;
    }
    public void setReligionComp(int religionComp) {
        this.religionComp = religionComp;
    }
    public int getSaberComp() {
        return saberComp;
    }
    public void setSaberComp(int saberComp) {
        this.saberComp = saberComp;
    }
    public int getSigiloComp() {
        return sigiloComp;
    }
    public void setSigiloComp(int sigiloComp) {
        this.sigiloComp = sigiloComp;
    }
    public int getSociedadComp() {
        return sociedadComp;
    }
    public void setSociedadComp(int sociedadComp) {
        this.sociedadComp = sociedadComp;
    }
    public int getSupervivenciaComp() {
        return supervivenciaComp;
    }
    public void setSupervivenciaComp(int supervivenciaComp) {
        this.supervivenciaComp = supervivenciaComp;
    }
}
