/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

/**
 *
 * @author Admin
 */
public class DBConnector {

 

    protected Connection connection;
    private static final String HOSTNAME = "localhost";
    private static final String PORT = "1433";
    private static final String DBNAME = "QLBanGiayy6";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "12345678";

    public static Connection getConnection() {

        // Create a variable for the connection string.
        String connectionUrl = "jdbc:sqlserver://" + HOSTNAME + ":" + PORT + ";"
                + "databaseName=" + DBNAME + ";encrypt=true;trustServerCertificate=true";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(connectionUrl, USERNAME, PASSWORD);
        } // Handle any errors that may have occurred.
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public static void main(String[] args) {
        System.out.println(getConnection());
    }
        public static PreparedStatement preparedStatement(String sql, Object... args) throws SQLException {
        Connection con = DriverManager.getConnection(DBNAME,USERNAME, PASSWORD);
        PreparedStatement ps = null;
        if (sql.trim().startsWith("{")) {
            ps = con.prepareCall(sql);
        } else {
            ps = con.prepareStatement(sql);
        }
        for (int i = 0; i < args.length; i++) {
            ps.setObject(i + 1, args[i]);
        }
        return ps;
    }
        
        public static void executeUpdate(String sql, Object...args) {
                try {
                        PreparedStatement ps = preparedStatement(sql, args);
                        try {
                                ps.executeUpdate();
                        } finally {
                                ps.getConnection().close();
                        }
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
        }
        
        public static ResultSet executeQuery(String sql, Object...args) {
                try {
                        PreparedStatement ps = preparedStatement(sql, args);
                        return ps.executeQuery();
                } catch (SQLException e) {
                        throw new RuntimeException();
                }
        }

}
