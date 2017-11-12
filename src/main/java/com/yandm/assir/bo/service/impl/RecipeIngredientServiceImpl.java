package com.yandm.assir.bo.service.impl;

import com.yandm.assir.bo.dao.RecipeIngredientDao;
import com.yandm.assir.bo.dao.impl.RecipeIngredientDaoImpl;
import com.yandm.assir.model.Ingredient;
import com.yandm.assir.bo.service.RecipeIngredientService;

import java.util.List;

public class RecipeIngredientServiceImpl implements RecipeIngredientService {

    RecipeIngredientDao recipeIngredientDao = new RecipeIngredientDaoImpl();

    @Override
    public List<Ingredient> getIngredientsOfRecipe(Long recipeId) {
        return recipeIngredientDao.getIngredientsOfRecipe(recipeId);
    }
}
