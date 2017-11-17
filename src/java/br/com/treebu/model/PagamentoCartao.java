/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.model;

import java.util.Date;

/**
 *
 * @author vinicius caetano
 */
public class PagamentoCartao {

    private int id;
    private String nomeTitular;
    private Long numerosCartao;
    private Date dataValidade;
    private int codSeguranca;
    private int qtdParcelas;

    public PagamentoCartao() {
    }

    public PagamentoCartao(int id, String nomeTitular, Long numerosCartao, Date dataValidade, int codSeguranca, int qtdParcelas) {
        this.id = id;
        this.nomeTitular = nomeTitular;
        this.numerosCartao = numerosCartao;
        this.dataValidade = dataValidade;
        this.codSeguranca = codSeguranca;
        this.qtdParcelas = qtdParcelas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public Long getNumerosCartao() {
        return numerosCartao;
    }

    public void setNumerosCartao(Long numerosCartao) {
        this.numerosCartao = numerosCartao;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public int getCodSeguranca() {
        return codSeguranca;
    }

    public void setCodSeguranca(int codSeguranca) {
        this.codSeguranca = codSeguranca;
    }

    public int getQtdParcelas() {
        return qtdParcelas;
    }

    public void setQtdParcelas(int qtdParcelas) {
        this.qtdParcelas = qtdParcelas;
    }

    @Override
    public String toString() {
        return "PagamentoCartao{" + "id=" + id + ", nomeTitular=" + nomeTitular + ", numerosCartao=" + numerosCartao + ", dataValidade=" + dataValidade + ", codSeguranca=" + codSeguranca + ", qtdParcelas=" + qtdParcelas + '}';
    }

}
