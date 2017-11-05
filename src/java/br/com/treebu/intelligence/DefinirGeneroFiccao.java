/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.intelligence;

import br.com.treebu.model.Recomendacao;
import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;

/**
 *
 * @author vinicius caetano
 */
@Rule(name = "Define Genero Ficção", description = "regra para definir se recomendara o genero Ficção")
public class DefinirGeneroFiccao {
    
    private Recomendacao recomendacao;
    private String ficcao;
    
    @Condition
    public boolean when() {
        if (!recomendacao.isIdade()) {
            if (recomendacao.isGenero()) {
                if (recomendacao.isIdioma()) {
                    return true;
                }
            }
        }
        return false;
    }
    
    @Action(order = 1)
    public void primeiraReacao() throws Exception {
        System.out.println("Recomendado os livros dos Generos Ficção");
    }
    
    public void setRecomendacao(Recomendacao recomendacao) {
        this.recomendacao = recomendacao;
    }
    
}
