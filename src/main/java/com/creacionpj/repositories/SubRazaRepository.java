package com.creacionpj.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.creacionpj.model.TipoRaza;
import com.creacionpj.model.SubRaza;
import com.creacionpj.model.TipoSubraza;


public interface SubRazaRepository extends JpaRepository<SubRaza, Long>{   
    List<SubRaza> findByReqRaza(TipoRaza raza);
    boolean existsByNombre(TipoSubraza nombre);
}