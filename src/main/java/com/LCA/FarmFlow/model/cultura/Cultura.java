package com.LCA.FarmFlow.model.cultura;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;

@Entity
@Table(name="cultura")
public class Cultura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private String tempo;
    private String tipo;
    private String tipos;//
    @Column(name = "estacao")
    private String est;
    public Cultura(DadosCadastraCultura dados){
        this.nome = dados.nome();
        this.descricao = dados.descricao();
        this.tempo = dados.tempo();
        this.tipo = dados.tipo();
        this.tipos = dados.tipos();
        this.est = dados.est();
    }
    @Override
    public String toString() {
        return "Cultura{" +
                "nome='" + nome + '\'' +
                ", desc='" + descricao+ '\'' +
                ", time='" + tempo + '\'' +
                ", tipo='" + tipo + '\'' +
                ", tipos='" + tipos + '\'' +
                ", est='" + est + '\'' +
                '}';
    }
    public Cultura() {
        // construtor vazio necessário para o Hibernate
    }
    public void atualizaDados(DadosAlteraCultura dados) {
        this.nome = dados.nome();
        this.descricao = dados.descricao();
        this.tempo = dados.time();
        this.tipo = dados.tipo();
        this.tipos = dados.tipos();
        this.est = dados.est();
    }

    public Long getId() {return id;}
    public String getTempo() {return tempo;}
    public void setTempo(String tempo) {this.tempo = tempo;}
    public String getDescricao() {return descricao;}
    public void setDescricao(String descricao) {this.descricao = descricao;}
    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getTipo() {return tipo;}

    public void setTipo(String tipo) {this.tipo = tipo;}

    public String getTipos() {return tipos;}

    public void setTipos(String tipos) {this.tipos = tipos;}

    public String getEst() {return est;}

    public void setEst(String est) {this.est = est;}

}
