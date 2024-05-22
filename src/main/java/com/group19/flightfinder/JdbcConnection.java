package com.group19.flightfinder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
    private Connection connection;
    private static JdbcConnection instance = new JdbcConnection();

    private JdbcConnection() {}

    public static JdbcConnection getInstance() {
        return instance;
    }

    public void connect(String host, int port, String database, String user, String password) throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, user, password);
    }

    public boolean isConnected() {
        return connection != null;
    }

    public Connection getConnection() {
        return connection;
    }
}
