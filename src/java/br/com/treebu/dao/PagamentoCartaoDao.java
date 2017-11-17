/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.dao;

import br.com.treebu.model.PagamentoCartao;
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
public class PagamentoCartaoDao {
    
     private Connection connection;

    public PagamentoCartaoDao() throws SQLException {
        connection = ConexaoBD.getConnection();
    }

    public void Cadastrar(PagamentoCartao pagtCartao) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into pagamentocartao (bnometitular,bnumerocartao,datevalidade,codseguranca,bqtdparcelas) values (?,?,?,?,?)");
            
            //Itens criado recetemente devida a documentação
            preparedStatement.setString(1, pagtCartao.getNomeTitular()); // Doc = 250 caracteres
            preparedStatement.setLong(2, pagtCartao.getNumerosCartao()); // Doc = 16 caracteres
            preparedStatement.setDate(3, new java.sql.Date(pagtCartao.getDataValidade().getTime()));
            preparedStatement.setInt(4, pagtCartao.getCodSeguranca()); // Doc = 3 caracteres
             preparedStatement.setInt(5, pagtCartao.getQtdParcelas()); // Doc = função select

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public void Deletar(int id) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from pagamentocartao where id_pgtcartao=?");

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public void Atualizar(PagamentoCartao pagtCartao) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update pagamentocartao set bnometitular=?, bnumerocartao=?, datevalidade=? , codseguranca=?, bqtdparcelas=? " 
                            + "where id_pgtcartao=?");

            preparedStatement.setString(1, pagtCartao.getNomeTitular()); 
            preparedStatement.setLong(2, pagtCartao.getNumerosCartao()); 
            preparedStatement.setDate(3, new java.sql.Date(pagtCartao.getDataValidade().getTime()));
            preparedStatement.setInt(4, pagtCartao.getCodSeguranca()); 
             preparedStatement.setInt(5, pagtCartao.getQtdParcelas()); 

            preparedStatement.setInt(6, pagtCartao.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public List<PagamentoCartao> Listar() {
        List<PagamentoCartao> pgtCartaoList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from pagamentocartao");
            while (rs.next()) {

                PagamentoCartao pgtcartao = new PagamentoCartao();

                pgtcartao.setId(rs.getInt("id_pgtcartao"));
                pgtcartao.setNomeTitular(rs.getString("bnometitular"));
                pgtcartao.setNumerosCartao(rs.getLong("bnumerocartao"));
                pgtcartao.setDataValidade(rs.getDate("datevalidade"));
                pgtcartao.setCodSeguranca(rs.getInt("codseguranca"));
                pgtcartao.setQtdParcelas(rs.getInt("bqtdparcelas"));

                pgtCartaoList.add(pgtcartao);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }

        return pgtCartaoList;
    }

    public PagamentoCartao ConsultarPorCodigo(int codigo) {
        PagamentoCartao pgtcartao = new PagamentoCartao();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from pagamentocartao where id_pgtcartao=?");
            preparedStatement.setInt(1, codigo);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                
               pgtcartao.setId(rs.getInt("id_pgtcartao"));
                pgtcartao.setNomeTitular(rs.getString("bnometitular"));
                pgtcartao.setNumerosCartao(rs.getLong("bnumerocartao"));
                pgtcartao.setDataValidade(rs.getDate("datevalidade"));
                pgtcartao.setCodSeguranca(rs.getInt("codseguranca"));
                pgtcartao.setQtdParcelas(rs.getInt("bqtdparcelas"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }

        return pgtcartao;
    }
   
}
