package com.LCA.FarmFlow.model.colheita;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ColheitaRepository extends JpaRepository<Colheita, Long> {
    @Query(value = "SELECT c FROM Colheita c WHERE c.dataColheita = :dataColheita")
    List<Colheita> buscaColheita(@Param("dataColheita") LocalDate dataColheita);
}
