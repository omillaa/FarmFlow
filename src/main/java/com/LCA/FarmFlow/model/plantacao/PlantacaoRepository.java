package com.LCA.FarmFlow.model.plantacao;

import com.LCA.FarmFlow.model.propriedade.Propriedade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantacaoRepository extends JpaRepository<Plantacao,Long> {
    List<Plantacao> findByNome(String nome);
}
