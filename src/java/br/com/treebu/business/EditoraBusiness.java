/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.business;

import br.com.treebu.dao.EditoraDao;
import br.com.treebu.model.Editora;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author vinicius caetano
 */
public class EditoraBusiness {
    
     EditoraDao editoraDAO;

    public EditoraBusiness() throws SQLException {
        editoraDAO = new EditoraDao();
    }

    public void Salvar(Editora editora) throws SQLException, Exception {

        if (validar(editora)) {
            if (editora.getCodigo() == 0) {
                editoraDAO.Cadastrar(editora);
            } else {
                editoraDAO.Atualizar(editora);
            }
        }
    }

    public void Excluir(int codigo) throws SQLException, Exception {
        editoraDAO.Deletar(codigo);
    }

    public Editora Consultar(int codigo) throws SQLException {
        return editoraDAO.ConsultarPorCodigo(codigo);
    }

    public List<Editora> listar(String nome) throws SQLException {
        return editoraDAO.Listar();
    }

    private boolean validar(Editora editora) throws Exception {

        if (editora.getRazaoSocial()== null) {
            throw new Exception("É necessário preencher o campo Razao Social.");
        }
        if (editora.getRazaoSocial().isEmpty()) {
            throw new Exception("É necessário preencher o campo Razao Social.");
        }
        
        if (editora.getCnpj()== null) {
            throw new Exception("É necessário preencher o campo Cnpj.");
        }
        if (editora.getCnpj().isEmpty()) {
            throw new Exception("É necessário preencher o campo Cnpj.");
        }
        
         if (editora.getEmail()== null) {
            throw new Exception("É necessário preencher o campo Email.");
        }
        if (editora.getEmail().isEmpty()) {
            throw new Exception("É necessário preencher o campo Email.");
        }
        
        if (editora.getRepresentante() == null) {
            throw new Exception("É necessário preencher o campo Representante.");
        }
        if (editora.getRepresentante().isEmpty()) {
            throw new Exception("É necessário preencher o campo Representante.");
        }
        
        
        return true;
    }

    
}
