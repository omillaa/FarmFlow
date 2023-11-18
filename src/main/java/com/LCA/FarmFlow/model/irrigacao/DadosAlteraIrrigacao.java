package com.LCA.FarmFlow.model.irrigacao;

import java.sql.Time;
import java.time.LocalDate;

public record DadosAlteraIrrigacao(Long idIrrigacao, LocalDate dataIrrig, Float quantid, Time duracao, String tipoIrrig, String observacao) {
}
