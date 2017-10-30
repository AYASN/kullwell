package com.yandm.assir.dao.impl;

import com.yandm.assir.dao.ConnectionFactory;
import com.yandm.assir.dao.DbUtil;
import com.yandm.assir.dao.RecipeIngredientDao;
import com.yandm.assir.model.Ingredient;
import com.yandm.assir.model.Recipe;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RecipeIngredientDaoImpl implements RecipeIngredientDao {
    private Connection connection;
    private Statement statement;

    @Override
    public void addIds(Long recipeId, Long ingredientId) {
        String query = "INSERT INTO recipes_ingredients (id_recipes, id_ingredients)\n" +
                "values (" + recipeId + ", "
                + ingredientId + ")";
        executeUpdate(query);
    }

    @Override
    public List<Long> getIngredientsOfRecipe(Long recipeId) {

        String query = "SELECT *\n" +
                "FROM recipes_ingredients\n" +
                "WHERE id_recipes = " + recipeId;

        connection = ConnectionFactory.getConnection();
        List<Long> ingredientIds = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                ingredientIds.add(resultSet.getLong("id_ingredients"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ingredientIds;
    }

    @Override
    public void insertIngredientsOfRecipeIds(Recipe recipe, Long recipeID) {

        List<Ingredient> ingredients = recipe.getIngredients();
        int numberOfIngredients = ingredients.size();

        for (int i=0; i < numberOfIngredients; i++) {
            String query = "INSERT INTO recipes_ingredients (id_recipe, id_ingredients, quantity) VALUES\n" +
                    "  (" + recipeID + ", " + ingredients.get(i) + ", \"\");";
        }
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
