/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.pattern;

import br.com.treebu.model.Livro;

/**
 *
 * @author vinicius caetano
 */
public interface Observador {
    
     public void atualizar(Livro livro);
    
}
