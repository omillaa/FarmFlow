package com.LCA.FarmFlow.model.irrigacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IrrigacaoRepository extends JpaRepository<Irrigacao, Long> {
    @Query("SELECT i FROM Irrigacao i WHERE i.dataIrrig = :dataIrrig")
    List<Irrigacao> buscaIrrig(@Param("dataIrrig") LocalDate dataIrrig);
}
