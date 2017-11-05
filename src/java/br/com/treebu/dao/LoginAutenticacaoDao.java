/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.dao;

import br.com.treebu.model.LoginAutenticacao;
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
public class LoginAutenticacaoDao {
    
     private Connection connection;

    public LoginAutenticacaoDao() throws SQLException {
        connection = ConexaoBD.getConnection();
    }
    
    public boolean validarLogin(String email, String senha) throws Exception {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from cliente where bemail = '" + email + "' and dsenha = '" + senha + "'");
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return true; //Possui usuario
            } else {
                return false; //Nao possui usuario
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
        return false;
    }

    public void Cadastrar(LoginAutenticacao login) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into login (bemail,bsenha,dateautenticacao) values (?,?,?)");

            preparedStatement.setString(1, login.getEmail());
            preparedStatement.setString(2, login.getSenha());
            preparedStatement.setDate(3, new java.sql.Date(login.getDataAutenticacao().getTime()));

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public void Deletar(int codigo) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from login where cod_login=?");

            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public void Atualizar(LoginAutenticacao login) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update login set bemail=?,bsenha=?,dateautenticacao=?"
                            + "where cod_login=?");

            preparedStatement.setString(1, login.getEmail());
            preparedStatement.setString(2, login.getSenha());
            preparedStatement.setDate(3, new java.sql.Date(login.getDataAutenticacao().getTime()));

            preparedStatement.setInt(4, login.getCodigo());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public List<LoginAutenticacao> Listar() {
        List<LoginAutenticacao> loginList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from login");
            while (rs.next()) {

                LoginAutenticacao login = new LoginAutenticacao();

                login.setCodigo(rs.getInt("cod_login"));
                login.setEmail(rs.getString("bemail"));
                login.setSenha(rs.getString("bsenha"));
                login.setDataAutenticacao(rs.getDate("dateautenticacao"));

                loginList.add(login);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }

        return loginList;
    }

    public LoginAutenticacao ConsultarPorCodigo(int codigo) {
        LoginAutenticacao login = new LoginAutenticacao();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from login where cod_login=?");
            preparedStatement.setInt(1, codigo);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                
                login.setCodigo(rs.getInt("cod_login"));
                login.setEmail(rs.getString("bemail"));
                login.setSenha(rs.getString("bsenha"));
                login.setDataAutenticacao(rs.getDate("dateautenticacao"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }

        return login;
    }

}
