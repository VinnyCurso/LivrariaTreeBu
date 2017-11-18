/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vinicius caetano
 */
public class Carrinho {

    private List<Livro> livros;

    public Carrinho() {
        livros = new ArrayList<>();
    }

    public void add(Livro livro) {
        livros.add(livro);
    }

    public Livro menorLivro() throws CarrinhoVazio {
        if (livros.isEmpty()) {
            throw new CarrinhoVazio();
        }
        Livro menor = livros.get(0);
        for (Livro livro : livros) {
            if (livro.getPreco() < menor.getPreco()) {
                menor = livro;
            }
        }
        return menor;
    }

}
