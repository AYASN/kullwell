package com.yandm.assir.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static JDBCConnection instance = new JDBCConnection();
    public static String DB_URL = null;


    public JDBCConnection() {

        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection createConnection() {

        DB_URL = "jdbc:mysql://localhost:3306/";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, "root", "");
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

