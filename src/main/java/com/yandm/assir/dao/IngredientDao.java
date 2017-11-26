package com.yandm.assir.dao;

import java.util.List;
import java.util.Set;
import com.yandm.assir.model.Ingredient;

public interface IngredientDao {

   void addIngredient(Ingredient ingredient);

   void editIngredient(Ingredient ingredient);

   void removeIngredient(int ingredientId);

   List<Ingredient> getIngredientsById(String strIngredientsIds);

    Set<Ingredient> getIngredients();
}
