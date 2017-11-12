package com.yandm.assir.bo.service;

import java.util.List;
import java.util.Set;
import com.yandm.assir.model.Ingredient;

public interface IngredientService {
    Set<Ingredient> getIngredients();

    List<Ingredient> getIngredientsById(String strIngredientsIds);
}