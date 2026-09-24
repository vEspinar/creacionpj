package com.creacionpj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.creacionpj.model.Raza;
import com.creacionpj.model.TipoRaza;
import java.util.List;



public interface RazaRepository extends JpaRepository<Raza, Long>{   
    boolean existsByRaza(TipoRaza raza);
    List<Raza> findByRaza(TipoRaza raza);
}