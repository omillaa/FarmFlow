package com.LCA.FarmFlow.model.plantacao;

import java.time.LocalDate;

public record DadosCadastraPlantacao(LocalDate dataPlantio, double areaCultivo, String estagio) {

}
