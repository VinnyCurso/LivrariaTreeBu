/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.dao;

import br.com.treebu.model.Pedido;
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
public class PedidoDao {

    private Connection connection;

    public PedidoDao() throws SQLException {
        connection = ConexaoBD.getConnection();
    }

    public Pedido Cadastrar(Pedido pedido) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into pedido(codcliente, valortotal) values (?, ?) RETURNING numero ");
            // Parameters start with 1
            preparedStatement.setInt(1, pedido.getCliente().getCodigo());
            preparedStatement.setDouble(2, pedido.getValorTotal());
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return ConsultarPorCodigo(rs.getInt("numero"));
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return null;
    }

    public void Deletar(int numero) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from pedido where numero=?");
            // Parameters start with 1
            preparedStatement.setInt(1, numero);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public void Atualizar(Pedido pedido) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update pedido set codcliente=?, valortotal=? where numero=?");
            // Parameters start with 1
            preparedStatement.setInt(1, pedido.getCliente().getCodigo());
            preparedStatement.setDouble(2, pedido.getValorTotal());
            preparedStatement.setInt(3, pedido.getNumero());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public List<Pedido> Listar() {
        List<Pedido> pedidos = new ArrayList<Pedido>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from pedido p, cliente c where p.codcliente = c.codigo");
            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setNumero(rs.getInt("numero"));
                ClienteDao clienteDAO = new ClienteDao();
                pedido.setCliente(clienteDAO.ConsultarPorCodigo(rs.getInt("codigo")));
                pedido.setValorTotal(rs.getDouble("valortotal"));
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            e.getMessage();
        }

        return pedidos;
    }

    public Pedido ConsultarPorCodigo(int numero) {
        Pedido pedido = new Pedido();

        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from pedido p, cliente c where p.codcliente = c.codigo and numero=?");
            preparedStatement.setInt(1, numero);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                pedido.setNumero(rs.getInt("numero"));
                ClienteDao clienteDAO = new ClienteDao();
                pedido.setCliente(clienteDAO.ConsultarPorCodigo(rs.getInt("codigo")));
                pedido.setValorTotal(rs.getDouble("valortotal"));
            }

        } catch (SQLException e) {
            e.getMessage();
        }

        return pedido;
    }

}
