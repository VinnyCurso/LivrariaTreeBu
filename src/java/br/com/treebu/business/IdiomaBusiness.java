/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.business;

import br.com.treebu.dao.IdiomaDao;
import br.com.treebu.model.Idioma;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author vinicius caetano
 */
public class IdiomaBusiness {
    
    IdiomaDao idiomaDAO;

    public IdiomaBusiness() throws SQLException {
        idiomaDAO = new IdiomaDao();
    }

    public void Salvar(Idioma idioma) throws SQLException, Exception {

        if (validar(idioma)) {
            if (idioma.getCodigo() == 0) {
                idiomaDAO.Cadastrar(idioma);
            } else {
                idiomaDAO.Atualizar(idioma);
            }
        }
    }

    public void Excluir(int codigo) throws SQLException, Exception {
        idiomaDAO.Deletar(codigo);
    }

    public Idioma Consultar(int codigo) throws SQLException {
        return idiomaDAO.ConsultarPorCodigo(codigo);
    }

    public List<Idioma> listar(String nome) throws SQLException {
        return idiomaDAO.Listar();
    }

    private boolean validar(Idioma genero) throws Exception {

        if (genero.getDescricao()== null) {
            throw new Exception("É necessário preencher o campo Descricao.");
        }
        if (genero.getDescricao().isEmpty()) {
            throw new Exception("É necessário preencher o campo Descricao.");

        }
        return true;
    }
    
}
