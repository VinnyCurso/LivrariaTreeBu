/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.treebu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author vinicius caetano
 */
public class ConexaoBD {

    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        if (connection != null) {
            return connection;
        } else {
            try {

                String driver = "org.postgresql.Driver";
                String url = "jdbc:postgresql://localhost:5432/treebu";
                String user = "postgres";
                String password = "root";

                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Erro Conexão" + e.getMessage());
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro Inesperado Conexão" + e.getMessage());
            }
            return connection;

        }
    }
}
