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
public class Recomendacao {
    
    private boolean idade;
    private boolean genero;
    private boolean idioma;

    public Recomendacao(boolean idade, boolean genero, boolean idioma) {
        this.idade = idade;
        this.genero = genero;
        this.idioma = idioma;
    }

    public boolean isIdade() {
        return idade;
    }

    public void setIdade(boolean idade) {
        this.idade = idade;
    }

    public boolean isGenero() {
        return genero;
    }

    public void setGenero(boolean genero) {
        this.genero = genero;
    }

    public boolean isIdioma() {
        return idioma;
    }

    public void setIdioma(boolean idioma) {
        this.idioma = idioma;
    }
    
    
    
}
