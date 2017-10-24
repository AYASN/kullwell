package com.yandm.assir.dao.impl;

import com.yandm.assir.dao.ConnectionFactory;
import com.yandm.assir.dao.DbUtil;
import com.yandm.assir.dao.RecipeIngrdDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RecipeIngrdDaoImpl implements RecipeIngrdDao{
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
