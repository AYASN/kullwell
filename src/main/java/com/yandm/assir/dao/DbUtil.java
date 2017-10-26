package com.yandm.assir.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtil {

   public static void close(Connection connection) {
      if (connection != null) {
         try {
            connection.close();
         } catch (SQLException e) {
//            e.printStackTrace();
            // Log some stuff
         }
      }
   }

   public static void close(Statement statement) {
      if (statement != null) {
         try {
            statement.close();
         } catch (SQLException e) {
//            e.printStackTrace();
            // Logger
         }
      }
   }

   public static void close(ResultSet resultSet) {
      if (resultSet != null) {
         try {
            resultSet.close();
         } catch (SQLException e) {
//            e.printStackTrace();
         }
      }
   }
}