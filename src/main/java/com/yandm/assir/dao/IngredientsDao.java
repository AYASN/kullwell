package com.yandm.assir.dao;

import com.yandm.assir.model.Ingredient;

public interface IngredientsDao {

   void addIngredient(Ingredient ingredient);

   void editIngredient(Ingredient ingredient);

   void removeIngredient(int ingredientId);

   Ingredient getIngredientById(int ingredientId);
}
