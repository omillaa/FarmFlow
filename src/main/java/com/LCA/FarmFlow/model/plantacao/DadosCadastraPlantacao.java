package com.LCA.FarmFlow.model.plantacao;

import com.LCA.FarmFlow.model.cultura.Cultura;
import com.LCA.FarmFlow.model.propriedade.Propriedade;

import java.time.LocalDate;

public record DadosCadastraPlantacao(LocalDate dataPlantio, double areaCultivo, String estagio, Cultura cultura, Propriedade propriedade, String nome) {

}
