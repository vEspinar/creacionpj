package com.creacionpj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.creacionpj.model.Rasgo;

public interface RasgoRepository extends JpaRepository<Rasgo, Long> {
    Rasgo findByNombreIgnoreCase(String nombre);
    boolean existsByNombreIgnoreCase(String nombre);
}
