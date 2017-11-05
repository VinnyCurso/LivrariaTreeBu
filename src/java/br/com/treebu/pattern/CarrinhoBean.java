/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.pattern;

import br.com.treebu.model.Livro;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.ManagedBean;

/**
 *
 * @author vinicius caetano
 */
@ManagedBean
//@SessionScoped
public class CarrinhoBean {

    private Set<Livro> livro = new HashSet<>();

    public CarrinhoBean() {
    }

    public Set<Livro> getLivro() {
        return Collections.unmodifiableSet(livro);
    }

    public void setLivro(Set<Livro> livro) {
        this.livro = livro;
    }

    public void adicionar(Livro livro) {
        this.livro.add(livro);
    }

    public void remover(Livro livro) {
        this.livro.remove(livro);
    }

    public void finalizarCompra() {
        // código para finalizar a compra. 
    }

}
