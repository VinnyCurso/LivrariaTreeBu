/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.dao;

import br.com.treebu.model.Endereco;
import br.com.treebu.util.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author vinicius caetano
 */
public class EnderecoDao {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultset;

    public EnderecoDao() throws SQLException {
        connection = ConexaoBD.getConnection();
    }

    public void Cadastrar(Endereco endereco) {

        try {
            preparedStatement = connection
            .prepareStatement("insert into endereco (logradouro, complemento, bairro, cidade, estado, cep) values (?,?,?,?,?,?)");

            preparedStatement.setString(1, endereco.getLogradouro()); //Doc = 40 caracteres 
            preparedStatement.setString(2, endereco.getComplemento()); //Doc = 40 caracteres 
            preparedStatement.setString(3, endereco.getBairro()); //Doc = 40 caracteres 
            preparedStatement.setString(4, endereco.getCidade()); //Doc = 40 caracteres 
            preparedStatement.setString(5, endereco.getEstado()); //Doc = 20 caracteres 
            preparedStatement.setString(6, endereco.getCep()); //Doc =  caracteres nao informado

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public void Deletar(int codigo) {
        try {
            preparedStatement = connection
           .prepareStatement("delete from endereco where cod_endereco=?");

            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public void Atualizar(Endereco endereco) {

        try {
            preparedStatement = connection
                    .prepareStatement("update endereco set logradouro=?, complemento=?, bairro=?,"
                            + " cidade=?, estado=?, cep=?"
                            + "where cod_endereco=?");

            preparedStatement.setString(1, endereco.getLogradouro());
            preparedStatement.setString(2, endereco.getComplemento());
            preparedStatement.setString(3, endereco.getBairro());
            preparedStatement.setString(4, endereco.getCidade());
            preparedStatement.setString(5, endereco.getEstado());
            preparedStatement.setString(6, endereco.getCep());

            preparedStatement.setInt(7, endereco.getCodigo());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public List<Endereco> Listar() {
        List<Endereco> enderecoList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            resultset = statement.executeQuery("select * from endereco");
            while (resultset.next()) {

                Endereco endereco = new Endereco();

                endereco.setCodigo(resultset.getInt("cod_endereco"));
                endereco.setLogradouro(resultset.getString("logradouro"));
                endereco.setComplemento(resultset.getString("complemento"));
                endereco.setBairro(resultset.getString("bairro"));
                endereco.setCidade(resultset.getString("cidade"));
                endereco.setEstado(resultset.getString("estado"));
                endereco.setCep(resultset.getString("cep"));

                enderecoList.add(endereco);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }

        return enderecoList;
    }

    public Endereco ConsultarPorCodigo(int codigo) {
        Endereco endereco = new Endereco();
        try {
            preparedStatement = connection
           .prepareStatement("select * from endereco where cod_endereco=?");
            preparedStatement.setInt(1, codigo);
            resultset = preparedStatement.executeQuery();

            if (resultset.next()) {

                endereco.setCodigo(resultset.getInt("cod_endereco"));
                endereco.setLogradouro(resultset.getString("logradouro"));
                endereco.setComplemento(resultset.getString("complemento"));
                endereco.setBairro(resultset.getString("bairro"));
                endereco.setCidade(resultset.getString("cidade"));
                endereco.setEstado(resultset.getString("estado"));
                endereco.setCep(resultset.getString("cep"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }

        return endereco;
    }

}
