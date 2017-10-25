package com.yandm.assir.service.impl;

import java.util.Set;
import com.yandm.assir.dao.RecipeDao;
import com.yandm.assir.dao.impl.RecipeDaoImpl;
import com.yandm.assir.model.Recipe;
import com.yandm.assir.service.RecipeService;

public class RecipeServiceImpl implements RecipeService {
   private RecipeDao recipeDao = new RecipeDaoImpl();

   @Override
   public Set<Recipe> getRecipes() {
      return recipeDao.getRecipes();
   }
}
