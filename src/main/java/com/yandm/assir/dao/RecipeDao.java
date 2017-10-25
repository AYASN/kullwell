package com.yandm.assir.dao;

import java.util.Set;
import com.yandm.assir.model.Recipe;

public interface RecipeDao {

    void addRecipe(Recipe recipe);

    Recipe getRecipeByName(String recipeName);

   Set<Recipe> getRecipes();
}
