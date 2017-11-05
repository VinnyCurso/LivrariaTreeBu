/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.business;

import br.com.treebu.dao.EnderecoDao;
import br.com.treebu.model.Endereco;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author vinicius caetano
 */
public class EnderecoBusiness {
    
     EnderecoDao enderecoDAO;

    public EnderecoBusiness() throws SQLException {
        enderecoDAO = new EnderecoDao();
    }

    public void Salvar(Endereco endereco) throws SQLException, Exception {

        if (validar(endereco)) {
            if (endereco.getCodigo() == 0) {
                enderecoDAO.Cadastrar(endereco);
            } else {
                enderecoDAO.Atualizar(endereco);
            }
        }
    }

    public void Excluir(int codigo) throws SQLException, Exception {
        enderecoDAO.Deletar(codigo);
    }

    public Endereco Consultar(int codigo) throws SQLException {
        return enderecoDAO.ConsultarPorCodigo(codigo);
    }

    public List<Endereco> listar(String nome) throws SQLException {
        return enderecoDAO.Listar();
    }

    private boolean validar(Endereco cliente) throws Exception {

        if (cliente.getLogradouro()== null) {
            throw new Exception("É necessário preencher o campo Logradouro.");
        }
        if (cliente.getLogradouro().isEmpty()) {
            throw new Exception("É necessário preencher o campo Logradouro.");
        }
        
        if (cliente.getBairro()== null) {
            throw new Exception("É necessário preencher o campo Bairro.");
        }
        if (cliente.getBairro().isEmpty()) {
            throw new Exception("É necessário preencher o campo Bairro.");
        }
        
        if (cliente.getCidade()== null) {
            throw new Exception("É necessário preencher o campo Cidade.");
        }
        if (cliente.getCidade().isEmpty()) {
            throw new Exception("É necessário preencher o campo Cidade.");
        }
        
        if (cliente.getEstado()== null) {
            throw new Exception("É necessário preencher o campo Estado.");
        }
        if (cliente.getEstado().isEmpty()) {
            throw new Exception("É necessário preencher o campo Estado.");
        }
        
        if (cliente.getCep()== null) {
            throw new Exception("É necessário preencher o campo Cep.");
        }
        if (cliente.getCep().isEmpty()) {
            throw new Exception("É necessário preencher o campo Cep.");
        }
        
        return true;
    }

    
}
