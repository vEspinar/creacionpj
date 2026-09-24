package com.creacionpj.seeders.progresionClases;

import com.creacionpj.model.TipoClase;

public interface ProgresionClasesSeeder {
    //Para saber a que clase pertenece cada Seeder:
    TipoClase getTipoClase();
    //Y así implementamos el método genérico:
    void cargarSubidaNivel();
}
