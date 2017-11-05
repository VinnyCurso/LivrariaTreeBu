/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.dao;

import br.com.treebu.model.Estoque;
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
public class EstoqueDao {
    
    private Connection connection;

    public EstoqueDao() throws SQLException {
        connection = ConexaoBD.getConnection();
    }

    public void Cadastrar(Estoque estoque) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into estoque (bdescproduto,bquantidade) values (?,?)");

            preparedStatement.setString(1, estoque.getDescProduto());
            preparedStatement.setInt(2, estoque.getQuantidade());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public void Deletar(int codigo) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from estoque where cod_estoque=?");

            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public void Atualizar(Estoque estoque) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update estoque set bdescproduto=?, bquantidade=?"
                            + "where cod_estoque=?");

          preparedStatement.setString(1, estoque.getDescProduto());
            preparedStatement.setInt(2, estoque.getQuantidade());

            preparedStatement.setInt(3, estoque.getCodigo());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public List<Estoque> Listar() {
        List<Estoque> estoqueList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from estoque");
            while (rs.next()) {

                Estoque estoque = new Estoque();

                estoque.setCodigo(rs.getInt("cod_estoque"));
                estoque.setDescProduto(rs.getString("bdescproduto"));
                estoque.setQuantidade(rs.getInt("bquantidade"));

                estoqueList.add(estoque);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }

        return estoqueList;
    }

    public Estoque ConsultarPorCodigo(int codigo) {
        Estoque estoque = new Estoque();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from estoque where cod_estoque=?");
            preparedStatement.setInt(1, codigo);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                
               estoque.setCodigo(rs.getInt("cod_estoque"));
                estoque.setDescProduto(rs.getString("bdescproduto"));
                estoque.setQuantidade(rs.getInt("bquantidade"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }

        return estoque;
    }
  
}
