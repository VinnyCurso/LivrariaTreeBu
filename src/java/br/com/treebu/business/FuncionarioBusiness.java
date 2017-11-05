/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.business;

import br.com.treebu.dao.FuncionarioDao;
import br.com.treebu.model.Funcionario;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author vinicius caetano
 */
public class FuncionarioBusiness {
    
    FuncionarioDao funcionarioDAO;

    public FuncionarioBusiness() throws SQLException {
        funcionarioDAO = new FuncionarioDao();
    }

    public void Salvar(Funcionario funcionario) throws SQLException, Exception {

        if (validar(funcionario)) {
            if (funcionario.getCodigo() == 0) {
                funcionarioDAO.Cadastrar(funcionario);
            } else {
                funcionarioDAO.Atualizar(funcionario);
            }
        }
    }

    public void Excluir(int codigo) throws SQLException, Exception {
        funcionarioDAO.Deletar(codigo);
    }

    public Funcionario Consultar(int codigo) throws SQLException {
        return funcionarioDAO.ConsultarPorCodigo(codigo);
    }

    public List<Funcionario> listar(String nome) throws SQLException {
        return funcionarioDAO.Listar();
    }

    private boolean validar(Funcionario funcionario) throws Exception {

        if (funcionario.getNome() == null) {
            throw new Exception("É necessário preencher o campo Nome.");
        }
        if (funcionario.getNome().isEmpty()) {
            throw new Exception("É necessário preencher o campo Nome.");
        }
        
        if (funcionario.getEmail() == null) {
            throw new Exception("É necessário preencher o campo Email.");
        }
        if (funcionario.getEmail().isEmpty()) {
            throw new Exception("É necessário preencher o campo Email.");
        }
        
        if (funcionario.getSenha()== null) {
            throw new Exception("É necessário preencher o campo Senha.");
        }
        if (funcionario.getSenha().isEmpty()) {
            throw new Exception("É necessário preencher o campo Senha.");
        }
        
        if (funcionario.getCpf()== null) {
            throw new Exception("É necessário preencher o campo Cpf.");
        }
        if (funcionario.getCpf().isEmpty()) {
            throw new Exception("É necessário preencher o campo Cpf.");
        }
        
        return true;
    }
    
}
