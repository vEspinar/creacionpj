package com.creacionpj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.creacionpj.model.Personaje;

public interface PersonajeRepository extends JpaRepository<Personaje, Long>{   
}