package com.yandm.assir.service;

import com.yandm.assir.model.Ingredient;

import java.util.List;

public interface RecipeIngredientService {

    List<Ingredient> getIngredientsOfRecipe(Long recipeId);

}
