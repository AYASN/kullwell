package com.yandm.assir.dao;

import java.util.List;

public interface RecipeIngrdDao {

    public void addIds(Long recipeId, Long ingredientId);

    List<Long> getIngredientsOfRecipe(Long recipeId);
}
