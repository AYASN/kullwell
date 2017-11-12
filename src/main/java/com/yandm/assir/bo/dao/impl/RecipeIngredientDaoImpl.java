package com.yandm.assir.bo.dao.impl;

import com.yandm.assir.dao.ConnectionFactory;
import com.yandm.assir.dao.DbUtil;
import com.yandm.assir.bo.dao.RecipeIngredientDao;
import com.yandm.assir.model.Ingredient;

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
    public List<Ingredient> getIngredientsOfRecipe(Long recipeId) {

        String query = "SELECT i.id, i.name, i.calories, i.season FROM recipes_ingredients AS ri\n" +
                "INNER JOIN ingredients AS i ON ri.id_ingredients = i.id\n" +
                "WHERE ri.id_recipe = " + recipeId + ";";

        connection = ConnectionFactory.getConnection();
        List<Ingredient> ingredients = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                int calories = resultSet.getInt("calories");
                String season = resultSet.getString("season");

                ingredients.add(newIngredient(id, name, calories, season));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ingredients;
    }

    @Override
    public void insertIngredientsOfRecipeIds(List<Ingredient> ingredients, Long recipeId) {

        for (int i=0; i < ingredients.size(); i++) {
            String query = "INSERT INTO recipes_ingredients (id_recipe, id_ingredients, quantity) VALUES\n" +
                    "  (" + recipeId + ", " + ingredients.get(i).getId() + ", \"\");";
            executeUpdate(query);
        }
    }

    @Override
    public void editIngredientsOfRecipe(List<Ingredient> ingredients, Long recipeId) {
        String query = "DELETE FROM recipes_ingredients WHERE id_recipe = " + recipeId + ";";
        executeUpdateWoutClose(query);

        for (int i=0; i < ingredients.size(); i++) {
            query = "INSERT INTO recipes_ingredients (id_recipe, id_ingredients, quantity) VALUES\n" +
                "(" + recipeId + "," + ingredients.get(i).getId() + ",\"\");";
            executeUpdate(query);
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

    private Ingredient newIngredient(long id, String name, int calories, String season) {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(id);
        ingredient.setName(name);
        ingredient.setCalories(calories);
        ingredient.setSeason(season);
        return ingredient;
    }
}