/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.dao;

import br.com.treebu.model.Editora;
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
public class EditoraDao {

    private Connection connection;

    public EditoraDao() throws SQLException {
        connection = ConexaoBD.getConnection();
    }

    public void Cadastrar(Editora editora) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into editora (brazaosocial, bcnpj, codendereco, btelefone, bemail, brepresentante ) values (?,?,?,?,?,?)");

            preparedStatement.setString(1, editora.getRazaoSocial());
            preparedStatement.setString(2, editora.getCnpj());
            preparedStatement.setInt(3, editora.getEndereco().getCodigo());
            preparedStatement.setString(4, editora.getTelefone());
            preparedStatement.setString(5, editora.getEmail());
            preparedStatement.setString(6, editora.getRepresentante());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public void Deletar(int codigo) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from editora where cod_editora=?");

            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public void Atualizar(Editora editora) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update editora set brazaosocial=?,bcnpj=?,codendereco=?,btelefone=?,bemail=?,brepresentante=?,"
                            + "where editora=?");

            preparedStatement.setString(1, editora.getRazaoSocial());
            preparedStatement.setString(2, editora.getCnpj());
            preparedStatement.setInt(3, editora.getEndereco().getCodigo());
            preparedStatement.setString(4, editora.getTelefone());
            preparedStatement.setString(5, editora.getEmail());
            preparedStatement.setString(6, editora.getRepresentante());

            preparedStatement.setInt(7, editora.getCodigo());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public List<Editora> Listar() {
        List<Editora> editoraList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from editora");
            while (rs.next()) {

                Editora editora = new Editora();

                editora.setCodigo(rs.getInt("cod_editora"));
                editora.setRazaoSocial(rs.getString("brazaosocial"));
                editora.setCnpj(rs.getString("bcnpj"));
                EnderecoDao enderecoDAO = new EnderecoDao();
                editora.setEndereco(enderecoDAO.ConsultarPorCodigo(rs.getInt("cod_endereco")));
                editora.setTelefone(rs.getString("btelefone"));
                editora.setEmail(rs.getString("bemail"));
                editora.setRepresentante(rs.getString("brepresentante"));

                editoraList.add(editora);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }

        return editoraList;
    }

    public Editora ConsultarPorCodigo(int codigo) throws SQLException {
        Editora editora = new Editora();
         
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from editora where cod_editora=?");
            preparedStatement.setInt(1, codigo);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {

                editora.setCodigo(rs.getInt("cod_editora"));
                editora.setRazaoSocial(rs.getString("brazaosocial"));
                editora.setCnpj(rs.getString("bcnpj"));
                EnderecoDao enderecoDAO = new EnderecoDao();
                editora.setEndereco(enderecoDAO.ConsultarPorCodigo(rs.getInt("cod_endereco")));
                editora.setTelefone(rs.getString("btelefone"));
                editora.setEmail(rs.getString("bemail"));
                editora.setRepresentante(rs.getString("brepresentante"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }

        return editora;
    }
}
