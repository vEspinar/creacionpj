package com.creacionpj.model;

import com.creacionpj.utils.*;
import jakarta.persistence.*;

/**
 *  @author User
 *  @version 1.0
 * @see Clase
 */ 

@Entity
@Table (name = Constants.COMPETENCIAS_TABLA_NOM)

public class CompetenciaCombate {
    //Anotaciones para la bbdd
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name=Constants.SIN_ARMADURAS_NOM)
    @RangoCompetencia
    private int sinArmaduraComp;
    @Column(name=Constants.ARMADURAS_LIGERAS_NOM)
    @RangoCompetencia
    private int armaduraLigeraComp;
    @Column(name=Constants.ARMADURAS_MEDIAS_NOM)
    @RangoCompetencia
    private int armaduraMediaComp;
    @Column(name=Constants.ARMADURAS_PESADAS_NOM)
    @RangoCompetencia
    private int armaduraPesadaComp;
    @Column(name=Constants.FORTALEZA_NOM)
    @RangoCompetencia
    private int fortalezaComp;
    @Column(name=Constants.REFLEJOS_NOM)
    @RangoCompetencia
    private int reflejosComp;
    @Column(name=Constants.VOLUNTAD_NOM)
    @RangoCompetencia
    private int voluntadComp;
    @Column(name=Constants.SIN_ARMAS_NOM)
    @RangoCompetencia
    private int sinArmasComp;
    @Column(name=Constants.ARMAS_SIMPLES_NOM)
    @RangoCompetencia
    private int armasSimplesComp;
    @Column(name=Constants.ARMAS_MARCIALES_NOM)
    @RangoCompetencia
    private int armasMarcialesComp;
    @Column(name=Constants.ARMAS_AVANZADAS_NOM)
    @RangoCompetencia
    private int armasAvanzadasComp;
    @Column(name=Constants.PERCEPCION_NOM)
    @RangoCompetencia
    private int percepcionComp;
    @Column(name=Constants.CLASE_COMP)
    @RangoCompetencia 
    private int claseComp;
    @Column(name=Constants.CONJURO_COMP)
    @RangoCompetencia 
    private int conjuroComp;

//Constructor vacio y lleno
public CompetenciaCombate(){};
public CompetenciaCombate(int sinArm, int armLig, int armMed, int armPes, int fort, int ref, int vol,
    int sinArma, int armSen, int armMar, int armAva, int perc, int clase, int conjuro){
        setSinArmaduraComp(sinArm);
        setArmaduraLigeraComp(armLig);
        setArmaduraMediaComp(armMed);
        setArmaduraPesadaComp(armPes);
        setFortalezaComp(fort);
        setReflejosComp(ref);
        setVoluntadComp(vol);
        setSinArmasComp(sinArma);
        setArmasSimplesComp(armSen);
        setArmasMarcialesComp(armMar);
        setArmasAvanzadasComp(armAva);
        setPercepcionComp(perc);
        setClaseComp(clase);
        setConjuroComp(conjuro);
}

//Getters y Setters:
public int getArmaduraLigeraComp() {
    return armaduraLigeraComp;
}
public void setArmaduraLigeraComp(int armaduraLigeraComp) {
    this.armaduraLigeraComp = armaduraLigeraComp;
}

public int getArmaduraMediaComp() {
    return armaduraMediaComp;
}
public void setArmaduraMediaComp(int armaduraMediaComp) {
    this.armaduraMediaComp = armaduraMediaComp;
}

public int getArmaduraPesadaComp() {
    return armaduraPesadaComp;
}
public void setArmaduraPesadaComp(int armadurasPesadaComp) {
    this.armaduraPesadaComp = armadurasPesadaComp;
}

public int getArmasAvanzadasComp() {
    return armasAvanzadasComp;
}
public void setArmasAvanzadasComp(int armasAvanzadasComp) {
    this.armasAvanzadasComp= armasAvanzadasComp;
}

public int getArmasMarcialesComp() {
    return armasMarcialesComp;
}
public void setArmasMarcialesComp(int armasMarcialesComp) {
    this.armasMarcialesComp = armasMarcialesComp;
}

public int getArmasSimplesComp() {
    return armasSimplesComp;
}
public void setArmasSimplesComp(int armasSimplesComp) {
    this.armasSimplesComp = armasSimplesComp;
}

public int getFortalezaComp() {
    return fortalezaComp;
}
public void setFortalezaComp(int fortalezaComp) {
    this.fortalezaComp = fortalezaComp;
}

public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}

public int getPercepcionComp() {
    return percepcionComp;
}
public void setPercepcionComp(int percepcionComp) {
    this.percepcionComp = percepcionComp;
}
public void setClaseComp(int claseComp) {
    this.claseComp = claseComp;
}
public int getClaseComp() {
    return claseComp;
}
public void setConjuroComp(int conjuroComp) {
    this.conjuroComp = conjuroComp;
}
public int getConjuroComp() {
    return conjuroComp;
}
public int getReflejosComp() {
    return reflejosComp;
}
public void setReflejosComp(int reflejosComp) {
    this.reflejosComp = reflejosComp;
}

public int getSinArmaduraComp() {
    return sinArmaduraComp;
}
public void setSinArmaduraComp(int sinArmaduraComp) {
    this.sinArmaduraComp = sinArmaduraComp;
}

public int getSinArmasComp() {
    return sinArmasComp;
}
public void setSinArmasComp(int sinArmasComp) {
    this.sinArmasComp = sinArmasComp;
}

public int getVoluntadComp() {
    return voluntadComp;
}
public void setVoluntadComp(int voluntadComp) {
    this.voluntadComp = voluntadComp;
}

public CompetenciaCombate clone(){
    return new CompetenciaCombate(sinArmaduraComp, armaduraLigeraComp, armaduraMediaComp, armaduraPesadaComp, 
        fortalezaComp, reflejosComp, voluntadComp, sinArmasComp, armasSimplesComp, armasMarcialesComp, armasAvanzadasComp,
        percepcionComp, claseComp, conjuroComp);
}

}
