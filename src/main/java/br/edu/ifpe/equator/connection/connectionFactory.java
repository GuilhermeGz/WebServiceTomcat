/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.equator.connection;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Guilherme
 */
public class connectionFactory {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306:Banco";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão", ex);
        }
    }

    public static void closeConnection(Connection com) {
        if (com != null) {
            try {
                com.close();
            } catch (SQLException ex) {
                System.err.println("Erro: "+ ex);
            }
        }
    }

    public static void closeConnection(Connection com, PreparedStatement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                System.err.println("Erro: "+ ex);
            }
        }
        closeConnection(com);
    }
    public static void closeConnection(Connection com, PreparedStatement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                System.err.println("Erro: "+ ex);
            }
        }
        closeConnection(com, stmt);
    }    
    
}
