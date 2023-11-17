package com.LCA.FarmFlow.model.colheita;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name="colheita")
public class Colheita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idColheita;
    private LocalDate dataColheita;
    private String quantidade;
    public Long getIdColheita() { return idColheita; }
    public LocalDate getDataColheita() { return dataColheita; }
    public String getQuantidade() { return quantidade; }
    public Colheita(DadosCadastraColheita dados)
    {
        this.dataColheita = dados.dataColheita();
        this.quantidade = dados.quantidade();
    }
    public Colheita(){}
    public void autualizaDados(DadosAlteraColheita dados)
    {
        this.dataColheita = dados.dataColheita();
        this.quantidade = dados.quantidade();
    }
    @Override
    public String toString()
    {
        return "Colheita{" +
                "dataColheita='" + dataColheita + '\'' +
                ", quantidade='" + quantidade+ '\'' +
                '}';
    }
}
