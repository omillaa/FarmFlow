package com.LCA.FarmFlow.model.irrigacao;

import com.LCA.FarmFlow.model.plantacao.Plantacao;

import java.sql.Time;
import java.time.LocalDate;

public record DadosCadastraIrrigacao(LocalDate dataIrrig, Float quantid, Time duracao, String tipoIrrig, String observacao,
                                     Plantacao plantacao) {}