package com.yandm.assir.service;

import java.util.List;
import java.util.Set;
import com.yandm.assir.model.Recipe;

public interface RecipeService {
   Set<Recipe> getRecipes();

   Set<Recipe> getRecipesByIdIngredients(List idIngredients);

    void createRecipe(Recipe recipe);

    void editRecipe(Recipe recipe);

    void removeRecipe(Long id);
}
