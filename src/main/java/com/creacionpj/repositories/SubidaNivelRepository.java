package com.creacionpj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.creacionpj.model.Clase;
import com.creacionpj.model.SubidaNivel;

public interface SubidaNivelRepository extends JpaRepository<SubidaNivel, Long>{   
    SubidaNivel findByClaseAndLvl(Clase clase, int lvl);
    boolean existsByClase(Clase cl);
}