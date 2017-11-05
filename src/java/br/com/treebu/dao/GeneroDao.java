/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.dao;

import br.com.treebu.model.Genero;
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
public class GeneroDao {
    
     private Connection connection;

    public GeneroDao() throws SQLException {
        connection = ConexaoBD.getConnection();
    }

    public void Cadastrar(Genero genero) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into genero (bdescricao) values (?)");

            preparedStatement.setString(1, genero.getDescricao());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public void Deletar(int codigo) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from genero where cod_genero=?");

            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public void Atualizar(Genero genero) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update genero set bdescricao=?"
                            + "where cod_genero=?");

            preparedStatement.setString(1, genero.getDescricao());

            preparedStatement.setInt(2, genero.getCodigo());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public List<Genero> Listar() {
        List<Genero> generoList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from genero");
            while (rs.next()) {

                Genero genero = new Genero();

                genero.setCodigo(rs.getInt("cod_genero"));
                genero.setDescricao(rs.getString("bdescricao"));

                generoList.add(genero);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }

        return generoList;
    }

    public Genero ConsultarPorCodigo(int codigo) {
        Genero genero = new Genero();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from genero where cod_genero=?");
            preparedStatement.setInt(1, codigo);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                genero.setCodigo(rs.getInt("cod_genero"));
                genero.setDescricao(rs.getString("bdescricao"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }

        return genero;
    }

    public Genero ConsultarDescricao(String descricao) {
        Genero genero = new Genero();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from genero where bdescricao=?");
            preparedStatement.setString(1, descricao);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {

                genero.setDescricao(rs.getString("bdescricao"));
                genero.setCodigo(rs.getInt("cod_genero"));

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }

        return genero;
    }

    
}
