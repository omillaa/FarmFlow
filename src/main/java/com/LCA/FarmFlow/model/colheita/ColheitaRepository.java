package com.LCA.FarmFlow.model.colheita;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColheitaRepository extends JpaRepository<Colheita, Long> {
}
