package com.yandm.assir.dao.impl;

import com.yandm.assir.dao.ConnectionFactory;
import com.yandm.assir.dao.DbUtil;
import com.yandm.assir.dao.RecipeDao;
import com.yandm.assir.model.Recipe;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RecipeDaoImpl implements RecipeDao {

    private Connection connection;
    private Statement statement;

    @Override
    public void addRecipe(Recipe recipe) {
        String query = "INSERT INTO recipes (name, description, cuisine_type)\n" +
                "values (\"" + recipe.getName() + "\", "
                + "\"" + recipe.getDescription() + "\","
                + "\"" + recipe.getCuisine_type() + "\");";
        executeUpdate(query);
    }

    @Override
    public Recipe getRecipeByName(String recipeName) {
        String query = "SELECT *\n" +
                "FROM recipes\n" +
                "WHERE name = \"" + recipeName + "\"";

        connection = ConnectionFactory.getConnection();
        Recipe recipe = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                recipe = newRecipe(resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getString("cuisine_type"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return recipe;
    }

    private Recipe newRecipe(long id, String name, String description, String cuisine_type) {
        Recipe recipe = new Recipe();
        recipe.setId(id);
        recipe.setName(name);
        recipe.setDescription(description);
        recipe.setCuisine_type(cuisine_type);
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
}
