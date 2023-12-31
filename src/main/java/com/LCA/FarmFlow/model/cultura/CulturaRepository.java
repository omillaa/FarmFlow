package com.LCA.FarmFlow.model.cultura;

import com.LCA.FarmFlow.model.irrigacao.Irrigacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CulturaRepository extends JpaRepository<Cultura, Long> {
    @Query(value = "SELECT * FROM Cultura WHERE nome = :nome", nativeQuery = true)
    List<Cultura> buscaCultura(@Param("nome") String nome);

}
