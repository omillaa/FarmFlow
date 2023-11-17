package com.LCA.FarmFlow.model.irrigacao;

import jakarta.persistence.*;

import java.sql.Time;
import java.time.LocalDate;

@Entity
@Table(name="irrigacao")
public class Irrigacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIrrigacao;
    private LocalDate dataIrrig;
    private float quantid;
    private Time duracao;
    private String tipoIrrig;
    private String observacao;

    public Long getIdIrrigacao() { return idIrrigacao; }
    public LocalDate getDataIrrig() { return dataIrrig; }
    public float getQuantid() {  return quantid; }
    public Time getDuracao() { return duracao; }
    public String getTipoIrrig() { return tipoIrrig; }
    public String getObservacao() { return observacao; }
    public Irrigacao(){}
    public Irrigacao (DadosCadastraIrrigacao dados)
    {
        this.dataIrrig = dados.dataIrrig();
        this.duracao = dados.duracao();
        this.quantid = dados.quant();
        this.tipoIrrig = dados.tipoIrrig();
        this.observacao = dados.observacao();
    }
    public void autualizaDados (DadosAlteraIrrigacao dados)
    {
        this.dataIrrig = dados.dataIrrig();
        this.duracao = dados.duracao();
        this.quantid = dados.quant();
        this.tipoIrrig = dados.tipoIrrig();
        this.observacao = dados.observacao();
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
