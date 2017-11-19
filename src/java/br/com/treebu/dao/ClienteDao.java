/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.dao;

import br.com.treebu.model.Cliente;
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
public class ClienteDao {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultset;

    public ClienteDao() throws SQLException {
        connection = ConexaoBD.getConnection();
    }

    public void Cadastrar(Cliente cliente) {

        try {
            preparedStatement = connection
                    .prepareStatement("insert into cliente (email_cli, senha_cli, nome_cli, telefone_cli, cpf_cli, datenascimento, codigo_endereco, datecadastro) values (?,?,?,?,?,?,?,?)");

            preparedStatement.setString(1, cliente.getEmail());
            preparedStatement.setString(2, cliente.getSenha());
            preparedStatement.setString(3, cliente.getNome());
            preparedStatement.setString(4, cliente.getTelefone());
            preparedStatement.setString(5, cliente.getCpf());
            preparedStatement.setDate(6, new java.sql.Date(cliente.getDataNascimento().getTime()));
            preparedStatement.setInt(7, cliente.getEndereco().getCodigo());
            preparedStatement.setDate(8, new java.sql.Date(cliente.getDataCadastro().getTime()));

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel enviar os dados" + e.getMessage());
        }
    }

    public Cliente CadastrarCliente(Cliente cliente) {

        try {
            preparedStatement = connection
            .prepareStatement("insert into cliente (email_cli, senha_cli, nome_cli, telefone_cli, cpf_cli, datenascimento, codigo_endereco, datecadastro) values (?,?,?,?,?,?,?,?) RETURNING cod_cliente");

            preparedStatement.setString(1, cliente.getEmail());
            preparedStatement.setString(2, cliente.getSenha());
            preparedStatement.setString(3, cliente.getNome());
            preparedStatement.setString(4, cliente.getTelefone());
            preparedStatement.setString(5, cliente.getCpf());
            preparedStatement.setDate(6, new java.sql.Date(cliente.getDataNascimento().getTime()));
            preparedStatement.setInt(7, cliente.getEndereco().getCodigo());
            preparedStatement.setDate(8, new java.sql.Date(cliente.getDataCadastro().getTime()));

            resultset = preparedStatement.executeQuery();

            //Cria uma condicional para retornar os dados do objeto turma
            if (resultset.next()) {
                return ConsultarPorCodigo(resultset.getInt("cod_cliente"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel enviar os dados" + e.getMessage());
        }
        return null;
    }

    public void Deletar(int codigo) {
        try {
            preparedStatement = connection
                    .prepareStatement("delete from cliente where cod_cliente=?");

            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel alterar os dados " + e.getMessage());
        }
    }

    public void Atualizar(Cliente cliente) {

        try {
            preparedStatement = connection
                    .prepareStatement("update cliente set email_cli=?, senha_cli=?, nome_cli=?,"
                            + "telefone_cli=?, cpf_cli=?, datenascimento=?, codigo_endereco=?, datecadastro=?"
                            + "where cod_cliente=?");

            preparedStatement.setString(1, cliente.getEmail());
            preparedStatement.setString(2, cliente.getSenha());
            preparedStatement.setString(3, cliente.getNome());
            preparedStatement.setString(4, cliente.getTelefone());
            preparedStatement.setString(5, cliente.getCpf());
            preparedStatement.setDate(6, new java.sql.Date(cliente.getDataNascimento().getTime()));
            preparedStatement.setInt(7, cliente.getEndereco().getCodigo());
            preparedStatement.setDate(8, new java.sql.Date(cliente.getDataCadastro().getTime()));

            preparedStatement.setInt(9, cliente.getCodigo());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel deletar os dados " + e.getMessage());
        }
    }

    public List<Cliente> Listar() {
        List<Cliente> ClienteList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            resultset = statement.executeQuery("select * from cliente c, endereco e where c.codigo_endereco = e.cod_endereco");
            while (resultset.next()) {

                Cliente cliente = new Cliente();

                cliente.setCodigo(resultset.getInt("cod_cliente"));
                cliente.setEmail(resultset.getString("email_cli"));
                cliente.setSenha(resultset.getString("senha_cli"));
                cliente.setNome(resultset.getString("nome_cli"));
                cliente.setTelefone(resultset.getString("telefone_cli"));
                cliente.setCpf(resultset.getString("cpf_cli"));
                cliente.setDataNascimento(resultset.getDate("datenascimento"));
                EnderecoDao enderecoDAO = new EnderecoDao();
                cliente.setEndereco(enderecoDAO.ConsultarPorCodigo(resultset.getInt("cod_endereco")));
                cliente.setDataCadastro(resultset.getDate("datecadastro"));

                ClienteList.add(cliente);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel listar os dados " + e.getMessage());
        }

        return ClienteList;
    }

    public Cliente ConsultarPorCodigo(int codigo) {
        Cliente cliente = new Cliente();

        try {
            preparedStatement = connection.
            prepareStatement("select * from cliente where cod_cliente=?");
            preparedStatement.setInt(1, codigo);
            resultset = preparedStatement.executeQuery();

            if (resultset.next()) {

                cliente.setCodigo(resultset.getInt("cod_cliente"));
                cliente.setEmail(resultset.getString("email_cli"));
                cliente.setSenha(resultset.getString("senha_cli"));
                cliente.setNome(resultset.getString("nome_cli"));
                cliente.setTelefone(resultset.getString("telefone_cli"));
                cliente.setCpf(resultset.getString("cpf_cli"));
                cliente.setDataNascimento(resultset.getDate("datenascimento"));
                EnderecoDao enderecoDAO = new EnderecoDao();
                cliente.setEndereco(enderecoDAO.ConsultarPorCodigo(resultset.getInt("cod_endereco")));
                cliente.setDataCadastro(resultset.getDate("datecadastro"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }

        return cliente;
    }

    public boolean validarAutenticacao(Cliente cliente) {

        try {
            preparedStatement = connection.prepareStatement("select * from cliente where email_cli=? and senha_cli=?");

            preparedStatement.setString(1, cliente.getEmail());
            preparedStatement.setString(2, cliente.getSenha());

            resultset = preparedStatement.executeQuery();

            if (resultset.next()) {
                return true;
            }

        } catch (SQLException ex) {
            System.out.println("Erro" + ex.getMessage());
        }

        return false;
    }

}
