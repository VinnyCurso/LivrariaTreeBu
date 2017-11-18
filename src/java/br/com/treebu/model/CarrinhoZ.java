/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author vinicius caetano
 */
public class CarrinhoZ implements Serializable {

//    private static final long serialVersionUID = 1L;
//
//    private int codigo;
//    private Set<Livro> livros;
//
//    public void adicionaProduto(Produto produto, Integer quantidade) {
//
//        Livro livro = new Livro();
//
//        livro.setProduto(new ProdutoDAO().find(produto.getCodigo()));
//        livro.setQuantidade(quantidade);
//        livro.setCarrinho(this);
//        
//        if (this.livros == null) {
//            this.livros = new HashSet<Livro>();
//        }
//        
//        boolean produtoExiste = false;
//        
//        for (Iterator<Livro> it = this.livros.iterator(); it.hasNext();) {
//            Livro next = it.next();
//            
//            if (next.getProduto().getCodigo().equals(produto.getCodigo())) {
//                next.setQuantidade(livro.getQuantidade());
//                produtoExiste = true;
//                break;
//            }
//        }
//        
//        if (!produtoExiste) {
//            this.livros.add(livro);
//        }
//
//        if (this.codigo != null) {
//            new CarrinhoDAO().merge(this);
//        } else {
//            new CarrinhoDAO().save(this);
//        }
//    
//                
//
//    public void removeProduto(Produto produto) {
//        produto = new ProdutoDAO().find(produto.getCodigo());
//        for (Iterator<Livro> it = getLivros().iterator(); it.hasNext();) {
//            Livro next = it.next();
//            if (next.getProduto().getCodigo().equals(produto.getCodigo())) {
//                next.setCarrinho(null);
//                it.remove();
//                break;
//            }
//        }
//        if (getLivros()!= null && getLivros().size() == 0) {
//            this.livros = null;
//        }
//        new LivroDAO().removeItem(produto, this);
//    }
//
//    public double retornaTotal() {
//        double total = 0.0;
//        Set<Livro> lista = getLivros();
//        if (lista != null) {
//            for (Livro livro : lista) {
//                total += (livro.getProduto().getPreco() * livro.getQuantidade());
//            }
//        }
//        return total;
//    }
//
//    public void setCodigo(int codigo) {
//        this.codigo = codigo;
//    }
//
//    public Set<Livro> getLivros() {
//        if (livros == null) {
//            livros = new LivroDAO().getItensByCarrinho(this);
//        }
//        return livros;
//    }

}
