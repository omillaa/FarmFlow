package com.LCA.FarmFlow.model.irrigacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IrrigacaoRepository extends JpaRepository<Irrigacao, Long> {
}
