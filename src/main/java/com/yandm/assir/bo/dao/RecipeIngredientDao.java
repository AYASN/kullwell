package com.yandm.assir.bo.dao;

import java.util.List;
import com.yandm.assir.model.Ingredient;

public interface RecipeIngredientDao {

    void addIds(Long recipeId, Long ingredientId);

    List<Ingredient> getIngredientsOfRecipe(Long recipeId);

    void insertIngredientsOfRecipeIds(List<Ingredient> recipe, Long recipeID);

    void editIngredientsOfRecipe(List<Ingredient> ingredients, Long id);
}
