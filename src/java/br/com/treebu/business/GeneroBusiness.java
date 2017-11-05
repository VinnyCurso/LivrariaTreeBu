/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.business;

import br.com.treebu.dao.GeneroDao;
import br.com.treebu.model.Genero;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author vinicius caetano
 */
public class GeneroBusiness {
    
    GeneroDao generoDAO;

    public GeneroBusiness() throws SQLException {
        generoDAO = new GeneroDao();
    }

    public void Salvar(Genero genero) throws SQLException, Exception {

        if (validar(genero)) {
            if (genero.getCodigo() == 0) {
                generoDAO.Cadastrar(genero);
            } else {
                generoDAO.Atualizar(genero);
            }
        }
    }

    public void Excluir(int codigo) throws SQLException, Exception {
        generoDAO.Deletar(codigo);
    }

    public Genero Consultar(int codigo) throws SQLException {
        return generoDAO.ConsultarPorCodigo(codigo);
    }

    public List<Genero> listar(String nome) throws SQLException {
        return generoDAO.Listar();
    }

    private boolean validar(Genero genero) throws Exception {

        if (genero.getDescricao()== null) {
            throw new Exception("É necessário preencher o campo Descricao.");
        }
        if (genero.getDescricao().isEmpty()) {
            throw new Exception("É necessário preencher o campo Descricao.");

        }
        return true;
    }
    
}
