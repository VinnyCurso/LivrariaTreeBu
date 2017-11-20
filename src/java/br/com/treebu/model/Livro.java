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
public class Livro {

    private int codigo;
    private Editora editora;
    private Autor autor;
    private Genero genero;
    private Idioma idioma;
    private Date dataPublicacao;
    private String nome;
    private String descricao;
    private int numeroPaginas;
    private int ano;
    private Double preco;
    private int avaliacao;
    private String isbn;
    private Byte capa;
    private int qtd_livro;

    public Livro() {
    }

    public Livro(int codigo, Editora editora, Autor autor, Genero genero, Idioma idioma, Date dataPublicacao, String nome, String descricao, int numeroPaginas, int ano, Double preco, int avaliacao, String isbn, Byte capa, int qtd_livro) {
        this.codigo = codigo;
        this.editora = editora;
        this.autor = autor;
        this.genero = genero;
        this.idioma = idioma;
        this.dataPublicacao = dataPublicacao;
        this.nome = nome;
        this.descricao = descricao;
        this.numeroPaginas = numeroPaginas;
        this.ano = ano;
        this.preco = preco;
        this.avaliacao = avaliacao;
        this.isbn = isbn;
        this.capa = capa;
        this.qtd_livro = qtd_livro;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Byte getCapa() {
        return capa;
    }

    public void setCapa(Byte capa) {
        this.capa = capa;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    
    public int getQtd_livro() {
        return qtd_livro;
    }

    public void setQtd_livro(int qtd_livro) {
        this.qtd_livro = qtd_livro;
    }
       
    @Override
    public String toString() {
        return "Livro{" + "codigo=" + codigo + ", editora=" + editora + ", autor=" + autor + ", genero=" + genero + ", idioma=" + idioma + ", dataPublicacao=" + dataPublicacao + ", nome=" + nome + ", descricao=" + descricao + ", numeroPaginas=" + numeroPaginas + ", ano=" + ano +", preco=" + preco + ", avaliacao=" + avaliacao + ", isbn=" + isbn + ", capa=" + capa + ", qtd_livro=" + qtd_livro + '}';
    }

    

}
