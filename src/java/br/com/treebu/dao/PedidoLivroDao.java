/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.dao;

import br.com.treebu.model.PedidoLivro;
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
public class PedidoLivroDao {

    private Connection connection;

    public PedidoLivroDao() throws SQLException {
        connection = ConexaoBD.getConnection();
    }

    public void Cadastrar(PedidoLivro pl) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into pedidolivro (numero,codlivro,bquantidadelivro,bvalorunitario) values (?,?,?,?)");

            preparedStatement.setInt(1, pl.getPedido().getNumero());
            preparedStatement.setInt(1, pl.getLivro().getCodigo());
            preparedStatement.setInt(2, pl.getQuantidadeLivro());
            preparedStatement.setDouble(3, pl.getValorUnitario());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public void Deletar(int nrpedido, int codlivro) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from pedidolivro where numero=? and codlivro=?");

            preparedStatement.setInt(1, nrpedido);
            preparedStatement.setInt(2, codlivro);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public void Atualizar(PedidoLivro pl) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update pedidolivro set quantidade=?, valorunitario=? where numero=? and codlivro=?");
            // Parameters start with 1
            preparedStatement.setInt(1, pl.getQuantidadeLivro());
            preparedStatement.setDouble(2, pl.getValorUnitario());
            preparedStatement.setInt(3, pl.getPedido().getNumero());
            preparedStatement.setInt(4, pl.getLivro().getCodigo());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
        }
    }

    public List<PedidoLivro> Listar() {
        List<PedidoLivro> pis = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from pedidolivro p, livro l where p.codlivro = l.codigo");
            while (rs.next()) {
                PedidoDao dalp = new PedidoDao();
                LivroDao dali = new LivroDao();
                PedidoLivro pi = new PedidoLivro();

                pi.setPedido(dalp.ConsultarPorCodigo(rs.getInt("numero")));
                pi.setLivro(dali.ConsultarPorCodigo(rs.getInt("codlivro")));
                pi.setQuantidadeLivro(rs.getInt("quantidade"));
                pi.setValorUnitario(rs.getDouble("valorunitario"));
                pis.add(pi);
            }
        } catch (SQLException e) {
        }

        return pis;
    }

    public List<PedidoLivro> ListarPorPedido(int numero) {
        List<PedidoLivro> plList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from pedidolivro p, livro l where p.codlivro = l.codigo and p.numero=?");
            preparedStatement.setInt(1, numero);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                PedidoDao pedidoDAO = new PedidoDao();
                LivroDao livroDAO = new LivroDao();
                PedidoLivro plDAO = new PedidoLivro();
                plDAO.setPedido(pedidoDAO.ConsultarPorCodigo(rs.getInt("numero")));
                plDAO.setLivro(livroDAO.ConsultarPorCodigo(rs.getInt("codlivro")));
                plDAO.setQuantidadeLivro(rs.getInt("quantidade"));
                plDAO.setValorUnitario(rs.getDouble("valorunitario"));
                plList.add(plDAO);
            }
        } catch (SQLException e) {
        }

        return plList;
    }

    public PedidoLivro ConsultarPorCodigo(int nrpedido, int codlivro) throws SQLException {
        PedidoLivro pl = new PedidoLivro();
        PedidoDao pedidoDAO = new PedidoDao();
        LivroDao livroDAO = new LivroDao();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from pedidolivro p, livro l where p.codlivro = l.codigo and p.numero=? and p.codlivro=?");
            preparedStatement.setInt(1, nrpedido);
            preparedStatement.setInt(2, codlivro);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                pl.setPedido(pedidoDAO.ConsultarPorCodigo(rs.getInt("numero")));
                pl.setLivro(livroDAO.ConsultarPorCodigo(rs.getInt("codlivro")));
                pl.setQuantidadeLivro(rs.getInt("quantidade"));
                pl.setValorUnitario(rs.getDouble("valorunitario"));
            }

        } catch (SQLException e) {
        }

        return pl;
    }

}
