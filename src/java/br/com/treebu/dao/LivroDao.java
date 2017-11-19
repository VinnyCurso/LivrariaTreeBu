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
                    .prepareStatement("INSERT INTO livro "
                            + "(nome_livro,"
                            + "desc_livro,"
                            + "paginas_livro,"
                            + "ano_livro,"
                            + "preco_unitario,"
                            + "quantidade_livro,"
                            + "avaliacao_livro,"
                            + "isbn_livro,"
                            + "capa_livro,"
                            + "cod_editora,"
                            + "cod_autor,"
                            + "cod_genero,"
                            + "cod_idioma)"
                            + " values (?,?,?,?,?,?,?,?,?,?,?,?,?)");

            preparedStatement.setString(1, livro.getNome());
            preparedStatement.setString(2, livro.getDescricao());
            preparedStatement.setInt(3, livro.getNumeroPaginas());
            preparedStatement.setInt(4, livro.getAno());
            preparedStatement.setDouble(5, livro.getPreco());
            preparedStatement.setInt(6, livro.getQtd_livro());
            preparedStatement.setInt(7, livro.getAvaliacao());
            preparedStatement.setString(8, livro.getIsbn());
            preparedStatement.setByte(9, livro.getCapa());
            preparedStatement.setInt(10, livro.getEditora().getCodigo());
            preparedStatement.setInt(11, livro.getAutor().getCodigo());
            preparedStatement.setInt(12, livro.getGenero().getCodigo());
            preparedStatement.setInt(13, livro.getIdioma().getCodigo());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public void Deletar(int codigo) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM livro WHERE cod_livro = ?");

            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public void Atualizar(Livro livro) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE livro SET "
                            + "nome_livro = ?,"
                            + "desc_livro = ?,"
                            + "paginas_livro = ?,"
                            + "ano_livro = ?,"
                            + "preco_unitario = ?,"
                            + "quantidade_livro = ?,"
                            + "avaliacao_livro = ?,"
                            + "isbn_livro = ?,"
                            + "capa_livro = ?,"
                            + "cod_editora = ?,"
                            + "cod_autor = ?,"
                            + "cod_genero = ?,"
                            + "cod_idioma = ? "
                            + "WHERE cod_livro = ?");

            preparedStatement.setString(1, livro.getNome());
            preparedStatement.setString(2, livro.getDescricao());
            preparedStatement.setInt(3, livro.getNumeroPaginas());
            preparedStatement.setInt(4, livro.getAno());
            preparedStatement.setDouble(5, livro.getPreco());
            preparedStatement.setInt(6, livro.getQtd_livro());
            preparedStatement.setInt(7, livro.getAvaliacao());
            preparedStatement.setString(8, livro.getIsbn());
            preparedStatement.setByte(9, livro.getCapa());
            preparedStatement.setInt(10, livro.getEditora().getCodigo());
            preparedStatement.setInt(11, livro.getAutor().getCodigo());
            preparedStatement.setInt(12, livro.getGenero().getCodigo());
            preparedStatement.setInt(13, livro.getIdioma().getCodigo());

            preparedStatement.setInt(14, livro.getCodigo());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public List<Livro> Listar() {
        List<Livro> livroList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM livro");
            while (rs.next()) {
                Livro livro = new Livro();
                AutorDao autorDAO = new AutorDao();
                EditoraDao editoraDAO = new EditoraDao();
                GeneroDao generoDAO = new GeneroDao();
                IdiomaDao idiomaDAO = new IdiomaDao();

                livro.setCodigo(rs.getInt("cod_livro"));
                livro.setNome(rs.getString("nome_livro"));
                livro.setDescricao(rs.getString("desc_livro"));
                livro.setNumeroPaginas(rs.getInt("paginas_livro"));
                livro.setAno(rs.getInt("ano_livro"));
                livro.setPreco(rs.getDouble("preco_unitario"));
                livro.setQtd_livro(rs.getInt("quantidade_livro"));
                livro.setAvaliacao(rs.getInt("avaliacao_livro"));
                livro.setIsbn(rs.getString("isbn_livro"));
                livro.setCapa(rs.getByte("capa_livro"));
                livro.setEditora(editoraDAO.ConsultarPorCodigo(rs.getInt("cod_editora")));
                livro.setAutor(autorDAO.ConsultarPorCodigo(rs.getInt("cod_autor")));
                livro.setGenero(generoDAO.ConsultarPorCodigo(rs.getInt("cod_genero")));
                livro.setIdioma(idiomaDAO.ConsultarPorCodigo(rs.getInt("cod_idioma")));

                livroList.add(livro);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }

        return livroList;
    }

    public Livro ConsultarPorCodigo(int codigo) throws SQLException {
        Livro livro = new Livro();
        AutorDao autorDAO = new AutorDao();
        EditoraDao editoraDAO = new EditoraDao();
        GeneroDao generoDAO = new GeneroDao();
        IdiomaDao idiomaDAO = new IdiomaDao();

        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("SELECT * FROM livro WHERE cod_livro=?");
            preparedStatement.setInt(1, codigo);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                livro.setCodigo(rs.getInt("cod_livro"));
                livro.setNome(rs.getString("nome_livro"));
                livro.setDescricao(rs.getString("desc_livro"));
                livro.setNumeroPaginas(rs.getInt("paginas_livro"));
                livro.setAno(rs.getInt("ano_livro"));
                livro.setPreco(rs.getDouble("preco_unitario"));
                livro.setQtd_livro(rs.getInt("quantidade_livro"));
                livro.setAvaliacao(rs.getInt("avaliacao_livro"));
                livro.setIsbn(rs.getString("isbn_livro"));
                livro.setCapa(rs.getByte("capa_livro"));
                livro.setEditora(editoraDAO.ConsultarPorCodigo(rs.getInt("cod_editora")));
                livro.setAutor(autorDAO.ConsultarPorCodigo(rs.getInt("cod_autor")));
                livro.setGenero(generoDAO.ConsultarPorCodigo(rs.getInt("cod_genero")));
                livro.setIdioma(idiomaDAO.ConsultarPorCodigo(rs.getInt("cod_idioma")));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }

        return livro;
    }

}
