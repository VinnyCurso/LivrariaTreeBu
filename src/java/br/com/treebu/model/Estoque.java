/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.model;

/**
 *
 * @author vinicius caetano
 */
public class Estoque {

    private int codigo;
    private String descProduto;
    private int quantidade;

    public Estoque() {
    }

    public Estoque(int codigo, String descProduto, int quantidade) {
        this.codigo = codigo;
        this.descProduto = descProduto;
        this.quantidade = quantidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescProduto() {
        return descProduto;
    }

    public void setDescProduto(String descProduto) {
        this.descProduto = descProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Estoque{" + "codigo=" + codigo + ", descProduto=" + descProduto + ", quantidade=" + quantidade + '}';
    }

}
