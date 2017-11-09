package com.yandm.assir.dao;

import java.util.List;
import java.util.Set;
import com.yandm.assir.model.Recipe;

public interface RecipeDao {

    Long addRecipe(Recipe recipe);

    Recipe getRecipeByName(String recipeName);

   Set<Recipe> getRecipes();

   Set<Recipe> getRecipesByIdIngredients(List idIngredients);

    void editRecipe(Recipe recipe);

    void removeRecipe(Long id);
}