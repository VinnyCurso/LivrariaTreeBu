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
public class Funcionario {

    private int codigo;
    private String email;
    private String senha;
    private String nome;
    private String telefone;
    private String cpf;
    private Date DataNascimento;
    private Endereco endereco;
    private Date dataAdmissao;
    private String ctps;

    public Funcionario() {
    }

    public Funcionario(int codigo, String email, String senha, String nome, String telefone, String cpf, Date DataNascimento, Endereco endereco, Date dataAdmissao, String ctps) {
        this.codigo = codigo;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.DataNascimento = DataNascimento;
        this.endereco = endereco;
        this.dataAdmissao = dataAdmissao;
        this.ctps = ctps;
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

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "codigo=" + codigo + ", email=" + email + ", senha=" + senha + ", nome=" + nome + ", telefone=" + telefone + ", cpf=" + cpf + ", DataNascimento=" + DataNascimento + ", endereco=" + endereco + ", dataAdmissao=" + dataAdmissao + ", ctps=" + ctps + '}';
    }
    
    

   
}
