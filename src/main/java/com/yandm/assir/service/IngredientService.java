package com.yandm.assir.service;

import com.yandm.assir.model.Ingredient;

import java.util.List;
import java.util.Set;

public interface IngredientService {
    Set<Ingredient> getIngredients();

    List<Ingredient> getIngredientsById(String strIngredientsIds);
}