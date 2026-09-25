package com.creacionpj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.creacionpj.model.Ascendencia;
import com.creacionpj.model.TipoAscendencia;
import java.util.List;



public interface AscendenciaRepository extends JpaRepository<Ascendencia, Long>{   
    boolean existsByAscendencia(TipoAscendencia ascendencia);
    List<Ascendencia> findByAscendencia(TipoAscendencia ascendencia);
}