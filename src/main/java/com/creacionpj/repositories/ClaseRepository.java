package com.creacionpj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.creacionpj.model.Clase;
import com.creacionpj.model.TipoClase;


public interface ClaseRepository extends JpaRepository<Clase, Long>{
    boolean existsByClase(TipoClase clase); 
    Clase findByClase(TipoClase clase);
}
