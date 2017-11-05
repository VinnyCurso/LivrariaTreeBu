/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.business;

import br.com.treebu.dao.AutorDao;
import br.com.treebu.model.Autor;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author vinicius caetano
 */
public class AutorBusiness {
    
     AutorDao autorDAO;

    public AutorBusiness() throws SQLException {
        autorDAO = new AutorDao();
    }

    public void Salvar(Autor autor) throws SQLException, Exception {

        if (validar(autor)) {
            if (autor.getCodigo() == 0) {
                autorDAO.Cadastrar(autor);
            } else {
                autorDAO.Atualizar(autor);
            }
        }
    }

    public void Excluir(int codigo) throws SQLException, Exception {
        autorDAO.Deletar(codigo);
    }

    public Autor Consultar(int codigo) throws SQLException {
        return autorDAO.ConsultarPorCodigo(codigo);
    }

    public List<Autor> listar(String nome) throws SQLException {
        return autorDAO.Listar();
    }

    private boolean validar(Autor autor) throws Exception {
        
        if (autor.getNome()== null) {
            throw new Exception("É necessário preencher o campo Nome.");
        }
        if (autor.getNome().isEmpty()) {
            throw new Exception("É necessário preencher o campo Nome.");
        }
        
        if (autor.getNacionalidade()== null) {
            throw new Exception("É necessário preencher o campo Nacionalidade.");
        }
        if (autor.getNacionalidade().isEmpty()) {
            throw new Exception("É necessário preencher o campo Nacionalidade.");
        }
        
        if (autor.getDescricao()== null) {
            throw new Exception("É necessário preencher o campo Descricao.");
        }
        if (autor.getDescricao().isEmpty()) {
            throw new Exception("É necessário preencher o campo Descricao.");
        }
        return true;
    }
    
}
