package com.LCA.FarmFlow.model.propriedade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropriedadeRepository extends JpaRepository<Propriedade,Long> {
}
