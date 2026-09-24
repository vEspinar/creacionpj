package com.creacionpj.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.creacionpj.model.Dote;
import com.creacionpj.model.Requisito;
import com.creacionpj.model.TipoDote;
public interface DoteRepository extends JpaRepository<Dote,Long> {
    List<Dote> findByTipoDote(TipoDote tipo);
    List<Dote> findByRequisitos(Requisito req);
    boolean existsByNombreIgnoreCase(String nombre);
    Dote findByNombreIgnoreCase(String nombre);
}
