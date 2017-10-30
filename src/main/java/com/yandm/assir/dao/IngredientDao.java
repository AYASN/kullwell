package com.yandm.assir.dao;

import com.yandm.assir.model.Ingredient;

import java.util.Set;

public interface IngredientDao {

   void addIngredient(Ingredient ingredient);

   void editIngredient(Ingredient ingredient);

   void removeIngredient(int ingredientId);

   Ingredient getIngredientById(int ingredientId);

    Set<Ingredient> getIngredients();
}
