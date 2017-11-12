package com.yandm.assir.bo.service.impl;

import com.yandm.assir.bo.dao.IngredientDao;
import com.yandm.assir.bo.dao.impl.IngredientDaoImpl;
import com.yandm.assir.model.Ingredient;
import com.yandm.assir.bo.service.IngredientService;

import java.util.List;
import java.util.Set;

public class IngredientServiceImpl implements IngredientService {

    private IngredientDao ingredientDao = new IngredientDaoImpl();

    @Override
    public Set<Ingredient> getIngredients() {
        return ingredientDao.getIngredients();
    }

    @Override
    public List<Ingredient> getIngredientsById(String strIngredientsIds) {
        return ingredientDao.getIngredientsById(strIngredientsIds);
    }
}
