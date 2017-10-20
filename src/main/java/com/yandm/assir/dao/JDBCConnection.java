package com.yandm.assir.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

    private static final java.lang.String DRIVER_CLASS = "org.sqlite.JDBC";
    String urlToDbFile = this.getClass().getClassLoader().getResource("kullWell.db").toString();
    public static String DB_URL = null;
    private static JDBCConnection instance = new JDBCConnection();

    public JDBCConnection() {
        DB_URL = "jdbc:sqlite" + urlToDbFile;

        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection createConnection() {

//        DB_URL = "jdbc:mysql://localhost:3306/";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            System.err.println("ERROR: Unable to connect to Database.");
        }
        System.out.println("Connected to DB!");
        return connection;
    }

    public static Connection getConnection() {
        return instance.createConnection();
    }
}

