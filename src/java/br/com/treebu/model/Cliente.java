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
public class Cliente {

    private int codigo;
    private String email;
    private String senha;
    private String nome;
    private String telefone;
    private String cpf;
    private Date DataNascimento;
    private Endereco endereco;
    private Date dataCadastro;

    public Cliente() {
    }
    
    public Cliente(int codigo, String email, String senha, String nome, String telefone, String cpf, Date DataNascimento, Endereco endereco, Date dataCadastro) {
        this.codigo = codigo;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.DataNascimento = DataNascimento;
        this.endereco = endereco;
        this.dataCadastro = dataCadastro;
    }


   public Cliente(String str) {
        String[] vetor = str.split(";");
        this.codigo = Integer.parseInt(vetor[0]);
        this.nome = vetor[1];
        this.email = vetor[2];
        this.telefone = vetor[3];
        this.cpf = vetor[4];
//        this.dataCadastro = new java.sql.Date(vetor[5]);
   }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(Date DataNascimento) {
        this.DataNascimento = DataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public String toString() {
        return "Cliente{" + "codigo=" + codigo + ", email=" + email + ", senha=" + senha + ", nome=" + nome + ", telefone=" + telefone + ", cpf=" + cpf + ", DataNascimento=" + DataNascimento + ", endereco=" + endereco + ", dataCadastro=" + dataCadastro + '}';
    }


}
