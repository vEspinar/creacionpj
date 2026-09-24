package com.creacionpj.seeders;


import java.util.List;
import org.springframework.stereotype.Component;
import com.creacionpj.seeders.progresionClases.*;

@Component 
public class SubidaNivelSeeder {
    private final List<ProgresionClasesSeeder> seeders;

    public SubidaNivelSeeder(List<ProgresionClasesSeeder> seeders){
        this.seeders=seeders;
    }

    public void cargarSubidasNivel(){
        for(ProgresionClasesSeeder seeder : seeders){
            seeder.cargarSubidaNivel();
        }
    }
}
