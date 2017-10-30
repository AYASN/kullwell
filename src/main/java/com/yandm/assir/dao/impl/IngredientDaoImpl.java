package com.yandm.assir.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.yandm.assir.dao.ConnectionFactory;
import com.yandm.assir.dao.DbUtil;
import com.yandm.assir.dao.IngredientDao;
import com.yandm.assir.model.Ingredient;
import com.yandm.assir.model.Recipe;

public class IngredientDaoImpl implements IngredientDao {
   private Statement statement;
   private Connection connection;

   @Override
   public void addIngredient(Ingredient ingredient) {
      String query = "INSERT INTO ingredients (name,calories,season) VALUES " +
            "(\"" + ingredient.getName() + "\"," +
            ingredient.getCalories() + "," +
            " \"" + ingredient.getSeason() + "\");";
      executeUpdate(query);
   }

   @Override
   public void editIngredient(Ingredient ingredient) {
      String query = "UPDATE ingredients\n" +
            "SET name = \"" + ingredient.getName() + "\"," +
            " calories =" + ingredient.getCalories() + "," +
            " season = \"" + ingredient.getSeason() + "\"\n" +
            "WHERE id =" + ingredient.getId() + ";";
      executeUpdate(query);
   }

   @Override
   public void removeIngredient(int ingredientId) {
      String query = "DELETE FROM ingredients WHERE id=" + ingredientId;

      executeUpdate(query);
   }

   @Override
   public Ingredient getIngredientById(int ingredientId) {
      String query = "SELECT *\n" +
            "FROM ingredients\n" +
            "WHERE id = " + ingredientId;
      connection = ConnectionFactory.getConnection();
      Ingredient ingredient = null;
      try {
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(query);

         while (resultSet.next()) {
            ingredient = newIngredient(resultSet.getLong("id"),
                  resultSet.getString("name"),
                  resultSet.getInt("calories"),
                  resultSet.getString("season"));
         }

      } catch (SQLException e) {
         e.printStackTrace();
      }

      return ingredient;
   }

   public Ingredient getIngredientById(int ingredientId) {
      String query = "SELECT *\n" +
              "FROM ingredients\n" +
              "WHERE id = " + ingredientId;
      connection = ConnectionFactory.getConnection();
      Ingredient ingredient = null;
      try {
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(query);

         while (resultSet.next()) {
            ingredient = newIngredient(resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("calories"),
                    resultSet.getString("season"));
         }

      } catch (SQLException e) {
         e.printStackTrace();
      }

      return ingredient;
   }

   @Override
   public HashSet<Ingredient> getIngredients() {

      String query = "SELECT * FROM ingredients";
      HashSet<Ingredient> ingredients = new HashSet<>();
      connection = ConnectionFactory.getConnection();

      try {
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(query);

         while (resultSet.next()) {
            ingredients.add(newIngredient(resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("calories"),
                    resultSet.getString("season")));
         }

      } catch (SQLException e) {
         e.printStackTrace();
      }

      return ingredients;
   }

   private Ingredient newIngredient(long id, String name, int calories, String season) {
      Ingredient ingredient = new Ingredient();
      ingredient.setId(id);
      ingredient.setName(name);
      ingredient.setCalories(calories);
      ingredient.setSeason(season);
      return ingredient;
   }

   private void executeUpdate(String query) {
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
   }
}
