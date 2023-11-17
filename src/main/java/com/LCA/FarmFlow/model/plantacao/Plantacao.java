package com.LCA.FarmFlow.model.plantacao;

import com.LCA.FarmFlow.model.irrigacao.DadosCadastraIrrigacao;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "plantacao")
public class Plantacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlantacao;
    private LocalDate dataPlantio;
    private double areaCultivo;
    private String estagio;

    public Long getIdPlantacao() { return idPlantacao; }
    public LocalDate getDataPlantio() { return dataPlantio; }
    public double getAreaCultivo() { return areaCultivo; }
    public String getEstagio() { return estagio; }
    public Plantacao(){}
    public Plantacao(DadosCadastraPlantacao dados)
    {
        this.dataPlantio = dados.dataPlantio();
        this.areaCultivo = dados.areaCultivo();
        this.estagio = dados.estagio();
    }
    public void atualizaDados(DadosAlteraPlantacao dados)
    {
        this.dataPlantio = dados.dataPlantio();
        this.areaCultivo = dados.areaCultivo();
        this.estagio = dados.estagio();
    }
    @Override
    public String toString()
    {
        return "Plantacao{" +
                "dataPlantio='" + dataPlantio + '\'' +
                ", areaCultivada='" + areaCultivo+ '\'' +
                ", estagio='" + estagio + '\'' +
                '}';
    }
}
