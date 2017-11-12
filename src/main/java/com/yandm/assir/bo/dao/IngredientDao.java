package com.yandm.assir.bo.dao;

import com.yandm.assir.model.Ingredient;

import java.util.List;
import java.util.Set;

public interface IngredientDao {

   void addIngredient(Ingredient ingredient);

   void editIngredient(Ingredient ingredient);

   void removeIngredient(int ingredientId);

   List<Ingredient> getIngredientsById(String strIngredientsIds);

    Set<Ingredient> getIngredients();
}
