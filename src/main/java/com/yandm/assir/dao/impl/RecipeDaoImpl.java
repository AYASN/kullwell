package com.yandm.assir.dao.impl;

import static java.util.Collections.emptyList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.yandm.assir.dao.ConnectionFactory;
import com.yandm.assir.dao.DbUtil;
import com.yandm.assir.dao.RecipeDao;
import com.yandm.assir.dao.RecipeIngredientDao;
import com.yandm.assir.model.Recipe;

public class RecipeDaoImpl implements RecipeDao {

   private Connection connection;
   private Statement statement;
   private RecipeIngredientDao recipeIngredientDao = new RecipeIngredientDaoImpl();

   @Override
   public Long addRecipe(Recipe recipe) {
      String query = "INSERT INTO recipes (name, description, cuisine_type)\n" +
            "values (\"" + recipe.getName() + "\", "
            + "\"" + recipe.getDescription() + "\","
            + "\"" + recipe.getCuisineType() + "\");";
      executeUpdateWoutClose(query);

      String queryForID = "SELECT LAST_INSERT_ROWID();";
      Long recipeID = null;
      try {
          Statement statement = connection.createStatement();
          ResultSet resultSet = statement.executeQuery(queryForID);
         if (resultSet.next()) {
            recipeID = resultSet.getLong(1);
         }
      } catch (SQLException e) {
          e.printStackTrace();
      }
      return recipeID;
   }

   @Override
   public HashSet<Recipe> getRecipes() {
      String query = "SELECT * FROM recipes";
      HashSet<Recipe> recipes = new HashSet<>();
      connection = ConnectionFactory.getConnection();
      Recipe recipe = null;
      try {
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(query);

         while (resultSet.next()) {
            Long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            String description = resultSet.getString("description");
            String cuisine_type = resultSet.getString("cuisine_type");

            List<Long> ingredientIds = recipeIngredientDao.getIngredientsOfRecipe(id);

            recipes.add(newRecipe(id, name, description, cuisine_type, ingredientIds));
         }

      } catch (SQLException e) {
         e.printStackTrace();
      }

      return recipes;
   }

   @Override
   public Set<Recipe> getRecipesByIdIngredients(List idIngredients) {
      String query = "SELECT ri.id_ingredients, r.id, r.name, r.description, r.cuisine_type " +
            "FROM recipes_ingredients AS ri  " +
            "INNER JOIN recipes AS r " +
            "On ri.id_recipes = r.id " +
            "WHERE ri.id_ingredients in " + formatIds(idIngredients) + ";";

      connection = ConnectionFactory.getConnection();
      Set<Recipe> recipes = new HashSet<>();
      try {
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(query);

         while (resultSet.next()) {
            recipes.add(newRecipe(resultSet.getLong("id"),
                  resultSet.getString("name"),
                  resultSet.getString("description"),
                  resultSet.getString("cuisine_type")));
         }

      } catch (SQLException e) {
         e.printStackTrace();
      }

      return recipes;
   }

   private Recipe newRecipe(long id, String name, String description, String cuisine_type) {
      return newRecipe(id,name,description,cuisine_type, emptyList());
   }

   static String formatIds(List<Long> idIngredients) {
      StringBuilder result = new StringBuilder("(");
      for (Long idIngredient : idIngredients) {
         result.append(idIngredient);
         result.append(",");
      }
      int lastCommaIndex = result.lastIndexOf(",");
      result.replace(lastCommaIndex, lastCommaIndex + 1, ")");
      return result.toString();
   }

   @Override
   public void editRecipe(Recipe recipe) {
      String query = "UPDATE recipes\n" +
              "SET name = \"" + recipe.getName() + "\"," +
              "description = \"" + recipe.getDescription() + "\"," +
              "cuisine_type = \"" + recipe.getCuisineType() + "\"\n" +
              "WHERE id = " + recipe.getId() + ";";
      executeUpdate(query);
   }

   @Override
   public void removeRecipe(Long id) {
      String query = "DELETE FROM recipes WHERE id= " + id + ";";
      executeUpdateWoutClose(query);

      //remove from rec_ingrd also
      query = "DELETE FROM recipes_ingredients WHERE id_recipe = " + id + ";";
      executeUpdate(query);
   }

   @Override
   public Recipe getRecipeByName(String recipeName) {
      String query = "SELECT *" +
            "FROM recipes " + recipeName + "";

      connection = ConnectionFactory.getConnection();
      Recipe recipe = null;
      try {
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(query);

         while (resultSet.next()) {
            List<Long> ingredientIds = null;
            recipe = newRecipe(resultSet.getLong("id"),
                  resultSet.getString("name"),
                  resultSet.getString("description"),
                  resultSet.getString("cuisine_type"), ingredientIds);
         }

      } catch (SQLException e) {
         e.printStackTrace();
      }

      return recipe;
   }

   private Recipe newRecipe(long id, String name, String description, String cuisine_type, List<Long> ingredientIds) {
      Recipe recipe = new Recipe();
      recipe.setId(id);
      recipe.setName(name);
      recipe.setDescription(description);
      recipe.setCuisineType(cuisine_type);
      recipe.setIngredients(ingredientIds);
      return recipe;
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

   private void executeUpdateWoutClose(String query) {
      connection = ConnectionFactory.getConnection();
      try {
         statement = connection.createStatement();
         statement.executeUpdate(query);
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         DbUtil.close(statement);
      }
   }
}