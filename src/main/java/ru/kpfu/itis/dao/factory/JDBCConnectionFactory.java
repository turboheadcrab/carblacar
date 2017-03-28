package ru.kpfu.itis.dao.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionFactory {
    private final String driverClassName = "org.postgresql.Driver";
    private final String connectionUrl = "jdbc:postgresql://localhost/carblacar";
    private final String dbUser = "hospital_admin";
    private final String dbPwd = "69228322";

    private static JDBCConnectionFactory connectionFactory = null;

    private JDBCConnectionFactory() {
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
        return conn;
    }

    public static JDBCConnectionFactory getInstance() {
        if (connectionFactory == null) {
            connectionFactory = new JDBCConnectionFactory();
        }
        return connectionFactory;
    }
}