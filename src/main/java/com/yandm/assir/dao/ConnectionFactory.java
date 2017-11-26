package com.yandm.assir.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

   private static final String JDBC_DRIVER = "jdbc.driver";
   private static final String JDBC_URL = "jdbc.url";
   private InputStream propFile = this.getClass().getClassLoader().getResourceAsStream("db.properties");
   private Properties properties = new Properties();
   private static ConnectionFactory instance = new ConnectionFactory();

   private ConnectionFactory() {
      try {
         properties.load(propFile);
         Class.forName(properties.getProperty(JDBC_DRIVER));
      } catch (ClassNotFoundException | IOException e) {
         e.printStackTrace();
      }
   }

   private Connection createConnection() {
      loadProperties();
      Connection connection = null;
      try {
         connection = DriverManager.getConnection(properties.getProperty(JDBC_URL));
      } catch (SQLException e) {
//         System.err.println("ERROR: Unable to connect to Database.");
         e.printStackTrace();
      }
      return connection;
   }

   private void loadProperties() {
      if (properties.isEmpty()) {
         try {
            properties.load(propFile);
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
   }

   public static Connection getConnection() {
      return instance.createConnection();
   }
}

