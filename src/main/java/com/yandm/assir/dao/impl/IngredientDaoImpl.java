package com.yandm.assir.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import com.yandm.assir.dao.ConnectionFactory;
import com.yandm.assir.dao.DbUtil;
import com.yandm.assir.dao.IngredientsDao;
import com.yandm.assir.model.Ingredient;

public class IngredientDaoImpl implements IngredientsDao {
   private Ingredient ingredient;
   private Statement statement;
   private Connection connection;

   // TODO Call the DB connection, and  add operations

   @Override
   public void addIngredient(Ingredient ingredient) {
      String query = "INSERT INTO ingredients (name,calories,season) VALUES " +
            "(\""+ ingredient.getName() +"\"," +
            ingredient.getCalories()+ "," +
            " \"" + ingredient.getSeason() + "\");";
      connection = ConnectionFactory.getConnection();
      try {
         statement = connection.createStatement();
         statement.executeUpdate(query);
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         DbUtil.close(statement);
         DbUtil.close(connection);
      }
      this.ingredient = ingredient;
   }

   @Override
   public void editIngredient(Ingredient ingredient) {

   }

   @Override
   public void removeIngredient(int ingredientId) {

   }

   @Override
   public Ingredient getIngredientById(int ingredientId) {
      // TODO should returned from the database
      return ingredient;
   }
}
