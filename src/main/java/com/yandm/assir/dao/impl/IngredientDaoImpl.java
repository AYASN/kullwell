package com.yandm.assir.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.yandm.assir.dao.ConnectionFactory;
import com.yandm.assir.dao.DbUtil;
import com.yandm.assir.dao.IngredientDao;
import com.yandm.assir.model.Ingredient;

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
   public List<Ingredient> getIngredientsById(String strIngredientsIds) {
      String query = "SELECT *\n" +
            "FROM ingredients\n" +
            "WHERE id IN (" + strIngredientsIds + ");";
      connection = ConnectionFactory.getConnection();
      List<Ingredient> ingredients = new ArrayList<>();

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

   @Override
   public HashSet<Ingredient> getIngredients() {

      String query = "SELECT * FROM ingredients ORDER BY id";
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
