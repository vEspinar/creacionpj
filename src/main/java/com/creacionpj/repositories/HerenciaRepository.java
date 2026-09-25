package com.creacionpj.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.creacionpj.model.TipoAscendencia;
import com.creacionpj.model.Herencia;
import com.creacionpj.model.TipoHerencia;


public interface HerenciaRepository extends JpaRepository<Herencia, Long>{   
    List<Herencia> findByReqAscendencia(TipoAscendencia ascendencia);
    boolean existsByNombre(TipoHerencia nombre);
}