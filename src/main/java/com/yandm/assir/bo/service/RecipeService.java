package com.yandm.assir.bo.service;

import java.util.Set;
import com.yandm.assir.model.Recipe;

public interface RecipeService {
   Set<Recipe> getRecipes();

    void createRecipe(Recipe recipe);

    void editRecipe(Recipe recipe);

    void removeRecipe(Long id);
}
