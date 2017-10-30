package com.yandm.assir.dao;

import com.yandm.assir.model.Recipe;

import java.util.List;

public interface RecipeIngredientDao {

    public void addIds(Long recipeId, Long ingredientId);

    List<Long> getIngredientsOfRecipe(Long recipeId);

    void insertIngredientsOfRecipeIds(Recipe recipe, Long recipeID);
}
