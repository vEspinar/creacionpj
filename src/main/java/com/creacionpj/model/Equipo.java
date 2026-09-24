package com.creacionpj.model;

import jakarta.persistence.*;
import java.util.List;
import com.creacionpj.utils.*;

@Entity
@Table(name=Constants.EQUIPO_TABLE_NOM)

public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name=Constants.EQUIPO_TIPO)
    private TipoEquipo tipo;
    @Enumerated(EnumType.STRING)
    @Column(name=Constants.EQUIPO_CATEGORIA)
    private TipoCategoriaEquipo categoria;
    @Enumerated(EnumType.STRING)
    @Column(name=Constants.EQUIPO_GRUPO)
    private TipoGrupoEquipo grupo;
    @Column(name=Constants.EQUIPO_NOM)
    private String nombre;
    @Column(name=Constants.PRECIO)
    private int precio;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name=Constants.MODIFICADOR_EQUIPO, joinColumns = @JoinColumn(name=Constants.EQUIPO_FK), inverseJoinColumns = @JoinColumn(name=Constants.MODIFICADOR_FK))
    private List<Modificador> mods;
    @Column(name=Constants.EFECTO, columnDefinition = "TEXT")
    private String descripcion;
    @Column(name=Constants.PESO)
    private int peso;
    @Column(name=Constants.EQUIPO_DANO)
    private String dano;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    @JoinTable(name=Constants.RASGOS_EQUIPO, joinColumns = @JoinColumn(name=Constants.EQUIPO_FK), inverseJoinColumns = @JoinColumn(name=Constants.RASGOS_ID))
    private List<Rasgo> rasgos;
    @Column(name=Constants.EQUIPO_EQUIPADO)
    private boolean equipado;


    public Equipo(){}
    public Equipo(TipoEquipo tipo,String nombre, String dano, int precio, List<Modificador> mods, int peso, String ef, List<Rasgo> rasgos,
        TipoCategoriaEquipo cat, TipoGrupoEquipo grupo){
        setTipo(tipo);
        setNombre(nombre);
        setDano(dano);
        setPrecio(precio);
        setMods(mods);
        setPeso(peso);
        setDescripcion(ef);
        setRasgos(rasgos);
        setCategoria(cat);
        setGrupo(grupo);
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setDano(String dano) {
        this.dano = dano;
    }
    public String getDano() {
        return dano;
    }
    public void setEquipado(boolean equipado) {
        this.equipado = equipado;
    }
    public boolean isEquipado(){
        return equipado;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void setTipo(TipoEquipo tipo) {
        this.tipo = tipo;
    }
    public TipoEquipo getTipo() {
        return tipo;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }
    public int getPeso() {
        return peso;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public List<Rasgo> getRasgos() {
        return rasgos;
    }
    public void setRasgos(List<Rasgo> rasgos) {
        this.rasgos = rasgos;
    }
    public void setMods(List<Modificador> mods) {
        this.mods = mods;
    }
    public List<Modificador> getMods() {
        return mods;
    }
    public void setCategoria(TipoCategoriaEquipo categoria) {
        this.categoria = categoria;
    }
    public TipoCategoriaEquipo getCategoria() {
        return categoria;
    }
    public void setGrupo(TipoGrupoEquipo grupo) {
        this.grupo = grupo;
    }
    public TipoGrupoEquipo getGrupo() {
        return grupo;
    }
}
