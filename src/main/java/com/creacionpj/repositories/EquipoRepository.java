package com.creacionpj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.creacionpj.model.Equipo;
import java.util.List;
import com.creacionpj.model.Rasgo;
import com.creacionpj.model.TipoCategoriaEquipo;
import com.creacionpj.model.TipoGrupoEquipo;


public interface EquipoRepository extends JpaRepository<Equipo, Long>{  
    boolean existsByNombreIgnoreCase(String nombre);
    @Query("SELECT e FROM Equipo e JOIN e.rasgos r WHERE r IN :rasgos GROUP BY e HAVING COUNT(DISTINCT r) = :tamano")
    List<Equipo> findByTodosRasgos(@Param("rasgos") List<Rasgo> rasgos, @Param("tamano") long tamano);
    List<Equipo> findByRasgos(Rasgo rasgo);
    List<Equipo> findByCategoria(TipoCategoriaEquipo cat);
    List<Equipo> findByGrupo(TipoGrupoEquipo grupo);
    List<Equipo> findByCategoriaAndRasgos(TipoCategoriaEquipo cat, Rasgo rasgo);
    List<Equipo> findByGrupoAndRasgos(TipoGrupoEquipo grupo, Rasgo rasgo);
    List<Equipo> findByGrupoAndCategoria(TipoGrupoEquipo grupo, TipoCategoriaEquipo cat);
}
