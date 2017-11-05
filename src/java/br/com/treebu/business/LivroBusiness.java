/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.business;

import br.com.treebu.dao.LivroDao;
import br.com.treebu.model.Livro;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author vinicius caetano
 */
public class LivroBusiness {
    
     LivroDao livroDAO;

    public LivroBusiness() throws SQLException {
        livroDAO = new LivroDao();
    }

    public void Salvar(Livro livro) throws SQLException, Exception {

        if (validar(livro)) {
            if (livro.getCodigo() == 0) {
                livroDAO.Cadastrar(livro);
            } else {
                livroDAO.Atualizar(livro);
            }
        }
    }

    public void Excluir(int codigo) throws SQLException, Exception {
        livroDAO.Deletar(codigo);
    }

    public Livro Consultar(int codigo) throws SQLException {
        return livroDAO.ConsultarPorCodigo(codigo);
    }

    public List<Livro> listar(String nome) throws SQLException {
        return livroDAO.Listar();
    }

    private boolean validar(Livro livro) throws Exception {

        if (livro.getNome() == null) {
            throw new Exception("É necessário preencher o campo Nome.");
        }
        if (livro.getNome().isEmpty()) {
            throw new Exception("É necessário preencher o campo Nome.");
        }
        
        if (livro.getDescricao()== null) {
            throw new Exception("É necessário preencher o campo Descricao.");
        }
        if (livro.getDescricao().isEmpty()) {
            throw new Exception("É necessário preencher o campo Descricao.");
        }
        
        return true;
    }

    
}
