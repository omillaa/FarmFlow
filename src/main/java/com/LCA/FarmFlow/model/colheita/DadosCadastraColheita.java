package com.LCA.FarmFlow.model.colheita;

import com.LCA.FarmFlow.model.plantacao.Plantacao;

import java.time.LocalDate;

public record DadosCadastraColheita(LocalDate dataColheita, String quantidade, Plantacao plantacao) {
}
