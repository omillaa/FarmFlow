package com.LCA.FarmFlow.model.colheita;

import com.LCA.FarmFlow.model.plantacao.Plantacao;
import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name="colheita")
public class Colheita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idColheita;
    @ManyToOne
    @JoinColumn(name = "idPlantacao")
    private Plantacao plantacao;
    private LocalDate dataColheita;
    private String quantidade;
    public Long getIdColheita() { return idColheita; }
    public LocalDate getDataColheita() { return dataColheita; }
    public String getQuantidade() { return quantidade; }
    public Plantacao getPlantacao() {return plantacao;}
    public void setPlantacao(Plantacao plantacao) {this.plantacao = plantacao;}
    public Colheita(DadosCadastraColheita dados)
    {
        this.dataColheita = dados.dataColheita();
        this.quantidade = dados.quantidade();
        this.plantacao = dados.plantacao();
    }
    public Colheita(){}
    public void autualizaDados(DadosAlteraColheita dados)
    {
        this.dataColheita = dados.dataColheita();
        this.quantidade = dados.quantidade();
        this.plantacao = dados.plantacao();
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
