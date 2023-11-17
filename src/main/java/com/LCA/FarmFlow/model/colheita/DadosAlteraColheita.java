package com.LCA.FarmFlow.model.colheita;

import java.time.LocalDate;

public record DadosAlteraColheita(Long idColheita, LocalDate dataColheita, String quantidade) {
}
