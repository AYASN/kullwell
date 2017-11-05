package com.yandm.assir.dao;

import com.yandm.assir.model.Ingredient;

import java.util.List;

public interface RecipeIngredientDao {

    void addIds(Long recipeId, Long ingredientId);

    List<Ingredient> getIngredientsOfRecipe(Long recipeId);

    void insertIngredientsOfRecipeIds(List<Ingredient> recipe, Long recipeID);

    void editIngredientsOfRecipe(List<Ingredient> ingredients, Long id);
}
