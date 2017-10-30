package com.yandm.assir.service.impl;

import com.yandm.assir.dao.IngredientDao;
import com.yandm.assir.dao.impl.IngredientDaoImpl;
import com.yandm.assir.model.Ingredient;
import com.yandm.assir.service.IngredientService;

import java.util.Set;

public class IngredientServiceImpl implements IngredientService {

    private IngredientDao ingredientDao = new IngredientDaoImpl();

    @Override
    public Set<Ingredient> getIngredients() {
        return ingredientDao.getIngredients();
    }
}
