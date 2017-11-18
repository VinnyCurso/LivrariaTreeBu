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
public class Editora {

    private int codigo;
    private String nome; //Inlcuido na documentação
    private String razaoSocial;
    private String cnpj;
    private Endereco endereco;
    private String telefone;
    private String email;
    private String representante;  //nao possui na documentação

    public Editora() {
    }

    //Construtor Anterior
    public Editora(int codigo, String razaoSocial, String cnpj, Endereco endereco, String telefone, String email, String representante) {
        this.codigo = codigo;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.representante = representante;
    }

    //Construtor Pos Documentação
    public Editora(int codigo, String nome, String razaoSocial, String cnpj, Endereco endereco, String telefone) {
        this.codigo = codigo;
        this.nome = nome;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.telefone = telefone;
    }
    
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    //Get em analise
    public String getRepresentante() {
        return representante;
    }
    //Set em analise
    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    //Get add
    public String getNome() {
        return nome;
    }
    //Set add
    public void setNome(String nome) {
        this.nome = nome;
    }

  

}
