/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.dao;

import br.com.treebu.model.Autor;
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
public class AutorDao {

    private Connection connection;

    public AutorDao() throws SQLException {
        connection = ConexaoBD.getConnection();
    }

    public void Cadastrar(Autor autor) {

        try {
            PreparedStatement preparedStatement = connection
            .prepareStatement("insert into autor (bnome, bnacionalidade, datenascimento, bstatus, bdescricao) values (?,?,?,?,?)");

            preparedStatement.setString(1, autor.getNome());
            preparedStatement.setString(2, autor.getNacionalidade());
            preparedStatement.setDate(3, new java.sql.Date(autor.getDataNascimento().getTime()));
            preparedStatement.setBoolean(4, autor.isStatus());
            preparedStatement.setString(5, autor.getDescricao());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public void Deletar(int codigo) {
        try {
            PreparedStatement preparedStatement = connection
            .prepareStatement("delete from autor where cod_autor=?");

            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public void Atualizar(Autor autor) {

        try {
            PreparedStatement preparedStatement = connection
            .prepareStatement("update autor set bnome=?, bnacionalidade=?, datenascimento=?,"
             + "bstatus=?, bdescricao=?,"
             + "where cod_autor=?");

            preparedStatement.setString(1, autor.getNome());
            preparedStatement.setString(2, autor.getNacionalidade());
            preparedStatement.setDate(3, new java.sql.Date(autor.getDataNascimento().getTime()));
            preparedStatement.setBoolean(4, autor.isStatus());
            preparedStatement.setString(5, autor.getDescricao());

            preparedStatement.setInt(6, autor.getCodigo());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public List<Autor> Listar() {
        List<Autor> autorList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from autor");
            while (rs.next()) {

                Autor autor = new Autor();

                autor.setCodigo(rs.getInt("cod_autor"));
                autor.setNome(rs.getString("bnome"));
                autor.setNacionalidade(rs.getString("bnacionalidade"));
                autor.setDataNascimento(rs.getDate("datenascimento"));
                autor.setStatus(rs.getBoolean("bstatus"));
                autor.setDescricao(rs.getString("bdescricao"));

                autorList.add(autor);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }

        return autorList;
    }

    public Autor ConsultarPorCodigo(int codigo) {
        Autor autor = new Autor();
        try {
            PreparedStatement preparedStatement = connection.
            prepareStatement("select * from autor where cod_autor=?");
            preparedStatement.setInt(1, codigo);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {

                autor.setCodigo(rs.getInt("cod_autor"));
                autor.setNome(rs.getString("bnome"));
                autor.setNacionalidade(rs.getString("bnacionalidade"));
                autor.setDataNascimento(rs.getDate("datenascimento"));
                autor.setStatus(rs.getBoolean("bstatus"));
                autor.setDescricao(rs.getString("bdescricao"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }

        return autor;
    }

}
