/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author fabio julio
 */
public class ConnectionFactory {

    final private static String url = "jdbc:mysql://localhost:3311/laboratorio_altino?zeroDateTimeBehavior=convertToNull";
    final private static String user = "root";
    private static final String password = "root";
    private MysqlDataSource dataSource;

    public ConnectionFactory() {
        dataSource = new MysqlDataSource();
        dataSource.setUrl(url);
        dataSource.setUser(user);
        dataSource.setPassword(password);
    }

    public Connection getConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        connection.setAutoCommit(false);
        return connection;
    }
   
}
