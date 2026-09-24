package com.creacionpj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.creacionpj.model.Bagaje;

public interface BagajeRepository extends JpaRepository<Bagaje, Long>{   
    boolean existsByNombreIgnoreCase(String nombre);
    
}
