/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.business;

import br.com.treebu.dao.EstoqueDao;
import br.com.treebu.model.Estoque;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author vinicius caetano
 */
public class EstoqueBusiness {
    
        EstoqueDao estoqueDAO;

    public EstoqueBusiness() throws SQLException {
        estoqueDAO = new EstoqueDao();
    }

    public void Salvar(Estoque estoque) throws SQLException, Exception {

        if (validar(estoque)) {
            if (estoque.getCodigo() == 0) {
                estoqueDAO.Cadastrar(estoque);
            } else {
                estoqueDAO.Atualizar(estoque);
            }
        }
    }

    public void Excluir(int codigo) throws SQLException, Exception {
        estoqueDAO.Deletar(codigo);
    }

    public Estoque Consultar(int codigo) throws SQLException {
        return estoqueDAO.ConsultarPorCodigo(codigo);
    }

    public List<Estoque> listar(String nome) throws SQLException {
        return estoqueDAO.Listar();
    }

    private boolean validar(Estoque estoque) throws Exception {

        if (estoque.getDescProduto()== null) {
            throw new Exception("É necessário preencher o campo Descrição do Produto.");
        }
        if (estoque.getDescProduto().isEmpty()) {
            throw new Exception("É necessário preencher o campo Descrição do Produto.");

        }
        
        return true;
    }
    
}
