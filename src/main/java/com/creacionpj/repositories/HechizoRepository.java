package com.creacionpj.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.creacionpj.model.Hechizo;
import com.creacionpj.model.TipoCompetenciaCombate;
import com.creacionpj.model.TipoTradicion;

public interface HechizoRepository extends JpaRepository<Hechizo, Long>{    
    Optional<Hechizo> findByNombreIgnoreCase(String nombre);

    boolean existsByNombreIgnoreCase(String nombre);

    List<Hechizo> findBySalvacion(TipoCompetenciaCombate salvacion);

    List<Hechizo> findByTradicion(TipoTradicion tradicion);

    List<Hechizo> findByTradicionAndSalvacion(TipoTradicion tra, TipoCompetenciaCombate sal);
}
