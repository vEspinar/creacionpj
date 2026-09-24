package com.creacionpj.seeders;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CargarDatos implements CommandLineRunner {
    private final ClaseSeeder cs;
    private final RazaSeeder rs;
    private final SubRazaSeeder srs;
    private final DoteSeeder ds;
    private final EquipoSeeder es;
    private final HechizoSeeder hs;
    private final RasgoSeeder ras;
    private final BagajeSeeder bs;
    private final SubidaNivelSeeder sns;

    public CargarDatos(BagajeSeeder bs, ClaseSeeder cs,EquipoSeeder es, RazaSeeder rs, SubRazaSeeder srs, DoteSeeder ds, 
        HechizoSeeder hs, RasgoSeeder ras, SubidaNivelSeeder sns){
        this.bs=bs;
        this.cs=cs;
        this.rs=rs;
        this.srs= srs;
        this.ds=ds;
        this.es= es;
        this.hs= hs;
        this.ras=ras;
        this.sns = sns;
    }

    @Override
    public void run(String... args) throws Exception{
        ras.cargaInicialRasgo();
        ds.cargaInicialDote();
        bs.cargaInicialBagaje();
        rs.cargaInicialRaza();
        srs.cargaInicialSubRaza();
        cs.cargaInicialClase();
        es.cargaInicialEquipo();
        hs.cargaInicialHechizo();
        sns.cargarSubidasNivel();
    }
}
