package com.yandm.assir.dao;

import java.util.List;

public interface RecipeIngredientDao {

    public void addIds(Long recipeId, Long ingredientId);

    List<Long> getIngredientsOfRecipe(Long recipeId);

    void insertIngredientsOfRecipeIds(List<Long> recipe, Long recipeID);

    void editIngredientsOfRecipe(List<Long> ingredients, Long id);
}
