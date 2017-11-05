package com.yandm.assir.service.impl;

import com.yandm.assir.dao.RecipeIngredientDao;
import com.yandm.assir.dao.impl.RecipeIngredientDaoImpl;
import com.yandm.assir.model.Ingredient;
import com.yandm.assir.service.RecipeIngredientService;

import java.util.List;

public class RecipeIngredientServiceImpl implements RecipeIngredientService {

    RecipeIngredientDao recipeIngredientDao = new RecipeIngredientDaoImpl();

    @Override
    public List<Ingredient> getIngredientsOfRecipe(Long recipeId) {
        return recipeIngredientDao.getIngredientsOfRecipe(recipeId);
    }
}
