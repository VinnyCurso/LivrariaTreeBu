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
                    .prepareStatement("insert into pedido (codcliente, bvalortotal) values (?, ?)  RETURNING cod_pedido");

            preparedStatement.setInt(1, pedido.getCliente().getCodigo());
            preparedStatement.setDouble(2, pedido.getValorTotal());

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return ConsultarPorCodigo(rs.getInt("cod_pedido"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
        return null;
    }

    public void Deletar(int codigo) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from pedido where cod_pedido=?");

            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public void Atualizar(Pedido pedido) {

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update pedido set codcliente=?, bvalortotal=?"
                            + "where cod_pedido=?");

            preparedStatement.setInt(1, pedido.getCliente().getCodigo());
            preparedStatement.setDouble(2, pedido.getValorTotal());

            preparedStatement.setInt(3, pedido.getCodigo());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public List<Pedido> Listar() {
        List<Pedido> pedidoList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from pedido p, cliente c where p.codcliente = c.cod_cliente");
            while (rs.next()) {

                Pedido pedido = new Pedido();
                ClienteDao clienteDAO = new ClienteDao();

                pedido.setCodigo(rs.getInt("cod_pedido"));
                pedido.setCliente(clienteDAO.ConsultarPorCodigo(rs.getInt("cod_cliente")));
                pedido.setValorTotal(rs.getDouble("bvalortotal"));

                pedidoList.add(pedido);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
        return pedidoList;
    }

    public Pedido ConsultarPorCodigo(int codigo) throws SQLException {
        Pedido pedido = new Pedido();
        ClienteDao clienteDAO = new ClienteDao();

        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from pedido p, cliente c where p.codcliente = c.cod_cliente and cod_pedido=?");
            preparedStatement.setInt(1, codigo);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {

                pedido.setCodigo(rs.getInt("cod_pedido"));
                pedido.setCliente(clienteDAO.ConsultarPorCodigo(rs.getInt("cod_cliente")));
                pedido.setValorTotal(rs.getDouble("bvalortotal"));

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }

        return pedido;
    }

}
