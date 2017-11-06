/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.dao;

import br.com.treebu.model.Livro;
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
public class LivroDao {

    private Connection connection;

    public LivroDao() throws SQLException {
        connection = ConexaoBD.getConnection();
    }

    public void Cadastrar(Livro livro) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into livro (codeditora,codautor,codgenero,codidioma,"
                            + "datepublicacao,bnome,bdescricao,bnumpaginas,bpreco,"
                            + "bavaliacao,bisbn,bcapa)"
                            + " values (?,?,?,?,?,?,?,?,?,?,?,?)");

            preparedStatement.setInt(1, livro.getEditora().getCodigo());
            preparedStatement.setInt(2, livro.getAutor().getCodigo());
            preparedStatement.setInt(3, livro.getGenero().getCodigo());
            preparedStatement.setInt(4, livro.getIdioma().getCodigo());
            preparedStatement.setDate(5, new java.sql.Date(livro.getDataPublicacao().getTime()));
            preparedStatement.setString(6, livro.getNome());
            preparedStatement.setString(7, livro.getDescricao());
            preparedStatement.setInt(8, livro.getNumeroPaginas());
            preparedStatement.setDouble(9, livro.getPreco());
            preparedStatement.setInt(10, livro.getAvaliacao());
            preparedStatement.setString(11, livro.getIsbn());
            preparedStatement.setByte(12, livro.getCapa());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public void Deletar(int codigo) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from livro where cod_livro=?");

            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public void Atualizar(Livro livro) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update livro set codeditora=?,codautor=?,codgenero=?,codidioma=?,"
                            + "datepublicacao=?,bnome=?,bdescricao=?,bnumpaginas=?,bpreco=?,"
                            + "bavaliacao=?,bisbn=?,bcapa=?,"
                            + "where cod_livro=?");

            preparedStatement.setInt(1, livro.getEditora().getCodigo());
            preparedStatement.setInt(2, livro.getAutor().getCodigo());
            preparedStatement.setInt(3, livro.getGenero().getCodigo());
            preparedStatement.setInt(4, livro.getIdioma().getCodigo());
            preparedStatement.setDate(5, new java.sql.Date(livro.getDataPublicacao().getTime()));
            preparedStatement.setString(6, livro.getNome());
            preparedStatement.setString(7, livro.getDescricao());
            preparedStatement.setInt(8, livro.getNumeroPaginas());
            preparedStatement.setDouble(9, livro.getPreco());
            preparedStatement.setInt(10, livro.getAvaliacao());
            preparedStatement.setString(11, livro.getIsbn());
            preparedStatement.setByte(12, livro.getCapa());

            preparedStatement.setInt(13, livro.getCodigo());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public List<Livro> Listar() {
        List<Livro> livroList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from livro");
            while (rs.next()) {

                Livro livro = new Livro();

                livro.setCodigo(rs.getInt("cod_livro"));
                EditoraDao editoraDAO = new EditoraDao();
                livro.setEditora(editoraDAO.ConsultarPorCodigo(rs.getInt("cod_editora")));
                AutorDao autorDAO = new AutorDao();
                livro.setAutor(autorDAO.ConsultarPorCodigo(rs.getInt("cod_autor")));
                GeneroDao generoDAO = new GeneroDao();
                livro.setGenero(generoDAO.ConsultarPorCodigo(rs.getInt("cod_genero")));
                IdiomaDao idiomaDAO = new IdiomaDao();
                livro.setIdioma(idiomaDAO.ConsultarPorCodigo(rs.getInt("cod_idioma")));
                livro.setDataPublicacao(rs.getDate("datepublicacao"));
                livro.setNome(rs.getString("bnome"));
                livro.setDescricao(rs.getString("bdescricao"));
                livro.setNumeroPaginas(rs.getInt("bnumpaginas"));
                livro.setPreco(rs.getDouble("bpreco"));
                livro.setAvaliacao(rs.getInt("bavaliacao"));
                livro.setIsbn(rs.getString("bisbn"));
                livro.setCapa(rs.getByte("bcapa"));

                livroList.add(livro);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }

        return livroList;
    }

    public Livro ConsultarPorCodigo(int codigo) throws SQLException {

       Livro livro = new Livro();

        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from livro where cod_livro=?");
            preparedStatement.setInt(1, codigo);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {

                livro.setCodigo(rs.getInt("cod_livro"));
                 EditoraDao editoraDAO = new EditoraDao();
                livro.setEditora(editoraDAO.ConsultarPorCodigo(rs.getInt("cod_editora")));
                AutorDao autorDAO = new AutorDao();
                livro.setAutor(autorDAO.ConsultarPorCodigo(rs.getInt("cod_autor")));
                GeneroDao generoDAO = new GeneroDao();
                livro.setGenero(generoDAO.ConsultarPorCodigo(rs.getInt("cod_genero")));
                IdiomaDao idiomaDAO = new IdiomaDao();
                livro.setIdioma(idiomaDAO.ConsultarPorCodigo(rs.getInt("cod_idioma")));
                livro.setDataPublicacao(rs.getDate("datepublicacao"));
                livro.setNome(rs.getString("bnome"));
                livro.setDescricao(rs.getString("bdescricao"));
                livro.setNumeroPaginas(rs.getInt("bnumpaginas"));
                livro.setPreco(rs.getDouble("bpreco"));
                livro.setAvaliacao(rs.getInt("bavaliacao"));
                livro.setIsbn(rs.getString("bisbn"));
                livro.setCapa(rs.getByte("bcapa"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }

        return livro;
    }

}
