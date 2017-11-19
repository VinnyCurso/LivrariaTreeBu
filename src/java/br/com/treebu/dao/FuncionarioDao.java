/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.dao;

import br.com.treebu.model.Funcionario;
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
public class FuncionarioDao {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultset;

    public FuncionarioDao() throws SQLException {
        connection = ConexaoBD.getConnection();
    }

    public void Cadastrar(Funcionario funcionario) {

        try {
            preparedStatement = connection
                    .prepareStatement("insert into funcionario (email_fun, senha_fun, nome_fun,"
                            + " telefone_fun, cpf_fun, datenascimento ,codigo_endereco ,dateadmissao,"
                            + " ctps_fun) values (?,?,?,?,?,?,?,?,?)");

            preparedStatement.setString(1, funcionario.getEmail());
            preparedStatement.setString(2, funcionario.getSenha());
            preparedStatement.setString(3, funcionario.getNome());
            preparedStatement.setString(4, funcionario.getTelefone());
            preparedStatement.setString(5, funcionario.getCpf());
            preparedStatement.setDate(6, new java.sql.Date(funcionario.getDataNascimento().getTime()));
            preparedStatement.setInt(7, funcionario.getEndereco().getCodigo());
            preparedStatement.setDate(8, new java.sql.Date(funcionario.getDataAdmissao().getTime()));
            preparedStatement.setString(9, funcionario.getCtps());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public void Deletar(int codigo) {
        try {
            preparedStatement = connection
                    .prepareStatement("delete from funcionario where cod_funcionario=?");

            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public void Atualizar(Funcionario funcionario) {

        try {
            preparedStatement = connection
                    .prepareStatement("update funcionario set email_fun=?, senha_fun=?, nome_fun=?,"
                            + "telefone_fun=?, cpf_fun=?, datenascimento=?, codigo_endereco=?, dateadmissao=?, ctps_fun=?"
                            + "where cod_funcionario=?");

            preparedStatement.setString(1, funcionario.getEmail());
            preparedStatement.setString(2, funcionario.getSenha());
            preparedStatement.setString(3, funcionario.getNome());
            preparedStatement.setString(4, funcionario.getTelefone());
            preparedStatement.setString(5, funcionario.getCpf());
            preparedStatement.setDate(6, new java.sql.Date(funcionario.getDataNascimento().getTime()));
            preparedStatement.setInt(7, funcionario.getEndereco().getCodigo());
            preparedStatement.setDate(8, new java.sql.Date(funcionario.getDataAdmissao().getTime()));
            preparedStatement.setString(9, funcionario.getCtps());

            preparedStatement.setInt(10, funcionario.getCodigo());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public List<Funcionario> Listar() {
        List<Funcionario> FuncijonarioList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            resultset = statement.executeQuery("select * from funcionario f, endereco e where f.codigo_endereco = e.cod_endereco");
            while (resultset.next()) {

                Funcionario funcionario = new Funcionario();

                funcionario.setCodigo(resultset.getInt("cod_funcionario"));
                funcionario.setEmail(resultset.getString("email_fun"));
                funcionario.setSenha(resultset.getString("senha_fun"));
                funcionario.setNome(resultset.getString("nome_fun"));
                funcionario.setTelefone(resultset.getString("telefone_fun"));
                funcionario.setCpf(resultset.getString("cpf_fun"));
                funcionario.setDataNascimento(resultset.getDate("datenascimento"));
                EnderecoDao enderecoDAO = new EnderecoDao();
                funcionario.setEndereco(enderecoDAO.ConsultarPorCodigo(resultset.getInt("cod_endereco")));
                funcionario.setDataAdmissao(resultset.getDate("dateadmissao"));
                funcionario.setCtps(resultset.getString("ctps_fun"));

                FuncijonarioList.add(funcionario);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }

        return FuncijonarioList;
    }

    public Funcionario ConsultarPorCodigo(int codigo) {
        Funcionario funcionario = new Funcionario();

        try {
            preparedStatement = connection.
                    prepareStatement("select * from funcionario where cod_funcionario=?");
            preparedStatement.setInt(1, codigo);
            resultset = preparedStatement.executeQuery();

            if (resultset.next()) {

                funcionario.setCodigo(resultset.getInt("cod_funcionario"));
                funcionario.setEmail(resultset.getString("email_fun"));
                funcionario.setSenha(resultset.getString("senha_fun"));
                funcionario.setNome(resultset.getString("nome_fun"));
                funcionario.setTelefone(resultset.getString("telefone_fun"));
                funcionario.setCpf(resultset.getString("cpf_fun"));
                funcionario.setDataNascimento(resultset.getDate("datenascimento"));
                EnderecoDao enderecoDAO = new EnderecoDao();
                funcionario.setEndereco(enderecoDAO.ConsultarPorCodigo(resultset.getInt("cod_endereco")));
                funcionario.setDataAdmissao(resultset.getDate("dateadmissao"));
                funcionario.setCtps(resultset.getString("ctps_fun"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }

        return funcionario;
    }

}
