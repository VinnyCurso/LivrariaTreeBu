/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.business;

import br.com.treebu.dao.ClienteDao;
import br.com.treebu.model.Cliente;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author vinicius caetano
 */
public class ClienteBusiness {

    ClienteDao ClienteDAO;

    public ClienteBusiness() throws SQLException {
        ClienteDAO = new ClienteDao();
    }

    public void Salvar(Cliente cliente) throws SQLException, Exception {

        if (validar(cliente)) {
            if (cliente.getCodigo() == 0) {
                ClienteDAO.Cadastrar(cliente);
            } else {
                ClienteDAO.Atualizar(cliente);
            }
        }
    }

    public void Excluir(int codigo) throws SQLException, Exception {
        ClienteDAO.Deletar(codigo);
    }

    public Cliente Consultar(int codigo) throws SQLException {
        return ClienteDAO.ConsultarPorCodigo(codigo);
    }

    public List<Cliente> listar(String nome) throws SQLException {
        return ClienteDAO.Listar();
    }

    private boolean validar(Cliente cliente) throws Exception {

        if (cliente.getNome() == null) {
            throw new Exception("É necessário preencher o campo Nome.");
        }
        if (cliente.getNome().isEmpty()) {
            throw new Exception("É necessário preencher o campo Nome.");
        }
        
         if (cliente.getEmail()== null) {
            throw new Exception("É necessário preencher o campo Email.");
        }
        if (cliente.getEmail().isEmpty()) {
            throw new Exception("É necessário preencher o campo Email.");
        }
        
          if (cliente.getSenha()== null) {
            throw new Exception("É necessário preencher o campo Senha.");
        }
        if (cliente.getSenha().isEmpty()) {
            throw new Exception("É necessário preencher o campo Senha.");
        }
        
        if (cliente.getCpf()== null) {
            throw new Exception("É necessário preencher o campo Cpf.");
        }
        if (cliente.getCpf().isEmpty()) {
            throw new Exception("É necessário preencher o campo Cpf.");
        }
          
        return true;
    }

}
