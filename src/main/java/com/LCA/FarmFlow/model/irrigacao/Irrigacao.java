package com.LCA.FarmFlow.model.irrigacao;

import com.LCA.FarmFlow.model.plantacao.Plantacao;
import jakarta.persistence.*;

import java.sql.Time;
import java.time.LocalDate;

@Entity
@Table(name="irrigacao")
public class Irrigacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIrrigacao;
    @ManyToOne
    @JoinColumn(name = "idPlantacao")
    private Plantacao plantacao;
    private LocalDate dataIrrig;
    private Float quantid;
    private Time duracao;
    private String tipoIrrig;
    private String observacao;

    public Long getIdIrrigacao() { return idIrrigacao; }
    public LocalDate getDataIrrig() { return dataIrrig; }
    public float getQuantid() {  return quantid; }
    public Time getDuracao() { return duracao; }
    public String getTipoIrrig() { return tipoIrrig; }
    public String getObservacao() { return observacao; }
    public Plantacao getPlantacao() { return plantacao; }
    public Irrigacao(){}
    public Irrigacao (DadosCadastraIrrigacao dados)
    {
        this.dataIrrig = dados.dataIrrig();
        this.duracao = dados.duracao();
        this.quantid = dados.quantid();
        this.tipoIrrig = dados.tipoIrrig();
        this.observacao = dados.observacao();
        this.plantacao = dados.plantacao();
    }
    public void atualizaDados (DadosAlteraIrrigacao dados)
    {
        this.dataIrrig = dados.dataIrrig();
        this.duracao = dados.duracao();
        this.quantid = dados.quantid();
        this.tipoIrrig = dados.tipoIrrig();
        this.observacao = dados.observacao();
        this.plantacao = dados.plantacao();

    }
    @Override
    public String toString()
    {
        return "Irrigacao{" +
            "dataIrrigacao='" + dataIrrig + '\'' +
            ", quantidade='" + quantid+ '\'' +
            ", duracao='" + duracao + '\'' +
            ", tipoIrrigacao='" + tipoIrrig + '\'' +
            ", observacao='" + observacao + '\'' +
            '}';
    }
}
