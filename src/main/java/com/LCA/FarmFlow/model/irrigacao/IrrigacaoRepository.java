package com.LCA.FarmFlow.model.irrigacao;

import com.LCA.FarmFlow.model.colheita.Colheita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IrrigacaoRepository extends JpaRepository<Irrigacao, Long> {
    @Query(value ="SELECT i FROM Irrigacao i WHERE i.dataIrrig = :dataIrrig")
    List<Irrigacao> buscaIrrig(@Param("dataIrrig") LocalDate dataIrrig);
}
