package com.LCA.FarmFlow.model.plantacao;

import com.LCA.FarmFlow.model.cultura.Cultura;
import com.LCA.FarmFlow.model.irrigacao.DadosCadastraIrrigacao;
import com.LCA.FarmFlow.model.irrigacao.Irrigacao;
import com.LCA.FarmFlow.model.propriedade.Propriedade;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import com.LCA.FarmFlow.model.colheita.Colheita;
import java.util.List;

@Entity
@Table(name = "plantacao")
public class Plantacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlantacao;

    @ManyToOne
    @JoinColumn(name = "id_cultura")
    private Cultura cultura;
    @ManyToOne
    @JoinColumn(name = "idPropriedade")
    private Propriedade propriedade;

    private LocalDate dataPlantio;
    private double areaCultivo;
    private String estagio;
    @OneToMany(mappedBy = "plantacao")
    private List<Colheita> listaColheitas= new ArrayList<>();
    @OneToMany(mappedBy = "plantacao")
    private List<Irrigacao> listaIrrigacao = new ArrayList<>();

    public Long getIdPlantacao() { return idPlantacao; }
    public LocalDate getDataPlantio() { return dataPlantio; }
    public double getAreaCultivo() { return areaCultivo; }
    public String getEstagio() { return estagio; }
    public List<Colheita> getListaColheitas() { return listaColheitas; }
    public List<Irrigacao> getListaIrrigacao() { return listaIrrigacao; }
    public Propriedade getPropriedade() { return propriedade; }

    public Cultura getCultura() {return cultura;}

    public Plantacao(){}
    public Plantacao(DadosCadastraPlantacao dados)
    {
        this.dataPlantio = dados.dataPlantio();
        this.areaCultivo = dados.areaCultivo();
        this.estagio = dados.estagio();
        this.cultura = dados.cultura();
        this.propriedade = dados.propriedade();
    }
    public void atualizaDados(DadosAlteraPlantacao dados)
    {
        this.dataPlantio = dados.dataPlantio();
        this.areaCultivo = dados.areaCultivo();
        this.estagio = dados.estagio();
        this.cultura = dados.cultura();
        this.propriedade = dados.propriedade();
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
