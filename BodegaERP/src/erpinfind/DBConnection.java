/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erpinfind;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author franco-lxle
 */
public class DBConnection {

    private static String host = "jdbc:mysql://localhost:3306/InfInd";
    private static String user = "root";
    private static String pass = "";
    private static Connection conn;

    public static Connection getConnection() {
        if (conn == null){
            openConnection();
        }
        return conn;
    }

    public static boolean openConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(host, user, pass);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }
    
    public static void closeConnection() {

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public static boolean execSQL(String sql) {
        try {
            getConnection();
            Statement stat = conn.createStatement();
            stat.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }

    public static ResultSet execSelectSQL(String sql) {
        ResultSet result;
        try {
            getConnection();
            Statement stat = conn.createStatement();
            result = stat.executeQuery(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

        return result;
    }
}
