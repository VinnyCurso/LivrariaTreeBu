/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.business;

import br.com.treebu.dao.PedidoDao;
import br.com.treebu.model.Pedido;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author vinicius caetano
 */
public class PedidoBusiness {
    
     PedidoDao pedidoDAO;

    public PedidoBusiness() throws SQLException {
        pedidoDAO = new PedidoDao();
    }

    public void Salvar(Pedido pedido) throws SQLException, Exception {

        if (validar(pedido)) {
            if (pedido.getNumero()== 0) {
                pedidoDAO.Cadastrar(pedido);
            } else {
                pedidoDAO.Atualizar(pedido);
            }
        }
    }

    public void Excluir(int codigo) throws SQLException, Exception {
        pedidoDAO.Deletar(codigo);
    }

    public Pedido Consultar(int codigo) throws SQLException {
        return pedidoDAO.ConsultarPorCodigo(codigo);
    }

    public List<Pedido> listar(String nome) throws SQLException {
        return pedidoDAO.Listar();
    }

    private boolean validar(Pedido pedido) throws Exception {

        if (pedido.getValorTotal()== null) {
            throw new Exception("É necessário preencher o campo Valor Total.");
        }
        
        return true;
    }

    
}
