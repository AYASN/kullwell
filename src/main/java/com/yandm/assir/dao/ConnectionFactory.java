package com.yandm.assir.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String DRIVER_CLASS = "org.sqlite.JDBC";
    String urlToDbFile = this.getClass().getClassLoader().getResource("kullWell.db").toString();
    public static String DB_URL = null;
    private static ConnectionFactory instance = new ConnectionFactory();

    public ConnectionFactory() {
        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection createConnection() {
        Connection connection = null;
        DB_URL = "jdbc:sqlite:" + urlToDbFile;

        try {
            connection = DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            System.err.println("ERROR: Unable to connect to Database.");
        }
        return connection;
    }

    public static Connection getConnection() {
        return instance.createConnection();
    }

    public static Connection getConnection(String dbUrl) {
        return instance.createConnection(dbUrl);

    }

    private Connection createConnection(String dbUrl) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbUrl);
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("ERROR: Unable to connect to Database.");
        }
        return connection;
    }
}

