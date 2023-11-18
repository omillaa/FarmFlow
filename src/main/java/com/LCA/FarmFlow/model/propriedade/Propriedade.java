package com.LCA.FarmFlow.model.propriedade;

import com.LCA.FarmFlow.model.colheita.Colheita;
import com.LCA.FarmFlow.model.cultura.Cultura;
import com.LCA.FarmFlow.model.plantacao.Plantacao;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "propriedade")
public class Propriedade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPropriedade;
    @OneToMany(mappedBy = "propriedade")
    private List<Plantacao> listaPlantacao= new ArrayList<>();
    private String nome;
    private String endereco;
    private double areaTotal;
    private String responsavel;

    public Long getIdPropriedade() {  return idPropriedade; }
    public String getNome() {  return nome; }
    public String getEndereco() { return endereco;  }
    public double getAreaTotal() {  return areaTotal; }
    public String getResponsavel() { return responsavel; }
    public List<Plantacao> getListaPlantacao() { return listaPlantacao; }
    public Propriedade(){}
    public Propriedade(DadosCadastraPropriedade dados) {
        this.nome = dados.nome();
        this.endereco = dados.endereco();
        this.areaTotal = dados.areaTotal();
        this.responsavel = dados.responsavel();
    }
    public void atualizaDados(DadosAlteraPropriedade dados)
    {
        this.nome = dados.nome();
        this.endereco = dados.endereco();
        this.areaTotal = dados.areaTotal();
        this.responsavel = dados.responsavel();
    }
    @Override
    public String toString()
    {
        return "Propriedade{" +
                "nome='" + nome + '\'' +
                ", endereco='" + endereco+ '\'' +
                ", areaTotal='" + areaTotal + '\'' +
                ", responsavel='" + responsavel + '\'' +
                '}';
    }
}
