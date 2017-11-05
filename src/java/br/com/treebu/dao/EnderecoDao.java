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

    public EnderecoDao() throws SQLException {
        connection = ConexaoBD.getConnection();
    }

    public void Cadastrar(Endereco endereco) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into endereco (blogradouro,bcomplemento,bbairro,bcidade,bestado,bcep) values (?,?,?,?,?,?)");

            preparedStatement.setString(1, endereco.getLogradouro());
            preparedStatement.setString(2, endereco.getComplemento());
            preparedStatement.setString(3, endereco.getBairro());
            preparedStatement.setString(4, endereco.getCidade());
            preparedStatement.setString(5, endereco.getEstado());
            preparedStatement.setString(6, endereco.getCep());


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public void Deletar(int codigo) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from endereco where cod_endereco=?");

            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public void Atualizar(Endereco endereco) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update endereco set blogradouro=?,bcomplemento=?,bbairro=?"
                            + "bcidade=?,bestado=?,bcep=?"
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
            ResultSet rs = statement.executeQuery("select * from endereco");
            while (rs.next()) {

                Endereco endereco = new Endereco();

                endereco.setCodigo(rs.getInt("cod_endereco"));
                endereco.setLogradouro(rs.getString("blogradouro"));
                endereco.setComplemento(rs.getString("bcomplemento"));
                endereco.setBairro(rs.getString("bbairro"));
                endereco.setCidade(rs.getString("bcidade"));
                endereco.setEstado(rs.getString("bestado"));
                endereco.setCep(rs.getString("bcep"));

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
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from endereco where cod_endereco=?");
            preparedStatement.setInt(1, codigo);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
               
                endereco.setCodigo(rs.getInt("cod_endereco"));
                endereco.setLogradouro(rs.getString("blogradouro"));
                endereco.setComplemento(rs.getString("bcomplemento"));
                endereco.setBairro(rs.getString("bbairro"));
                endereco.setCidade(rs.getString("bcidade"));
                endereco.setEstado(rs.getString("bestado"));
                endereco.setCep(rs.getString("bcep"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }

        return endereco;
    }
    
}
