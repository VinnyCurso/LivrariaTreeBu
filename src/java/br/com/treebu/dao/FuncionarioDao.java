/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.dao;

import br.com.treebu.model.Endereco;
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
    
     public FuncionarioDao() throws SQLException {
       connection = ConexaoBD.getConnection();
    }

    public void Cadastrar(Funcionario funcionario) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into funcionario (bemail,bsenha,bnome,btelefone,bcpf,datenascimento,codendereco,dateadmisao,dctps) values (?,?,?,?,?,?,?,?,?)");

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
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from funcionario where cod_funcionario=?");

            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public void Atualizar(Funcionario funcionario) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update cliente set bemail=?,bsenha=?,bnome=?,"
                            + "btelefone=?,bcpf=?,datenascimento=?,codendereco=?,dateadmisao=?,dctps=?"
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
            ResultSet rs = statement.executeQuery("select * from funcionario");
            while (rs.next()) {

                Funcionario funcionario = new Funcionario();
                EnderecoDao enderecoDAO = new EnderecoDao();

                funcionario.setCodigo(rs.getInt("cod_funcionario"));
                funcionario.setEmail(rs.getString("bemail"));
                funcionario.setSenha(rs.getString("bsenha"));
                funcionario.setNome(rs.getString("bnome"));
                funcionario.setTelefone(rs.getString("btelefone"));
                funcionario.setCpf(rs.getString("bcpf"));
                funcionario.setDataNascimento(rs.getDate("datenascimento"));
                funcionario.setEndereco(enderecoDAO.ConsultarPorCodigo(rs.getInt("cod_endereco")));
                funcionario.setDataAdmissao(rs.getDate("dateadmisao"));
                funcionario.setCtps(rs.getString("dctps"));

                FuncijonarioList.add(funcionario);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }

        return FuncijonarioList;
    }

    public Funcionario ConsultarPorCodigo(int codigo) throws SQLException {
        Funcionario funcionario = new Funcionario();
        EnderecoDao enderecoDAO = new EnderecoDao();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from funcionario where cod_funcionario=?");
            preparedStatement.setInt(1, codigo);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {

                funcionario.setCodigo(rs.getInt("cod_funcionario"));
                funcionario.setEmail(rs.getString("bemail"));
                funcionario.setSenha(rs.getString("bsenha"));
                funcionario.setNome(rs.getString("bnome"));
                funcionario.setTelefone(rs.getString("btelefone"));
                funcionario.setCpf(rs.getString("bcpf"));
                funcionario.setDataNascimento(rs.getDate("datenascimento"));
                funcionario.setEndereco(enderecoDAO.ConsultarPorCodigo(rs.getInt("cod_endereco")));
                funcionario.setDataAdmissao(rs.getDate("dateadmisao"));
                funcionario.setCtps(rs.getString("dctps"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }

        return funcionario;
    }
    
}
