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

    public ClienteDao() throws SQLException {
        connection = ConexaoBD.getConnection();
    }

    public void Cadastrar(Cliente cliente) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into cliente (bemail,bsenha,bnome,btelefone,bcpf,datenascimento,codendereco,datecadastro) values (?,?,?,?,?,?,?,?)");

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
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into cliente (bemail,bsenha,bnome,btelefone,bcpf,datenascimento,codendereco,datecadastro) values (?,?,?,?,?,?,?,?) RETURNING cod_cliente");

            preparedStatement.setString(1, cliente.getEmail());
            preparedStatement.setString(2, cliente.getSenha());
            preparedStatement.setString(3, cliente.getNome());
            preparedStatement.setString(4, cliente.getTelefone());
            preparedStatement.setString(5, cliente.getCpf());
            preparedStatement.setDate(6, new java.sql.Date(cliente.getDataNascimento().getTime()));
            preparedStatement.setInt(7, cliente.getEndereco().getCodigo());
            preparedStatement.setDate(8, new java.sql.Date(cliente.getDataCadastro().getTime()));

             ResultSet rs = preparedStatement.executeQuery();
            
            //Cria uma condicional para retornar os dados do objeto turma
            if (rs.next()) {
                return ConsultarPorCodigo(rs.getInt("cod_cliente"));
}

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel enviar os dados" + e.getMessage());
        }
        return null;
    }

    public void Deletar(int codigo) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from cliente where cod_cliente=?");

            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel alterar os dados " + e.getMessage());
        }
    }

    public void Atualizar(Cliente cliente) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update cliente set bemail=?,bsenha=?,bnome=?,"
                            + "btelefone=?,bcpf=?,datenascimento=?,codendereco=?,datecadastro=?"
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
            ResultSet rs = statement.executeQuery("select * from cliente");
            while (rs.next()) {

                Cliente cliente = new Cliente();
                
                cliente.setCodigo(rs.getInt("cod_cliente"));
                cliente.setEmail(rs.getString("bemail"));
                cliente.setSenha(rs.getString("bsenha"));
                cliente.setNome(rs.getString("bnome"));
                cliente.setTelefone(rs.getString("btelefone"));
                cliente.setCpf(rs.getString("bcpf"));
                cliente.setDataNascimento(rs.getDate("datenascimento"));
                EnderecoDao enderecoDAO = new EnderecoDao();
                cliente.setEndereco(enderecoDAO.ConsultarPorCodigo(rs.getInt("codendereco")));
                cliente.setDataCadastro(rs.getDate("datecadastro"));

                ClienteList.add(cliente);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel listar os dados " + e.getMessage());
        }

        return ClienteList;
    }

    public Cliente ConsultarPorCodigo(int codigo) throws SQLException {
        Cliente cliente = new Cliente();
         
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from cliente where cod_cliente=?");
            preparedStatement.setInt(1, codigo);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {

                cliente.setCodigo(rs.getInt("cod_cliente"));
                cliente.setEmail(rs.getString("bemail"));
                cliente.setSenha(rs.getString("bsenha"));
                cliente.setNome(rs.getString("bnome"));
                cliente.setTelefone(rs.getString("btelefone"));
                cliente.setCpf(rs.getString("bcpf"));
                cliente.setDataNascimento(rs.getDate("datenascimento"));
                EnderecoDao enderecoDAO = new EnderecoDao();
                cliente.setEndereco(enderecoDAO.ConsultarPorCodigo(rs.getInt("codendereco")));
                cliente.setDataCadastro(rs.getDate("datecadastro"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }

        return cliente;
    }


}
