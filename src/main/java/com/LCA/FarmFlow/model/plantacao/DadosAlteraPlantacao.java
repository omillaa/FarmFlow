package com.LCA.FarmFlow.model.plantacao;

import java.time.LocalDate;

public record DadosAlteraPlantacao(LocalDate dataPlantio, double areaCultivo, String estagio) {
}
