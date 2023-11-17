package com.LCA.FarmFlow.model.irrigacao;

import java.sql.Time;
import java.time.LocalDate;

public record DadosCadastraIrrigacao(LocalDate dataIrrig, float quant, Time duracao, String tipoIrrig, String observacao) {
}
