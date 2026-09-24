package com.creacionpj.seeders;

import java.io.InputStream;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import com.creacionpj.model.Rasgo;
import com.creacionpj.repositories.RasgoRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component 
public class RasgoSeeder {
    private final RasgoRepository rr;
    private final ObjectMapper om = new ObjectMapper();
    
    public RasgoSeeder(RasgoRepository rr){
        this.rr = rr;
    }
        
    public void cargarRasgo(Rasgo rasgo){
        if(!rr.existsByNombreIgnoreCase(rasgo.getNombre())){
            rr.save(rasgo);
        }
    }

    public Rasgo getRasgo(String nombre){ 
        if(!rr.existsByNombreIgnoreCase(nombre)){
            Rasgo rasgo = new Rasgo(nombre, "");
            return rr.save(rasgo);
        }
        return rr.findByNombreIgnoreCase(nombre);
    }    

    public void cargaInicialRasgo(){
        try{
            ClassPathResource rasgos = new ClassPathResource("rasgos.json");
            InputStream inputStream = rasgos.getInputStream();
            List<Rasgo> totalRasgos = om.readValue(inputStream, new TypeReference<List<Rasgo>>(){});
            for(Rasgo r : totalRasgos){
                cargarRasgo(r);
            }
            System.out.println("Cargado correctamente");
        }catch(Exception e){
            System.err.println("Error al cargar el Json: " +e.getMessage());
            e.printStackTrace();
        }
    }
}
